/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.sound;

import com.sankar.gbemu.mem.map.MMapUnique;
import com.sankar.gbemu.mem.map.MemoryMapped;

/**
 *
 * @author minerva
 */
public class SoundController implements MemoryMapped {
    
    private MMapUnique mmap = new MMapUnique.Builder().add(0xff10,0xff14)
                                                      .add(0xff16,0xff1e)
                                                      .add(0xff20,0xff26)
                                                      .add(0xff30,0xff3f)
                                                      .build();
    
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
