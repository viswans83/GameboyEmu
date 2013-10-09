/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.joy;

import com.sankar.gbemu.mem.map.MemoryMapped;

/**
 *
 * @author minerva
 */
public class JoypadController implements MemoryMapped {
    
    private byte value;
    
    private static final int ADDR = 0xFF00;
    private static final int WMASK = 0x30;

    @Override
    public boolean maps(short addr) {
        return (addr & 0xffff) == ADDR;
    }

    @Override
    public byte r8(short addr) {
        return 0x0f;
    }

    @Override
    public void w8(short addr, byte value) {
        this.value = (byte)((this.value & ~WMASK) + (value & WMASK)); 
    }
    
}
