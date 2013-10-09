/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.clock;

/**
 *
 * @author minerva
 */
public class GBInterval {
    public static final double GB_CPU_HZ = 4194304;
    
    public static long ticksFromHz(double hz) {
        return (long)(GB_CPU_HZ/hz);
    }
    
    public static long ticksFromKhz(double khz) {
        return (long)(GB_CPU_HZ/(khz * 1000));
    }
    
    public static long ticksFromMhz(double mhz) {
        return (long)(GB_CPU_HZ/(mhz * 1000000));
    }
    
}
