/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.cart;

/**
 *
 * @author minerva
 */
public class RomOnlyCartridge extends Cartridge {
    
    public RomOnlyCartridge(byte[] rom) {
        super(rom);
    }
    
    @Override
    protected void handleWrite(int addr, byte value) {
        //Ignore writes
    }
    
}
