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
                CMD.FACENORTH.perform();
            } catch (Exception ex) {
                console.log(ex);
            }
        }
    };
}
