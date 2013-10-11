/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.swing;

import com.sankar.gbemu.joy.JoypadController;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 *
 * @author minerva
 */
public class KeyHandler extends KeyAdapter {
    
    private JoypadController joy;
    
    public KeyHandler(JoypadController joy) {
        this.joy = joy;
    }
            
    private HashMap<Integer,JoypadController.Key> keyevents = new HashMap<Integer,JoypadController.Key>();

    {
        keyevents.put(KeyEvent.VK_LEFT   , JoypadController.Key.Left  );
        keyevents.put(KeyEvent.VK_RIGHT  , JoypadController.Key.Right );
        keyevents.put(KeyEvent.VK_UP     , JoypadController.Key.Up    );
        keyevents.put(KeyEvent.VK_DOWN   , JoypadController.Key.Down  );
        keyevents.put(KeyEvent.VK_Z      , JoypadController.Key.A     );
        keyevents.put(KeyEvent.VK_X      , JoypadController.Key.B     );
        keyevents.put(KeyEvent.VK_ENTER  , JoypadController.Key.Start );
        keyevents.put(KeyEvent.VK_SPACE  , JoypadController.Key.Select);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        JoypadController.Key key = keyevents.get(e.getKeyCode());
        if(key != null) joy.press(key);
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        JoypadController.Key key = keyevents.get(e.getKeyCode());
        if(key != null) joy.depress(key);
    }
    
}
