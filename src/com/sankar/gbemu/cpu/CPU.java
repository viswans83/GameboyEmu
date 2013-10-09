/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.cpu;

import com.sankar.gbemu.mem.InterruptEnable;
import com.sankar.gbemu.mem.InterruptFlag;
import com.sankar.gbemu.clock.Clock;
import com.sankar.gbemu.mem.GBMemoryMap;
import com.sankar.gbemu.mem.Memory;

/**
 *
 * @author minerva
 */
public class CPU {
    
    private short reg_pc;
    private short reg_sp;
    private byte reg_a, reg_f;
    private byte reg_b, reg_c;
    private byte reg_d, reg_e;
    private byte reg_h, reg_l;
    
    private InstructionSet ops = new InstructionSet();
    
    //Interrupt master enable flag
    private boolean ime;
    
    //Halted
    private boolean halted;
    
    //Stopped
    private boolean stopped;
    
    //16-Bit Address Bus
    private Memory mem;
    
    //Clock counter
    private Clock clock;
    
    private InterruptFlag iflag;
    private InterruptEnable ienable;
    
    private final Flags flags;
    
    private int enableIMECtr = -1;
    private int disableIMECtr = -1;
    
    public CPU(GBMemoryMap mem, Clock clock) {
        this.mem = mem;
        this.clock = clock;
        this.iflag = mem.getIF();
        this.ienable = mem.getIE();
        this.flags = new Flags(this);
        init();
    }
    
    public final void init() {
        waf((short)0x01b0);
        wbc((short)0x0013);
        wde((short)0x00d8);
        whl((short)0x014d);
        wsp((short)0xfffe);
        wpc((short)0x0100);
        
        mem.w8((short)0xff05,(byte)0x00);
        mem.w8((short)0xff06,(byte)0x00);
        mem.w8((short)0xff07,(byte)0x00);
        mem.w8((short)0xff10,(byte)0x80);
        mem.w8((short)0xff11,(byte)0xbf);
        mem.w8((short)0xff12,(byte)0xf3);
        mem.w8((short)0xff14,(byte)0xbf);
        mem.w8((short)0xff16,(byte)0x3f);
        mem.w8((short)0xff17,(byte)0x00);
        mem.w8((short)0xff19,(byte)0xbf);
        mem.w8((short)0xff1a,(byte)0x7f);
        mem.w8((short)0xff1b,(byte)0xff);
        mem.w8((short)0xff1c,(byte)0x9f);
        mem.w8((short)0xff1e,(byte)0xbf);
        mem.w8((short)0xff20,(byte)0xff);
        mem.w8((short)0xff21,(byte)0x00);
        mem.w8((short)0xff22,(byte)0x00);
        mem.w8((short)0xff23,(byte)0xbf);
        mem.w8((short)0xff24,(byte)0x77);
        mem.w8((short)0xff25,(byte)0xf3);
        mem.w8((short)0xff26,(byte)0xf1);
        mem.w8((short)0xff40,(byte)0x91);
        mem.w8((short)0xff42,(byte)0x00);
        mem.w8((short)0xff43,(byte)0x00);
        mem.w8((short)0xff45,(byte)0x00);
        mem.w8((short)0xff47,(byte)0xfc);
        mem.w8((short)0xff48,(byte)0xff);
        mem.w8((short)0xff49,(byte)0xff);
        mem.w8((short)0xff4a,(byte)0x00);
        mem.w8((short)0xff4b,(byte)0x00);
        mem.w8((short)0xffff,(byte)0x00);
        
        ime = false;
    }
    
    public void ei() {
        enableIMECtr = 1;
    }
    
    public void di() {
        disableIMECtr = 1;
    }
    
    public short rpc() { return reg_pc; }
    public short rsp() { return reg_sp; }
    
    public void wpc(short val) { reg_pc = val; }
    public void wsp(short val) { reg_sp = val; }
    
    //8-Bit reads
    public byte ra() { return reg_a; }
    public byte rf() { return reg_f; }
    public byte rb() { return reg_b; }
    public byte rc() { return reg_c; }
    public byte rd() { return reg_d; }
    public byte re() { return reg_e; }
    public byte rh() { return reg_h; }
    public byte rl() { return reg_l; }
    
