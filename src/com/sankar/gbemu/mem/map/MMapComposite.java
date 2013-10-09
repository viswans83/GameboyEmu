/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.mem.map;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author minerva
 */
public class MMapComposite implements MemoryMapped {
    
    private Collection<MemoryMapped> children = new ArrayList<MemoryMapped>();
    
    public void register(MemoryMapped mm) {
        children.add(mm);
    }
    
    @Override
    public boolean maps(short addr) {
        return find(addr).maps(addr);
    }

    @Override
    public byte r8(short addr) {
        return find(addr).r8(addr);
    }

    @Override
    public void w8(short addr, byte value) {
        find(addr).w8(addr, value);
    }
    
    private MemoryMapped find(short addr) {
        for(MemoryMapped mm : children)
            if(mm.maps(addr))
                return mm;
        
        return MemoryMapped.MM_ERROR;
    }
    
}
