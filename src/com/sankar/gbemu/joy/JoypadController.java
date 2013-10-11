/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.joy;

import com.sankar.gbemu.clock.Clock;
import com.sankar.gbemu.clock.ClockTrigger;
import com.sankar.gbemu.cpu.Interrupt;
import com.sankar.gbemu.mem.InterruptFlag;
import com.sankar.gbemu.mem.map.MemoryMapped;

/**
 *
 * @author minerva
 */
public class JoypadController implements MemoryMapped, ClockTrigger {
    
    private InterruptFlag iflag;
    private int mode = 0;
    
    private static final int MODE_DIRECTION = 1;
    private static final int MODE_BUTTON = 2;
    private static final int MODE_BOTH = 3;
    
    private static final int ADDR = 0xFF00;
    private static final int WRITE_MASK = 0x30;
    
    private static final String JOY_TICK = "JOY_TICK";
    
    final Key[] MODE_KEYS = new Key[]{Key.Start, Key.Select, Key.B, Key.A};
    final Key[] DIR_KEYS = new Key[]{Key.Down, Key.Up, Key.Left, Key.Right};
    
    public JoypadController(Clock clock, InterruptFlag iflag) {
        this.iflag = iflag;
        clock.register(JOY_TICK,this);
    }
    
    @Override
    public boolean maps(short addr) {
        return (addr & 0xffff) == ADDR;
    }

    @Override
    public byte r8(short addr) {
        
        
        int but_value = 0;
        int dir_value = 0;
        int mode_value = (~mode & 0x03) << 4;
        
        for(Key k : MODE_KEYS) if (k.isPressed()) but_value += k.mask();
        for(Key k : DIR_KEYS)  if (k.isPressed()) dir_value += k.mask();
        
        switch(mode) {
            case MODE_BUTTON:
                return (byte)(mode_value + ~but_value);
            case MODE_DIRECTION:
                return (byte)(mode_value + ~dir_value);
            case MODE_BOTH:
                return (byte)(mode_value + ~(but_value | dir_value));
            default:
                return 0x0f;
        }
    }

    @Override
    public void w8(short addr, byte value) {
        mode = ((value & WRITE_MASK) >> 4) ^ 0x3; 
    }
    
    public void press(Key key) {
        key.press();
        iflag.requestInterrupt(Interrupt.Joypad);
    }
    
    public void depress(Key key) {
        key.depress();
    }

    @Override
    public void doTicks(int ticks) {
        boolean shouldInterruptAgain = false;
        
        for(Key k : Key.values()) {
            k.doTicks(ticks);
            if (k.checkRepeatAndAcknowledge()) shouldInterruptAgain = true;
        }
        
        if (shouldInterruptAgain) iflag.requestInterrupt(Interrupt.Joypad);
    }
            
    public static enum Key implements ClockTrigger {
        Down(0x8),
        Up(0x4),
        Left(0x2),
        Right(0x1),
        
        Start(0x8),
        Select(0x4),
        B(0x2),
        A(0x1);
        
        private Key(int mask) {
            this.mask = mask;
        }
        
        public int mask() {
            return mask;
        }
        
        @Override
        public void doTicks(int ticks) {
            if (pressed) {
                ticksElapsed += ticks;
                if (ticksElapsed > maxTicks) {
                    if (depressed) {
                        pressed = false;
                        depressed = false;
                    } else {
                        System.out.println("Repeated key");
                        repeating = true;
                    }
                    ticksElapsed = 0;
                }
            }
        }
        
        private void press() {
            ticksElapsed = 0;
            pressed = true;
        }
        
        private void depress() {
            depressed = true;
        }
        
        public boolean isPressed() {
            return pressed;
        }
        
        public boolean checkRepeatAndAcknowledge() {
            if (repeating) {
                repeating = false;
                return true;
            } else {
                return false;
            }
        }
        
        private boolean pressed, depressed;
        private boolean repeating;
        
        private int mask;
        private int ticksElapsed;
        private final int maxTicks = 56;  // Assuming that a key should be pinned down for 56 clocks
    }
    
}
