/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.cpu;

import com.sankar.gbemu.mem.InterruptFlag;
import com.sankar.gbemu.clock.Clock;

/**
 *
 * @author minerva
 */
public enum Interrupt {
    VBlank  (0,0x40),
    LCDStat (1,0x48),
    Timer   (2,0x50),
    Serial  (3,0x58),
    Joypad  (4,0x60);
    
    private Interrupt(int bit, int addr) {
        this.bit = bit;
        this.mask = (byte)(1 << bit);
        this.addr = (short)(addr & 0xff);
    }
    
    public int bit() {
        return bit;
    }
    
    public byte mask() {
        return mask;
    }
    
    public void execute(CPU cpu, InterruptFlag iflag, Clock clock) {
        cpu.unhalt();
        cpu.resume();
        cpu.setIME(false);
        iflag.ackInterrupt(this);
        cpu.push16(cpu.rpc());
        cpu.wpc(addr);
        clock.doTicks(28);
    }
    
    private int bit;
    private byte mask;
    private short addr;
}
