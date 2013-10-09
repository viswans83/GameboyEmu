/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.mem.map;

/**
 *
 * @author minerva
 */
public class MMapByteRef implements MemoryMapped {
    
    private short addr;
    private ByteRef br;
    
    public MMapByteRef(int addr, ByteRef br) {
        this.addr = (short)(addr & 0xffff);
        this.br = br;
    }
    
    @Override
    public boolean maps(short addr) {
        return addr == this.addr;
    }

    @Override
    public byte r8(short addr) {
        return br.get();
    }

    @Override
    public void w8(short addr, byte value) {
        br.set(value);
    }
    
}
