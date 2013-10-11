/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.serial;

import com.sankar.gbemu.mem.map.MMapUnique;
import com.sankar.gbemu.mem.map.MemoryMapped;

/**
 *
 * @author minerva
 */
public class SerialController implements MemoryMapped {
    
    private MMapUnique mmap = new MMapUnique.Builder().add(0xff01,0xff02).build();
    
    @Override
    public boolean maps(short addr) {
        return mmap.maps(addr);
    }

    @Override
    public byte r8(short addr) {
        return mmap.r8(addr);
    }

    @Override
    public void w8(short addr, byte value) {
        mmap.w8(addr, value);
    }
    
}