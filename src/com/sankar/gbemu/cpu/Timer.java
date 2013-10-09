/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.cpu;

import com.sankar.gbemu.clock.Clock;
import com.sankar.gbemu.clock.GBInterval;
import com.sankar.gbemu.clock.IntervalTrigger;
import com.sankar.gbemu.clock.TriggerAction;
import com.sankar.gbemu.mem.InterruptFlag;
import com.sankar.gbemu.mem.map.MemoryAccessViolation;
import com.sankar.gbemu.mem.map.MemoryMapped;

/**
 *
 * @author minerva
 */
public class Timer implements MemoryMapped {
    
    private byte div;
    private byte tima;
    private byte tma;
    private byte tac;
    
    private Clock clock;
    private InterruptFlag iflag;
    
    private TriggerAction tima_ta = new TriggerAction() {
        @Override
        public void execute() {
            tima += 1;
            if (tima == 0) {
                iflag.requestInterrupt(Interrupt.Timer);
                tima = tma;
            }
        }
    };
    
    private final IntervalTrigger T_00 = new IntervalTrigger(GBInterval.ticksFromHz(4096),tima_ta);
    private final IntervalTrigger T_01 = new IntervalTrigger(GBInterval.ticksFromHz(262144),tima_ta);
    private final IntervalTrigger T_02 = new IntervalTrigger(GBInterval.ticksFromHz(65536),tima_ta);
    private final IntervalTrigger T_03 = new IntervalTrigger(GBInterval.ticksFromHz(16384),tima_ta);
    
    private static final String T_DIV = "T_DIV";
    private static final String T_TIMA = "T_TIMA";
    
    public Timer(Clock clock, InterruptFlag iflag) {
        this.clock = clock;
        this.iflag = iflag;
        initTimer();
    } 
    
    private void initTimer() {
        TriggerAction div_ta = new TriggerAction() {
            @Override
            public void execute() {
                div += 1;
            }
        };
        IntervalTrigger div_t = new IntervalTrigger(GBInterval.ticksFromHz(16384),div_ta);
        clock.register(T_DIV,div_t);
    }
   
    @Override
    public boolean maps(short addr) {
        int iaddr = addr & 0xffff;
        return (iaddr >= 0xff04 && iaddr <= 0xff07);
    }

    @Override
    public byte r8(short addr) {
        switch(addr & 0xffff) {
            case 0xff04: return div;
            case 0xff05: return tima;
            case 0xff06: return tma;
            case 0xff07: return tac;
        }
        
        throw new MemoryAccessViolation(addr);
    }

    @Override
    public void w8(short addr, byte value) {
        switch(addr & 0xffff) {
            case 0xff04: div = 0; break;
            case 0xff05: tima = value; break;
            case 0xff06: tma = value; break;
            case 0xff07: tac = (byte)(value & 0x3); setTimer(); break;
            default: throw new MemoryAccessViolation(addr);
        }
    }
    
    private void setTimer() {
        boolean timerOn = (tac & 0x04) != 0;
        
        if (!timerOn) return;
        
        switch (tac & 0x3) {
            case 0: clock.register(T_TIMA, T_00); break;
            case 1: clock.register(T_TIMA, T_01); break;
            case 2: clock.register(T_TIMA, T_02); break;
            case 3: clock.register(T_TIMA, T_03); break;
        }
    }
    
}
