/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.cart;

/**
 *
 * @author minerva
 */
public class RomRamCartridge extends Cartridge {
    
    public RomRamCartridge(byte[] rom, byte[] ram) {
        super(rom,ram);
    }

    @Override
    protected void handleWrite(int addr, byte value) {
        if(addr >= 0xa000 && addr <= 0xbfff) {
            wram8(addr,value);
        }
    }
    
}
