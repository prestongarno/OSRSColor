/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUImenu;

import Overlay.canvasOverlay;
import bot.OCR.REGTextScanner.REGTextScanner;
import bot.bot;
import console.console;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.ScreenImage;

/**
 *
 * @author Preston Garno
 */
public class MenuFunctions {
    
    public static void addActions(){
        MenuBar.screenShot.addActionListener(scr);
        MenuBar.showGrid.addActionListener(showGrid);
        MenuBar.saveTopLeft.addActionListener(scrTopLeft);
        MenuBar.readTopLeft.addActionListener(ocrTopLeft);
    }
    
    private static ActionListener scr = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                if(bot.CANVAS != null) {
                    ScreenImage.saveImage(bot.CANVAS, "TestThis");
                } else {
                    console.log("Hello, an error has occured!");
                }
            } catch(Exception ex) {
                console.log(ex);
            }
        }
    };
    
    private static ActionListener scrTopLeft = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ScreenImage.saveImage(bot.CANVAS.getSubimage(4, 4, 380, 16), "topLeft");
            } catch (Exception ex) {
                console.log(ex);
            }
        }
    };
    
    private static ActionListener ocrTopLeft = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                REGTextScanner scanner = new REGTextScanner();
                console.log(scanner.doOCR(bot.CANVAS.getSubimage(4, 4, 380, 16)));
            } catch (Exception ex) {
                console.log(ex.toString());
                console.log(ex);
            }
        }
    };
    
    private static ActionListener showGrid = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (canvasOverlay.getGridVisible()) {
                canvasOverlay.setGridVisible(false);
                MenuBar.showGrid.setText("Show Coord. Grid");
            } else if (!canvasOverlay.getGridVisible()) {
                canvasOverlay.setGridVisible(true);
                MenuBar.showGrid.setText("Hide Coord. Grid");
            }
        }
    };
}
