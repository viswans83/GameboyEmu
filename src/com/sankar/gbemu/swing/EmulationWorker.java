package com.sankar.gbemu.swing;

import com.sankar.gbemu.cpu.CPU;
import com.sankar.gbemu.gpu.LCDController;
import com.sankar.gbemu.gpu.VBlankListener;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class EmulationWorker extends SwingWorker<Void,int[][]> {
    
    private CPU cpu;
    private LCDController lcd;
    private GBPanel panel;
    private GBRenderer renderer;

    public EmulationWorker(CPU cpu, LCDController lcd, GBPanel panel, GBRenderer renderer) {
        this.cpu = cpu;
        this.lcd = lcd;
        this.panel = panel;
        this.renderer = renderer;
        init();
    }

    private void init() {
        lcd.registerVBlankListener(new VBlankListener() {
            
            private long lastRefresh = System.nanoTime();
            
            private static final long REFRESH_INTERVAL = (long)1e9/60;
            
            @Override
            public void vBlankOccured(int[][] screenData) {
                long currentTime = System.nanoTime();
                long delta = currentTime - lastRefresh;
                
                lastRefresh = currentTime;
                
                if (delta < REFRESH_INTERVAL) {
                    try {
                        long sleepInterval = (long)((REFRESH_INTERVAL - delta)/1e6);
                        Thread.sleep(sleepInterval);
                    } catch(InterruptedException e) {
                        // Ignore
                    }
                }
                
                publish(screenData);
            }
        });
    }

    @Override
    protected Void doInBackground() throws Exception {
        while(true) cpu.step();
    }

    @Override
    protected void process(List<int[][]> updates) {
        if (!SwingUtilities.isEventDispatchThread()) throw new RuntimeException("Not in event dispatch thread");
        renderer.updateScreenData(updates.get(updates.size() - 1));
        panel.repaint(panel.getBounds());
    }
    
    @Override
    protected void done() {
        try {
            get();
        } catch(InterruptedException t) {
            // Ignore
        } catch (ExecutionException t) {
            t.printStackTrace();
            System.exit(-1);
        }
    }

}