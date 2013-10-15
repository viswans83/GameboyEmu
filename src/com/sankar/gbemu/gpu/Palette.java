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
    
    public int getColor(int colorNumber) {
        return ((value & (0x03 << (colorNumber * 2))) >> (colorNumber * 2));
    }
    
}
