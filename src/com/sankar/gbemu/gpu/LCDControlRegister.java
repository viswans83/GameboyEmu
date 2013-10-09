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
public class LCDControlRegister implements MemoryMapped {
    
    private byte value;

    private static final int ADDR = 0xff40;

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
        this.value = value;
    }
    
    public boolean lcdEnabled() {
        return (value & 0x80) != 0;
    }
    
    public short getWindowTileMapAddr() {
        return (short)((value & 0x40) != 0 ? 0x9c00 : 0x9800);
    }
    
    public boolean windowEnabled() {
        return (value & 0x20) != 0;
    }
    
    public short getTileDataAddr() {
        return (short)((value & 0x10) != 0 ? 0x8000 : 0x8800);
    }
    
    public short getBackgroundTileMapAddr() {
        return (short)((value & 0x08) != 0 ? 0x9c00 : 0x9800);
    }
    
    public boolean largeSprites() {
        return (value & 0x04) != 0;
    }
    
    public boolean spritesEnabled() {
        return (value & 0x02) != 0;
    }
    
    public boolean bgDisplay() {
        return (value & 0x01) != 0;
    }
    
}
