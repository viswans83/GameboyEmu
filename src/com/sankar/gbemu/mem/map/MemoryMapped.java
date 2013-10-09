/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.mem.map;

import com.sankar.gbemu.mem.ByteAccess;

/**
 *
 * @author minerva
 */
public interface MemoryMapped extends ByteAccess {
    boolean maps(short addr);
    
    public static final MemoryMapped MM_ERROR = new MemoryMapped() {
        @Override
        public boolean maps(short addr) {return false;}
        @Override
        public byte r8(short addr) {throw new MemoryAccessViolation(addr);}
        @Override
        public void w8(short addr, byte value) {throw new MemoryAccessViolation(addr);}
    };
}
