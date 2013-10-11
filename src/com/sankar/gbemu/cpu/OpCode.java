/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.cpu;

import com.sankar.gbemu.clock.Clock;
import com.sankar.gbemu.mem.Memory;

/**
 *
 * @author minerva
 */
public abstract class OpCode {
    private int opCode;
    private int size;
    private int clocks;
    private int jclocks;
    private String fmt;
    private boolean prefixed;
    private ArgType argType;
    
    public OpCode(int opCode, int size, int clocks, String fmt) {
        this.opCode = opCode;
        this.size = size;
        this.clocks = clocks;
        this.fmt = fmt;
        init();
    }
    
    public OpCode(int opCode, int size, int clocks, int jclocks, String fmt) {
        this(opCode,size,clocks,fmt);
        this.jclocks = jclocks;
    }
    
    private void init() {
        prefixed = isPrefixOp(opCode);
        if (prefixed) {
            argType = ArgType.NoArgs;
        } else {
            if (size == 1) argType = ArgType.NoArgs;
            if (size == 2) argType = ArgType.Arg8Bit;
            if (size == 3) argType = ArgType.Arg16Bit;
        }
    }
    
    private static boolean isPrefixOp(int opCode) {
        return (opCode & 0xFF00) == 0xCB00;
    }
    
    public final void execute(CPU cpu, Memory mem, Clock clock) {
        short orig_pc = cpu.rpc();
        
        switch(argType) {
            case NoArgs:
                execute0(cpu,mem);
                break;
            case Arg8Bit:
                execute8(cpu,mem,fetch8BitArg(mem,cpu.rpc()));
                break;
            case Arg16Bit:
                execute16(cpu,mem,fetch16BitArg(mem,cpu.rpc()));
                break;
        }
        
        short new_pc = cpu.rpc();
        
        boolean jumped = orig_pc != new_pc;
        
        if (!jumped) advancepc(cpu);
        
        doClocks(clock,jumped);
    }
    
    protected void advancepc(CPU cpu) {
        cpu.wpc((short)(cpu.rpc() + size));
    }
    
    protected void doClocks(Clock clock, boolean jumped) {
        if(jumped)
            clock.doTicks(jclocks);
        else
            clock.doTicks(clocks);
    }
    
    private byte fetch8BitArg(Memory mem, short addr) {
        return mem.r8((short)(addr+1));
    }
    
    private short fetch16BitArg(Memory mem, short addr) {
        return mem.r16((short)(addr+1));
    }
    
    protected void execute0(CPU cpu, Memory mem) {
        throw new UnsupportedOperationException(String.format("Unsupported OPCODE %s without argument",opCode));
    };
    
    protected void execute8(CPU cpu, Memory mem, byte arg) {
        throw new UnsupportedOperationException(String.format("Unsupported OPCODE %s with one-byte argument",opCode));
    }
    
    protected void execute16(CPU cpu, Memory mem, short arg) {
        throw new UnsupportedOperationException(String.format("Unsupported OPCODE %s with two-byte argument",opCode));
    }
    
    public boolean isPrefixed() {
        return prefixed;
    }
    
    public int code() {
        return opCode;
    }
    
    @Override
    public String toString() {
        return fmt;
    }
    
    public String toString(CPU cpu, Memory mem) {
        switch(argType) {
            case NoArgs:
                return String.format(fmt);
            case Arg8Bit:
                return String.format(fmt, fetch8BitArg(mem, cpu.rpc()));
            case Arg16Bit:
                return String.format(fmt, fetch16BitArg(mem, cpu.rpc()));
        }
        
        throw new AssertionError();
    }
    
    public static enum ArgType {
        NoArgs,Arg8Bit,Arg16Bit;
    }
}
