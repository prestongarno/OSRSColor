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
    
    /**
     * The one and only almighty copy of the CANVAS that we can 
     * use for anything
     */
    public static BufferedImage CANVAS;
    
    /**
     * public constructor
     */
    public bot() {
        bot.CANVAS = null;
        
    }
    
    /**
     * Run this bot
     */
    @Override
    public void run() {
        
    }
    
    /**
     * Runs all of the commands through!
     */
    private void runBot(ArrayList<OSAction> a) {
        for (OSAction a1 : a) {
            a1.perform();
        }
        
    }
}
