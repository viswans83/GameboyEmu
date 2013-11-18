/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.gpu;

import java.util.Arrays;

/**
 *
 * @author minerva
 */
public class Background {
    
    private byte[] tileData;
    private byte[] tileMapData;
    private boolean signedTileNumbers;
    
    public Background(byte[] tileData, byte[] tileMapData, boolean signedTileNumbers) {
        this.tileData = tileData;
        this.tileMapData = tileMapData;
        this.signedTileNumbers = signedTileNumbers;
    }
    
    public int getColorNumber(byte x, byte y) {
        int ix = x & 0xff;
        int iy = y & 0xff;
        
        byte bTileNum = tileMapData[((int)(iy/8))*32 + (int)(ix/8)];
        int tileNum = signedTileNumbers ? ((int)bTileNum + 128) : (bTileNum & 0xff);
        
        Tile tile = getTile(tileNum);
        
        int tile_xoff = ix % 8;
        int tile_yoff = iy % 8;
        
        return tile.colorNumber(tile_xoff,tile_yoff);
    }
    
    private Tile getTile(int tileNum) {
        int base = tileNum * 16;
        byte[] tileBytes = Arrays.copyOfRange(tileData, base, base + 16);
        return new Tile(tileBytes);
    }
    
}
