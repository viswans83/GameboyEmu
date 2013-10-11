/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.swing;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author minerva
 */
public class GBRenderer {
    
    private final int[][] screenData = new int[WIDTH][HEIGHT];
    
    public static final int WIDTH = 160;
    public static final int HEIGHT = 144;
    public static final int PIXEL_SIZE = 2;
    
    private final Color[] colors = new Color[4];
    
    public GBRenderer() {
        colors[0] = new Color(0x01ffa5);
        colors[1] = new Color(0xccb072);
        colors[2] = new Color(0x006642);
        colors[3] = new Color(0x051c12);
    }
    
    public void updateScreenData(int[][] screenData) {
        for(int x = 0; x < WIDTH; x++)
            System.arraycopy(screenData[x], 0, this.screenData[x], 0, HEIGHT);
    }
    
    public void render(Graphics g) {
        for(int x = 0; x < WIDTH; x++) {
            for(int y = 0; y < HEIGHT; y++) {
                g.setColor(colors[screenData[x][y]]);
                g.fillRect(x * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
            }
        }
    }
    
}
