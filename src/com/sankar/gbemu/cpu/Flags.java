/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.cpu;

/**
 *
 * @author minerva
 */
public class Flags {
    private CPU cpu;
    
    public Flags(CPU cpu) {
        this.cpu = cpu;
    }
    
    public boolean rz() {
        return (cpu.rf() & 0x80) != 0;
    }
    
    public boolean rn() {
        return (cpu.rf() & 0x40) != 0;
    }
    
    public boolean rh() {
        return (cpu.rf() & 0x20) != 0;
    }
    
    public boolean rc() {
        return (cpu.rf() & 0x10) != 0;
    }
    
    public void setz() {
        cpu.wf((byte)(cpu.rf() | 0x80));
    }
    
    public void setn() {
        cpu.wf((byte)(cpu.rf() | 0x40));
    }
    
    public void seth() {
        cpu.wf((byte)(cpu.rf() | 0x20));
    }
    
    public void setc() {
        cpu.wf((byte)(cpu.rf() | 0x10));
    }
    
    public void clrz() {
        cpu.wf((byte)(cpu.rf() & ~0x80));
    }
    
    public void clrn() {
        cpu.wf((byte)(cpu.rf() & ~0x40));
    }
    
    public void clrh() {
        cpu.wf((byte)(cpu.rf() & ~0x20));
    }
    
    public void clrc() {
        cpu.wf((byte)(cpu.rf() & ~0x10));
    }
    
    public void wz(boolean v) {
        if(v) setz(); else clrz();
    }
    
    public void wn(boolean v) {
        if(v) setn(); else clrn();
    }
    
    public void wh(boolean v) {
        if(v) seth(); else clrh();
    }
    
    public void wc(boolean v) {
        if(v) setc(); else clrc();
    }
    
    @Override
    public String toString() {
        return String.format("Z-%s-N-%s-H-%s-C-%s",
                rz() ? "1" : "0",
                rn() ? "1" : "0",
                rh() ? "1" : "0",
                rc() ? "1" : "0");
    }
}
