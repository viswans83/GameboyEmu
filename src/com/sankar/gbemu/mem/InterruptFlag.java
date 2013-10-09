/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.mem;

import com.sankar.gbemu.mem.map.MemoryMapped;
import com.sankar.gbemu.cpu.Interrupt;

/**
 *
 * @author minerva
 */
public class InterruptFlag implements MemoryMapped {
    
    private byte value;
    
    private static final int ADDR = 0xFF0F;
    
    public InterruptFlag() {}
    
    public void requestInterrupt(Interrupt interrupt) {
        value = (byte)(value | interrupt.mask());
    }
    
    public boolean isRequested(Interrupt interrupt) {
        return (byte)(value & interrupt.mask()) != 0;
    }
    
    public void ackInterrupt(Interrupt interrupt) {
        value = (byte)(value & ~interrupt.mask());
    }

    @Override
    public boolean maps(short addr) {
        return ((addr & 0xffff) == ADDR);
    }

    @Override
    public byte r8(short addr) {
        return value;
    }

    @Override
    public void w8(short addr, byte value) {
        this.value = value;
    }
    
}
