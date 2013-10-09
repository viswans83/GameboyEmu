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
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author minerva
 */
public class GBPanel extends JPanel {
    
    private GBRenderer renderer;
    private EmulationWorker worker;
    
    public GBPanel(Cartridge cart) {
        Clock clk = new Clock();
        JoypadController joy = new JoypadController();
        InterruptFlag iflag = new InterruptFlag();
        InterruptEnable ienable = new InterruptEnable();
        Timer timer = new Timer(clk,iflag);
        LCDController lcd = new LCDController(clk,iflag);
        GBMemoryMap mem = new GBMemoryMap(cart,lcd,joy,iflag,ienable,timer);
        CPU cpu = new CPU(mem,clk);
        
        renderer = new GBRenderer();
        worker = new EmulationWorker(cpu,lcd,this,renderer);
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
