/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.clock;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author minerva
 */
public class Clock {
    
    private long ticks = 0;
    private Map<String,ClockTrigger> triggers = new HashMap<String,ClockTrigger>();
    
    public void register(String name, ClockTrigger trigger) {
        triggers.put(name, trigger);
    }
    
    public ClockTrigger unregister(String name) {
        return triggers.remove(name);
    }
    
    public void doTicks(int ticks) {
        this.ticks += ticks;
        if (this.ticks > GBInterval.GB_CPU_HZ) {
            this.ticks -= GBInterval.GB_CPU_HZ;
        }
        
        publishTicks(ticks);
    }
    
    public long ticks() {
        return ticks;
    }
    
    private void publishTicks(int ticks) {
        for(ClockTrigger t : triggers.values()) {
            t.doTicks(ticks);
        }
    }
    
}
