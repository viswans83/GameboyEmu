/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.mem.map;

/**
 *
 * @author minerva
 */
public class MMapRange implements MemoryMapped {
    private int startAddr, endAddr;
    private byte[] data;
    
    public MMapRange(int startAddr, int endAddr) {
        if(startAddr < 0 || endAddr < 0) throw new IllegalArgumentException("negative arguments");
        if(startAddr > endAddr) throw new IllegalArgumentException("invalid address range");
        
        this.startAddr = startAddr;
        this.endAddr = endAddr;
        this.data = new byte[endAddr - startAddr + 1];
    }
    
    @Override
    public byte r8(short addr) {
        return data[addr & 0xffff - startAddr];
    }
    
    @Override
    public void w8(short addr, byte value) {
        data[addr & 0xffff - startAddr] = value;
    }
    
    @Override
    public boolean maps(short addr) {
        int iaddr = addr & 0xffff;
        
        return iaddr >= startAddr && iaddr <= endAddr;
    }
}
