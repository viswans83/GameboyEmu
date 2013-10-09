/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.mem.map;

/**
 *
 * @author minerva
 */
public class MemoryAccessViolation extends RuntimeException {
    private short addr;
    
    public MemoryAccessViolation(short addr) {
        this.addr = addr;
    }
    
    @Override
    public String getMessage() {
        return String.format("Address 0x%04X not mapped",addr);
    }
}