    //8-Bit writes
    public void wa(byte val) { reg_a = val; }
    public void wf(byte val) { reg_f = val; }
    public void wb(byte val) { reg_b = val; }
    public void wc(byte val) { reg_c = val; }
    public void wd(byte val) { reg_d = val; }
    public void we(byte val) { reg_e = val; }
    public void wh(byte val) { reg_h = val; }
    public void wl(byte val) { reg_l = val; }
    
    //16-Bit reads
    public short raf() { return Bin.make16(reg_a,reg_f); }
    public short rbc() { return Bin.make16(reg_b,reg_c); }
    public short rde() { return Bin.make16(reg_d,reg_e); }
    public short rhl() { return Bin.make16(reg_h,reg_l); }
    
    //16-Bit writes
    public void waf(short val) { reg_a = (byte)(val>>>8); reg_f = (byte)(val & 0x00ff); }
    public void wbc(short val) { reg_b = (byte)(val>>>8); reg_c = (byte)(val & 0x00ff); }
    public void wde(short val) { reg_d = (byte)(val>>>8); reg_e = (byte)(val & 0x00ff); }
    public void whl(short val) { reg_h = (byte)(val>>>8); reg_l = (byte)(val & 0x00ff); }
    
    void setIME(boolean val) {
        ime = val;
    }
    
    public Flags flags() {
        return flags;
    }
    
    public void push16(short val) {
        reg_sp -= 2;
        mem.w16(reg_sp,val);
    }
    
    public short pop16() {
        short result = mem.r16(reg_sp);
        reg_sp += 2;
        return result;
    }
    
    public boolean halted() {
        return halted;
    }
    
    public void halt() {
        halted = true;
    }
    
    public void unhalt() {
        halted = false;
    }
    
    public boolean stopped() {
        return stopped;
    }
    
    public void stop() {
        stopped = true;
    }
    
    public void resume() {
        stopped = false;
    }
    
    public void step() {
        calculateIME();
        if (!interrupted() && !(halted || stopped)) {
            OpCode opCode = fetchOp();
//            System.out.printf("%04X : (%04X) %-20s",reg_pc,opCode.code(),opCode.toString(this, mem));
//            System.out.printf("==> %s%n",this);
            opCode.execute(this,mem,clock);
        } else if (halted) {
            clock.doTicks(4);
        } else if (stopped) {
            //TODO: Figure out how clock should tick if CPU is in "stopped" mode
        } 
    }
    
    private void calculateIME() {
        if (enableIMECtr == 0) {
            ime = true;
            enableIMECtr = -1;
        } else if (enableIMECtr == 1) {
            enableIMECtr = 0;
        }
        
        if (disableIMECtr == 0) {
            ime = false;
            disableIMECtr = -1;
        } else if (disableIMECtr == 1) {
            disableIMECtr = 0;
        }
    }
    
    public void requestInterrupt(Interrupt i) {
        iflag.requestInterrupt(i);
    }
    
    private boolean interrupted() {
        if(ime) for (Interrupt intr : Interrupt.values()) {
            if(iflag.isRequested(intr) && ienable.isEnabled(intr)) {
//                System.out.printf("Interrupt: %-10s",intr);
//                System.out.printf("==> %s%n",this);
                intr.execute(this,iflag,clock);
                return true;    
            }
        }
        
        return false;
    }
    
    private OpCode fetchOp() {
        return ((mem.r8(reg_pc) & 0xff) == 0xCB) ? ops.decodePrefixOp(mem.r8((short)(reg_pc + 1))) : ops.decodeBasicOp(mem.r8(reg_pc));
    }
    
    @Override
    public String toString() {
        String cpuState = String.format("A:%02X F:%02X B:%02X C:%02X D:%02X E:%02X H:%02X L:%02X PC:%04X SP:%04X IME:%s",
                reg_a,reg_f,
                reg_b,reg_c,
                reg_d,reg_e,
                reg_h,reg_l,
                reg_pc,reg_sp,
                ime ? "1" : "0");
        
        return String.format("CPU (%s) Flags (%s)",cpuState,flags);
    }
}
