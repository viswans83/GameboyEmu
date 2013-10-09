/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.gpu;

/**
 *
 * @author minerva
 */
public class Palette {
    
    private byte value;
    
    public Palette(byte value) {
        this.value = value;
    }
    
    public int getColor(int i) {
        return ((value & (0x03 << (i*2))) >> (i*2));
    }
    
}
