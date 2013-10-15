/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.gpu;

import com.sankar.gbemu.clock.Clock;
import com.sankar.gbemu.clock.ClockTrigger;
import com.sankar.gbemu.cpu.Interrupt;
import com.sankar.gbemu.gpu.Sprite.TileLocation;
import com.sankar.gbemu.mem.InterruptFlag;
import com.sankar.gbemu.mem.map.ByteRef;
import com.sankar.gbemu.mem.map.MMapByteRef;
import com.sankar.gbemu.mem.map.MMapComposite;
import com.sankar.gbemu.mem.map.MMapRange;
import com.sankar.gbemu.mem.map.MemoryMapped;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author minerva
 */
public class LCDController implements MemoryMapped, ClockTrigger {    
    
    private LCDControlRegister lcdc = new LCDControlRegister();
    private LCDStatusRegister lcds = new LCDStatusRegister();
    
    private byte scy,scx,ly,lyc,bgp,obp0,obp1,wy,wx;
    
    private MMapByteRef scym    = new MMapByteRef(0xff42,new ByteRef() {@Override public byte get(){return scy;}    @Override public void set(byte v) {scy = v;}});
    private MMapByteRef scxm    = new MMapByteRef(0xff43,new ByteRef() {@Override public byte get(){return scx;}    @Override public void set(byte v) {scx = v;}});
    private MMapByteRef lym     = new MMapByteRef(0xff44,new ByteRef() {@Override public byte get(){return ly;}     @Override public void set(byte v) {/*NOOP*/}});
    private MMapByteRef lycm    = new MMapByteRef(0xff45,new ByteRef() {@Override public byte get(){return lyc;}    @Override public void set(byte v) {lyc = v;}});
    private MMapByteRef bgpm    = new MMapByteRef(0xff47,new ByteRef() {@Override public byte get(){return bgp;}    @Override public void set(byte v) {bgp = v;}});
    private MMapByteRef obp0m   = new MMapByteRef(0xff48,new ByteRef() {@Override public byte get(){return obp0;}   @Override public void set(byte v) {obp0 = v;}});
    private MMapByteRef obp1m   = new MMapByteRef(0xff49,new ByteRef() {@Override public byte get(){return obp1;}   @Override public void set(byte v) {obp1 = v;}});
    private MMapByteRef wym     = new MMapByteRef(0xff4a,new ByteRef() {@Override public byte get(){return wy;}     @Override public void set(byte v) {wy = v;}});
    private MMapByteRef wxm     = new MMapByteRef(0xff4b,new ByteRef() {@Override public byte get(){return wx;}     @Override public void set(byte v) {wx = v;}});
    
    private MMapRange vram = new MMapRange(0x8000,0x9fff);
    private MMapRange oam = new MMapRange(0xfe00,0xfe9f);
    
    private MMapComposite mm = new MMapComposite();
    
    private int[][] lcdFBData = new int[160][144];
    
    private InterruptFlag iflag;
    
    private Collection<VBlankListener> vblankListeners = new ArrayList<VBlankListener>();
    
    private static final String LCD_TICK = "LCD_TICK";
    
    public LCDController(Clock clock, InterruptFlag iflag) {
        this.iflag = iflag;
        
        mm.register(lcdc);
        mm.register(lcds);
        mm.register(scym);
        mm.register(scxm);
        mm.register(lym);
        mm.register(lycm);
        mm.register(bgpm);
        mm.register(obp0m);
        mm.register(obp1m);
        mm.register(wym);
        mm.register(wxm);
        mm.register(vram);
        mm.register(oam);
        
        clock.register(LCD_TICK, this);
    }
    
    @Override
    public boolean maps(short addr) {
        return mm.maps(addr);
    }

    @Override
    public byte r8(short addr) {
        return mm.r8(addr);
    }

    @Override
    public void w8(short addr, byte value) {
        mm.w8(addr, value);
    }
    
    private boolean lcdRefresh = true;
    private int ticks_since_mode_2 = 0;
    private int ticks_since_mode_3 = 0;
    private int ticks_since_mode_0 = 0;
    private int ticks_since_mode_230 = 0;
    
    public void registerVBlankListener(VBlankListener vbl) {
        vblankListeners.add(vbl);
    }
    
