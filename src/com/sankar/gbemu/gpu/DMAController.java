/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.gpu;

import com.sankar.gbemu.mem.ByteAccess;
import com.sankar.gbemu.mem.map.MemoryMapped;

/**
 *
 * @author minerva
 */
public class DMAController implements MemoryMapped {
    
    private ByteAccess mem;
    
    private static final int ADDR = 0xFF46;
    
    public DMAController(ByteAccess mem) {
        this.mem = mem;
    }
    
    @Override
    public boolean maps(short addr) {
        return (addr & 0xffff) == ADDR;
    }

    @Override
    public byte r8(short addr) {
        return 0;
    }

    @Override
    public void w8(short addr, byte value) {
        int start = (value & 0xff) << 8;
        int cnt = 0x100;
        
        if (start > 0xf100) throw new RuntimeException("Illegal DMA Transfer initiated");
        
        for(int i = 0; i < cnt; i++) mem.w8((short)(0xfe00 + i), mem.r8((short)(start + i)));
    }
    
}
