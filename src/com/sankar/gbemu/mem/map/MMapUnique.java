/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.mem.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author minerva
 */
public class MMapUnique implements MemoryMapped {
    
    private Map<Short,Byte> data;
    
    public MMapUnique(Collection<Short> addrs) {
        data = new HashMap<Short,Byte>();
        for(Short addr : addrs) data.put(addr,(byte)0);
    }
    
    @Override
    public boolean maps(short addr) {
        return data.containsKey(addr);
    }

    @Override
    public byte r8(short addr) {
        return data.get(addr);
    }

    @Override
    public void w8(short addr, byte value) {
        data.put(addr, value);
    }
    
    public static class Builder {
        private Collection<Short> addr = new HashSet<Short>();
        
        public Builder add(int addr) {
            this.addr.add((short)addr);
            return this;
        }
        
        public Builder add(int from, int to) {
            for(int i = from; i <= to; i++)
                this.addr.add((short)i);
            
            return this;
        }
        
        public MMapUnique build() {
            return new MMapUnique(addr);
        }
    }
    
}
