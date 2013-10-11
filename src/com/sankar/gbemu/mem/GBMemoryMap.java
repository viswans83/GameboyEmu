/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.mem;

import com.sankar.gbemu.cart.Cartridge;
import com.sankar.gbemu.cpu.Bin;
import com.sankar.gbemu.cpu.Timer;
import com.sankar.gbemu.gpu.DMAController;
import com.sankar.gbemu.gpu.LCDController;
import com.sankar.gbemu.joy.JoypadController;
import com.sankar.gbemu.mem.map.MMapComposite;
import com.sankar.gbemu.mem.map.MMapDummy;
import com.sankar.gbemu.mem.map.MMapRange;
import com.sankar.gbemu.mem.map.MemoryMapped;
import com.sankar.gbemu.serial.SerialController;
import com.sankar.gbemu.sound.SoundController;

/**
 *
 * @author minerva
 */
public class GBMemoryMap implements Memory, MemoryMapped {
    
    private MMapComposite mm = new MMapComposite();
    
    private InterruptFlag iflag;
    private InterruptEnable ienable;
    private MemoryMapped wram = new MMapRange(0xc000,0xdfff);
    private MemoryMapped unusable = new MMapRange(0xfea0,0xfeff);
    private MemoryMapped hram = new MMapRange(0xff80,0xfffe);
    
    private MemoryMapped echo = new MemoryMapped() {
        @Override
        public boolean maps(short addr) {
            int iaddr = addr & 0xffff;
            return (iaddr >= 0xe000 && iaddr <= 0xfdff);
        }
        @Override
        public byte r8(short addr) {
            return wram.r8((short)((addr & 0xffff) - 0x2000));
        }
        @Override
        public void w8(short addr, byte value) {
            wram.w8((short)((addr & 0xffff) - 0x2000),value);
        }
    };
    
    private MemoryMapped dummy = new MMapDummy();
    
    public GBMemoryMap(Cartridge cart, LCDController lcd, JoypadController joy, SoundController sound, SerialController serial, InterruptFlag iflag, InterruptEnable ienable, Timer timer) {
        this.iflag = iflag;
        this.ienable = ienable;
        
        mm.register(iflag);
        mm.register(ienable);
        mm.register(cart);
        mm.register(lcd);
        mm.register(wram);
        mm.register(echo);
        mm.register(joy);
        mm.register(new DMAController(this));
        mm.register(unusable);
        mm.register(timer);
        mm.register(sound);
        mm.register(serial);
        mm.register(hram);
        
        //Always register this last
        mm.register(dummy);
    }
    
    @Override
    public byte r8(short addr) {
        return mm.r8(addr);
    }

    @Override
    public short r16(short addr) {
        return Bin.make16(mm.r8((short)(addr + 1)),mm.r8(addr));
    }

    @Override
    public void w8(short addr, byte value) {
        mm.w8(addr,value);
    }

    @Override
    public void w16(short addr, short value) {
        mm.w8(addr, Bin.lowByte(value));
        mm.w8((short)(addr + 1), Bin.highByte(value));
    }
    
    public InterruptEnable getIE() {
        return ienable;
    }
    
    public InterruptFlag getIF() {
        return iflag;
    }

    @Override
    public boolean maps(short addr) {
        return mm.maps(addr);
    }
    
}
