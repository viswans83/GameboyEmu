/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.joy;

import com.sankar.gbemu.cpu.Interrupt;
import com.sankar.gbemu.mem.InterruptFlag;
import com.sankar.gbemu.mem.map.MemoryMapped;

/**
 *
 * @author minerva
 */
public class JoypadController implements MemoryMapped {
    
    private InterruptFlag iflag;
    private int mode = 0;
    
    private static final int MODE_DIRECTION = 1;
    private static final int MODE_BUTTON = 2;
    private static final int MODE_BOTH = 3;
    
    private static final int ADDR = 0xFF00;
    private static final int WRITE_MASK = 0x30;
    
    final Key[] MODE_KEYS = new Key[]{Key.Start, Key.Select, Key.B, Key.A};
    final Key[] DIR_KEYS = new Key[]{Key.Down, Key.Up, Key.Left, Key.Right};
    
    public JoypadController(InterruptFlag iflag) {
        this.iflag = iflag;
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
            
    public static enum Key {
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
        
        private void press() {
            pressed = true;
        }
        
        private void depress() {
            pressed = false;
        }
        
        public boolean isPressed() {
            return pressed;
        }
        
        private boolean pressed;
        private int mask;
    }
    
}
