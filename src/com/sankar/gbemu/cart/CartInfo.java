/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.cart;

/**
 *
 * @author minerva
 */
public class CartInfo {
    private String title;
    private int cartTypeCode;
    private Type cartType;
    private int romSize;
    private int ramSize;
    
    public static final int ROM_BANK_SZ = 0x4000;
    public static final int RAM_BANK_SZ = 0x2000;
    
    public CartInfo(byte[] rom) {
        //Title
        StringBuilder titlesb = new StringBuilder();
        for(int i = 0x0134; i <= 0x0143; i++) {
            if(rom[i] != 0) titlesb.appendCodePoint(rom[i] & 0xff);
        }
        title = titlesb.toString();
        
        //CartTypeCode
        cartTypeCode = rom[0x0147] & 0xff;
        
        //CartType
        switch(rom[0x0147]) {
            case 0x00: 
                cartType = Type.RomOnly; 
                break;
            case 0x08:
            case 0x09: 
                cartType = Type.RomRam; 
                break;
            case 0x01: 
                cartType = Type.MBC1;
                break;
            default:
                cartType = Type.Unknown;
                break;
        }
        
        //RomSize
        romSize = 32000 << (rom[0x0148] & 0xff);
        
        //RamSize
        switch(rom[0x0149]) {
            case 0x00: ramSize = 0;         break;
            case 0x01: ramSize = 1024 * 2;  break;
            case 0x02: ramSize = 1024 * 8;  break;
            case 0x03: ramSize = 1024 * 32; break;
        }
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getCartTypeCode() {
        return cartTypeCode;
    }
    
    public Type getCartType() {
        return cartType;
    }
    
    public int getRomSize() {
        return romSize;
    }
    
    public int getRomBankCount() {
        return romSize / ROM_BANK_SZ;
    }
    
    public int getRamSize() {
        return ramSize;
    }
    
    public int getRamBankCount() {
        return ramSize / RAM_BANK_SZ;
    }
    
    public static enum Type {RomOnly,RomRam,MBC1,Unknown}
}
