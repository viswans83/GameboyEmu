/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.gpu;

import com.sankar.gbemu.mem.map.MemoryMapped;

/**
 *
 * @author minerva
 */
public class LCDStatusRegister implements MemoryMapped {
    
    private byte value;

    private static final int ADDR = 0xff41;
    
    @Override
    public boolean maps(short addr) {
        return (addr & 0xffff) == ADDR;
    }

    @Override
    public byte r8(short addr) {
        return value;
    }

    @Override
    public void w8(short addr, byte value) {
        int lowByte = this.value & 0x03;
        int highByte = value & 0xfc;
        this.value = (byte)(highByte | lowByte);
    }
    
    public boolean coincidenceInterruptEnable() {
        return (value & 0x40) != 0;
    }
    
    public boolean oamInterruptEnable() {
        return (value & 0x20) != 0;
    }
    
    public boolean vblankInterruptEnable() {
        return (value & 0x10) != 0;
    }
    
    public boolean hblankInterruptEnable() {
        return (value & 0x08) != 0;
    }
    
    public boolean coincidence() {
        return (value & 0x04) != 0;
    }
    
    public void setCoincidence(boolean b) {
        if (b)
            value = (byte)(value | 0x04);
        else
            value = (byte)(value & ~0x04);
    }
    
    public int mode() {
        return (value & 0x03);
    }
    
    public void setMode(int mode) {
        value = (byte)((((value & 0xff) >> 2) << 2) | mode);
    }
    
}
