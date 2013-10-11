/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu;

import com.sankar.gbemu.swing.GBPanel;
import com.sankar.gbemu.cart.Cartridge;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author minerva
 */
public class Launcher {
    
    public static void main(String[] args) throws IOException {
        
        final Cartridge cart = Cartridge.load("testroms/opus5.gb");
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Gameboy");
                GBPanel gbPanel = new GBPanel(cart);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(gbPanel);
                frame.pack();
                frame.setVisible(true);
                gbPanel.startEmulation();
            }
        });
    }
    
}
