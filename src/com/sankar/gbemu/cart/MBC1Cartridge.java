/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.cart;

/**
 *
 * @author minerva
 */
public class MBC1Cartridge extends Cartridge {
    private int mode = 0;
    private int lowBits = 1;
    private int highBits = 0;
    
    public MBC1Cartridge(byte[] romBytes, byte[] ramBytes) {
        super(romBytes,ramBytes);
    }

    @Override
    protected void handleWrite(int addr, byte value) {
        if(addr >= 0x0000 && addr <= 0x1fff) {
            if((value & 0x0f) == 0x0a) 
                enableRam();
            else
                disableRam();
        } else if(addr >= 0x2000 && addr <= 0x3fff) {
            lowBits = value == 0x00 ? 1 : value & 0x1f;
            switchBanks();
        } else if(addr >= 0x4000 && addr <= 0x5fff) { 
            highBits = value & 0x3;
            switchBanks();
        } else if(addr >= 0x6000 && addr <= 0x7fff) { 
            mode = value & 0x1;
            switchBanks();
        } else if(addr >= 0xa000 && addr <= 0xbfff) {
            wram8(addr,value);
        }
    }

    private void switchBanks() {
        switch(mode) {
            case 0: setRomBank((highBits << 5) | lowBits); break;
            case 1: setRamBank(highBits); break;
        }
    }
}
