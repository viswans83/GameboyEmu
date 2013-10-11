/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.swing;


import com.sankar.gbemu.cart.Cartridge;
import com.sankar.gbemu.clock.Clock;
import com.sankar.gbemu.cpu.CPU;
import com.sankar.gbemu.cpu.Timer;
import com.sankar.gbemu.gpu.LCDController;
import com.sankar.gbemu.joy.JoypadController;
import com.sankar.gbemu.mem.GBMemoryMap;
import com.sankar.gbemu.mem.InterruptEnable;
import com.sankar.gbemu.mem.InterruptFlag;
import com.sankar.gbemu.serial.SerialController;
import com.sankar.gbemu.sound.SoundController;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;


public class GBPanel extends JPanel {
    
    private final GBRenderer renderer;
    private final EmulationWorker worker;
    
    public GBPanel(Cartridge cart) {
        Clock clk = new Clock();
        
        final InterruptFlag iflag = new InterruptFlag();
        final InterruptEnable ienable = new InterruptEnable();
        final Timer timer = new Timer(clk,iflag);
        final LCDController lcd = new LCDController(clk,iflag);
        final JoypadController joy = new JoypadController(clk,iflag);
        final SoundController sound = new SoundController();
        final SerialController serial = new SerialController();
        
        final GBMemoryMap mem = new GBMemoryMap(cart,lcd,joy,sound,serial,iflag,ienable,timer);
        final CPU cpu = new CPU(mem,clk);
        
        renderer = new GBRenderer();
        worker = new EmulationWorker(cpu,lcd,this,renderer);
        
        setFocusable(true);
        addKeyListener(new KeyHandler(joy));
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(GBRenderer.WIDTH * GBRenderer.PIXEL_SIZE , GBRenderer.HEIGHT * GBRenderer.PIXEL_SIZE);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderer.render(g);
    }
    
    public void startEmulation() {
        worker.execute();
    }
    
}
