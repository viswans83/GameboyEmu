/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.gpu;

/**
 * Represents an 8x8 tile of color numbers. A tile is made up of 16 bytes
 * with every two bytes representing colors of the 8 pixels in a single line.
 * The bytes are ordered by increasing Y coordinate.
 * 
 * @author minerva
 */
public class Tile {
    
    private byte[] bytes;
    
    public Tile(byte[] bytes) {
        this.bytes = bytes;
    }
    
    /**
     * 
     * @param x zero indexed X coordinate (starting from the left edge)
     * @param y zero indexed Y coordinate (starting from the top  edge)
     * @return The color number (0 - 3)
     */
    int colorNumber(int x, int y) {
        int offset = y * 2;     // each line occupies 2 bytes
        int mask = 0x80 >> x;   // byte 1 stores high bit with leftmost at bit 7
                                // byte 2 stores low  bit with leftmost at bit 7
        
        byte lowbits = bytes[offset];
        byte highbits = bytes[offset + 1];
        
        int color = 0;
        if ((highbits & mask) != 0) color += 2;
        if ((lowbits & mask) != 0) color += 1;
        
        return color;
    }
}
