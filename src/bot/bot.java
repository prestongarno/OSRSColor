/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot;

import Actions.Actions;
import controller.controller;
import java.awt.image.BufferedImage;

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
        this.runBot();
    }

    private void runBot() {
        
    }
}
