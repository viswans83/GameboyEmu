/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.mem.map;

/**
 *
 * @author minerva
 */
public class MMapDummy implements MemoryMapped {
    
    @Override
    public boolean maps(short addr) {
        System.out.printf("Not mapped: 0x%04X%n", (addr & 0xffff));
        return true;
    }

    @Override
    public byte r8(short addr) {
        return 0;
    }

    @Override
    public void w8(short addr, byte value) {
        //Do nothing
    }
    
};
