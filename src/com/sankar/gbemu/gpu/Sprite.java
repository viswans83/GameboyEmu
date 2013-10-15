/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.gpu;

import java.util.Comparator;

/**
 *
 * @author minerva
 */
public class Sprite {
    
    // To keep track of position of sprite in OAM to handle overlaps
    private int sequence;
    private int x;
    private int y;
    private int tileNumber;
    private boolean aboveBackground;
    private boolean xflip;
    private boolean yflip;
    private int paletteNumber;
    
    public Sprite(int sequence, byte[] data) {
        this.sequence = sequence;
        this.y = (data[0] & 0xff) - 16;
        this.x = (data[1] & 0xff) - 8;
        this.tileNumber = (data[2] & 0xff);
        
        byte attr = data[3];
        
        this.aboveBackground = (attr & 0x80) == 0;
        this.yflip = (attr & 0x40) != 0;
        this.xflip = (attr & 0x20) != 0;
        this.paletteNumber = (attr & 0x10) >> 4;
    }

    public int getTileNumber() {
        return tileNumber;
    }

    public boolean isAboveBackground() {
        return aboveBackground;
    }

    public int getPaletteNumber() {
        return paletteNumber;
    }
    
    public boolean isPointInsideSprite(int x, int y, boolean largeSprite) {
        if (largeSprite)
            return (x >= this.x && x < (this.x + 8)) && (y >= this.y && y < (this.y + 16));
        else
            return (x >= this.x && x < (this.x + 8)) && (y >= this.y && y < (this.y + 8));
    }
    
    public TileLocation getTileLocation(int x, int y, boolean largeSprites) {
        int xx = x - this.x;
        int yy = y - this.y;
        int tile;
        
        if (largeSprites) {
            if (yy < 8)
                tile = yflip ? this.tileNumber + 1 : this.tileNumber;
            else
                tile = yflip ? this.tileNumber : this.tileNumber + 1;
            if (xflip) xx = 7 - xx;
            if (yflip) yy = 15 - yy;
            if (yy >= 8) yy -= 8;
            return new TileLocation(xx, yy,tile);
        } else {
            if (xflip) xx = 7 - xx;
            if (yflip) yy = 7 - yy;
            tile = this.tileNumber;
            return new TileLocation(xx, yy,tile);
        }
    }
    
    public static final Comparator<Sprite> drawOrder = new Comparator<Sprite>() {
        @Override
        public int compare(Sprite o1, Sprite o2) {
            if (o1.x < o2.x)
                return -1;
            else if (o1.x == o2.x) 
                return (o1.sequence < o2.sequence) ? -1 : 1;
            else
                return 1;
        }
    };
    
    public static class TileLocation {
        public final int x;
        public final int y;
        public final int tile;
        
        public TileLocation(int x, int y, int tile) {
            this.x = x;
            this.y = y;
            this.tile = tile;
        }
        
    }
    
}
