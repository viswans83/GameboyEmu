/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.cart;

import com.sankar.gbemu.cpu.Bin;
import com.sankar.gbemu.mem.map.MemoryAccessViolation;
import com.sankar.gbemu.mem.map.MemoryMapped;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author minerva
 */
public abstract class Cartridge implements MemoryMapped {
    private byte[] rom;
    private byte[] ram;
    
    private int rombank = 1;
    private int rambank = 0;
    
    private boolean ramEnabled = false;
    
    private final int ROM_BANK_SIZE = 0x4000;
    private final int RAM_BANK_SIZE = 0x2000;
    
    public Cartridge(byte[] rom) {
        this.rom = rom;
    }
    
    public Cartridge(byte[] rom, byte[] ram) {
        this.rom = rom;
        this.ram = ram;
    }
    
    @Override
    public boolean maps(short addr) {
        int iaddr = addr & 0xffff;
        
        return (iaddr >= 0 && iaddr <= 0x7fff) || (iaddr >= 0xa000 && iaddr <= 0xbfff);
    }

    @Override
    public byte r8(short addr) {
        int iaddr = Bin.toInt(addr);
        
        if(iaddr >= 0 && iaddr <= 0x3fff)
            return rom[iaddr];
        if(iaddr >= 0x4000 && iaddr <= 0x7fff)
            return rom[iaddr + (rombank - 1)*ROM_BANK_SIZE];
        if(iaddr >= 0xa000 && iaddr <= 0xbfff)
            return ram[iaddr + rambank*RAM_BANK_SIZE - 0xa000];
        
        throw new MemoryAccessViolation(addr);
    }

    @Override
    public void w8(short addr, byte value) {
        handleWrite(Bin.toInt(addr),value);
    }
    
    protected abstract void handleWrite(int addr, byte value);
    
    protected void setRomBank(int bank) {
        this.rombank = bank;
    }
    
    protected void setRamBank(int bank) {
        this.rambank = bank;
    }
    
    protected void wram8(int addr, byte value) {
        if (ramEnabled) ram[addr + rambank*RAM_BANK_SIZE - 0xa000] = value;
    }
    
    protected void enableRam() {
        ramEnabled = true;
    }
    
    protected void disableRam() {
        ramEnabled = false;
    }
    
    public static Cartridge load(String romFile) throws IOException {
        
        byte[] rom = readFile(romFile);
        
        CartInfo info = new CartInfo(rom);
        
        switch(info.getCartType()) {
            case RomOnly:
                return new RomOnlyCartridge(rom);
            case RomRam:
                return new RomRamCartridge(rom,new byte[info.getRamSize()]);
            case MBC1:
                return new MBC1Cartridge(rom, new byte[info.getRamSize()]);
            default:
                throw new RuntimeException(String.format("Unsupported Cartridge type: 0x%02X",info.getCartTypeCode()));
        }
    }
    
    private static byte[] readFile(String file) throws IOException {
        return readFile(new File(file));
    }

    private static byte[] readFile(File file) throws IOException {
        RandomAccessFile f = new RandomAccessFile(file, "r");
        
        try {
            int length = (int)f.length();
            byte[] data = new byte[length];
            f.readFully(data);
            return data;
        } finally {
            f.close();
        }
    }
}
