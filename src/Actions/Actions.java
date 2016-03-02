/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import bot.bot;
import console.console;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.ScreenImage;

/**
 *
 * @author Preston Garno
 */
public class Actions {
    
    public static void addActions(){
        MenuBar.screenShot.addActionListener(scr);
    }
    
    private static ActionListener scr = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                if(bot.CANVAS != null) {
                    ScreenImage.saveImage(bot.CANVAS, "TestThis");
                } else {
                    console.log("Hello, the image you are looking for doesn't exist!");
                }
            } catch(Exception ex) {
                console.log(ex);
            }
        }
    };
}
