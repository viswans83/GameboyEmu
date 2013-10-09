/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.clock;

/**
 *
 * @author minerva
 */
public class IntervalTrigger implements ClockTrigger {
    
    private long ticks;
    private long maxTicks;
    private TriggerAction action;
    
    public IntervalTrigger(long maxTicks, TriggerAction action) {
        this.maxTicks = maxTicks;
        this.action = action;
    }
    
    public long unusedTicks() {
        return ticks;
    }
    
    @Override
    public final void doTicks(int ticks) {
        this.ticks += ticks;
        checkTrigger();
    }
    
    private void checkTrigger() {
        if (ticks >= maxTicks) {
            ticks -= maxTicks;
            action.execute();
        }
    }
}