    @Override
    public void doTicks(int ticks) {
        if (lcdRefresh) {
            // Start LCD refresh cycle
            lcdRefresh = false;
            ticks_since_mode_2 = ticks;
            lcds.setMode(2);
        } else if (lcds.mode() == 2) {
            // OAM access mode
            ticks_since_mode_2 += ticks;
            if (ticks_since_mode_2 > 80) {
                ticks_since_mode_3 = ticks_since_mode_2 - 80;
                ticks_since_mode_2 = 0;
                lcds.setMode(3);
            }
        } else if (lcds.mode() == 3) {
            // OAM + VRAM access mode
            ticks_since_mode_3 += ticks;
            if (ticks_since_mode_3 > 175) {
                if ((ly & 0xff) < 144) {
                    updateLCDForScanLine();
                }
                ticks_since_mode_0 = ticks_since_mode_3 - 175;
                ticks_since_mode_3 = 0;
                lcds.setMode(0);
                if (lcds.hblankInterruptEnable()) iflag.requestInterrupt(Interrupt.LCDStat);
            }
        } else if (lcds.mode() == 0) {
            // H-Blank mode
            ticks_since_mode_0 += ticks;
            if (ticks_since_mode_0 > 201) {
                ly++;
                if ((ly & 0xff) == 144) {
                    notifyVBlankListeners();
                    iflag.requestInterrupt(Interrupt.VBlank);
                    if (lcds.vblankInterruptEnable()) iflag.requestInterrupt(Interrupt.LCDStat);
                    ticks_since_mode_230 = ticks_since_mode_0 - 201;
                    lcds.setMode(1);
                } else {
                    ticks_since_mode_2 = ticks_since_mode_0 - 201;
                    lcds.setMode(2);
                }
                ticks_since_mode_0 = 0;
            }
        } else if (lcds.mode() == 1) {
            // V-Blank mode
            ticks_since_mode_230 += ticks;
            if (ticks_since_mode_230 > 456) {
                ly++;
                if ((ly & 0xff) == 154) {
                    ly = 0;
                    ticks_since_mode_2 = ticks_since_mode_230 - 456;
                    ticks_since_mode_230 = 0;
                    lcds.setMode(2);
                    lcdRefresh = true;
                } else {
                    ticks_since_mode_230 = 456 - ticks_since_mode_230;
                    if (ly == lyc) {
                        lcds.setCoincidence(true);
                        if (lcds.coincidenceInterruptEnable()) iflag.requestInterrupt(Interrupt.LCDStat);
                    } else {
                        lcds.setCoincidence(false);
                    }
                }
            }
        }
    }
    
    private void updateLCDForScanLine() {
        short bgTileMapAddr = lcdc.getBackgroundTileMapAddr();
        short tileDataAddr = lcdc.getTileDataAddr();
        
        Palette bgPalette = new Palette(bgp);
        Palette obp0Palette = new Palette(obp0);
        Palette obp1Palette = new Palette(obp1);
        Background bg = createBackground(bgTileMapAddr,tileDataAddr);
        Collection<Sprite> sprites = createSprites();
        
        boolean largeSprites = lcdc.largeSprites();
        for(int x = 0; x < 160; x++) {
            int bgColor = bg.getColorNumber((byte)((scx & 0xff) + x), (byte)((scy & 0xff) + (ly & 0xff)));
            int spriteColor = 0;
            int pixelColor;
            
            boolean spriteFound = false;
            boolean spriteOverrides = false;
            Palette spritePalette = null;
            for(Sprite sp : sprites) {
                if (sp.isPointInsideSprite(x, ly & 0xff, largeSprites)) {
                    spriteFound = true;
                    spriteOverrides = sp.isAboveBackground();
                    TileLocation tl = sp.getTileLocation(x, ly & 0xff, largeSprites);
                    Tile tile = createSpriteTile(tl.tile);
                    spritePalette = sp.getPaletteNumber() == 0 ? obp0Palette : obp1Palette;
                    spriteColor = tile.colorNumber(tl.x, tl.y);
                    break;
                }
            }
            
            if (spriteFound && (bgColor == 0 || (spriteOverrides && spriteColor != 0))) { 
                pixelColor = spritePalette.getColor(spriteColor);
            } else {
                pixelColor = bgPalette.getColor(bgColor);
            }
            
            lcdFBData[x][ly & 0xff] = pixelColor;
        }
        
    }
    
    private Tile createSpriteTile(int tileNum) {
        int base = 0x8000 + (tileNum * 16);
        byte[] tileBytes = new byte[16];
        
        for(int i = 0; i < 16; i++) 
            tileBytes[i] = vram.r8((short)(base + i));
        
        return new Tile(tileBytes);
    }
    
    private Collection<Sprite> createSprites() {
        List<Sprite> sprites = new ArrayList<Sprite>();
        
        for(int cnt = 0; cnt < 40; cnt++) {
            byte[] spriteData = new byte[4];

            int base = 0xfe00 + (cnt * 4);
            for(int i = 0; i < 4; i++) 
                spriteData[i] = oam.r8((short)(base + i));
            
            Sprite s = new Sprite(cnt,spriteData);
            sprites.add(s);
        }
        
        Collections.sort(sprites,Sprite.drawOrder);
        
        return sprites;
    }
    
    private Background createBackground(short bgTileMapAddr, short tileDataAddr) {
        boolean signedTileNumbers = (tileDataAddr & 0xffff) == 0x8800;
        
        final int TILE_MAP_DATA_SZ = 32*32;
        final int TILE_DATA_SZ = 256*16;
        
        byte[] tileMapData = new byte[TILE_MAP_DATA_SZ];
        byte[] tileData = new byte[TILE_DATA_SZ];
        
        for(int i = 0; i < TILE_MAP_DATA_SZ; i++) 
            tileMapData[i] = vram.r8((short)((bgTileMapAddr & 0xffff) + i));
        
        for(int i = 0; i < TILE_DATA_SZ; i++) 
            tileData[i] = vram.r8((short)((tileDataAddr & 0xffff) + i));
        
        return new Background(tileData, tileMapData, signedTileNumbers);
    }
    
    private void notifyVBlankListeners() {
        for(VBlankListener vbl : vblankListeners)
            vbl.vBlankOccured(lcdFBData);
    }
    
}
