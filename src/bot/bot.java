/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot;

import ScriptLoader.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Preston Garno
 */
public class bot implements Runnable {
    
    //this will get updated from the game class
    public static BufferedImage CANVAS;
    
    public bot() {
        bot.CANVAS = null;
        
    }

    @Override
    public void run() {
        
    }

    private void runBot(ArrayList<OSAction> a) {
        
        for (OSAction a1 : a) {
            a1.perform();
        }
        
    }
}
