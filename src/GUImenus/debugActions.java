/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUImenus;

import ScriptLoader.CMD;
import console.console;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import robot.bot;
import utilities.ScreenImage;

/**
 *
 * @author Preston Garno
 */
public class debugActions {
    public debugActions(){
        
    }
    
    public static void addActions(){
        debugPanel.scrBlobTest.addActionListener(scrAroundPlayer);
        debugPanel.faceNorth.addActionListener(faceNorthListener);
    }
    
    private static ActionListener scrAroundPlayer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ScreenImage.saveImage(bot.CANVAS.getSubimage(200, 100, 130, 130), "blobTest");
            } catch (Exception ex) {
                console.log(ex);
            }
        }
    };
    
    private static ActionListener faceNorthListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
<<<<<<< HEAD
                CMD.FACENORTH.perform(new String[0]);
=======
                CMD.FACENORTH.perform();
>>>>>>> 4996f662915e46926c8f82832715f0a0ac045952
            } catch (Exception ex) {
                console.log(ex);
            }
        }
    };
}
