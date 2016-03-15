/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScriptLoader;

import bot.bot;
import controller.controller;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * @author Preston Garno
 */
public abstract class OSAction{
    
    protected Applet app;
    protected BufferedImage canvas;
    
    private MouseEvent click;
    
    public OSAction(){
        this.app = controller.getApplet();
        this.canvas = bot.CANVAS;
        
        click = (new MouseEvent(app,
            MouseEvent.MOUSE_PRESSED,
            System.currentTimeMillis() + 10,
            MouseEvent.BUTTON1,
            0, 0, 0,
            false));
    }
    
    public abstract void perform();
    
    public void leftClick(int x, int y){
        click.translatePoint(x, y);
        app.dispatchEvent(click);
    }
    
    public void rightClick(int x, int y){
        
    }
    
    public void clickInBox(int x, int y, int width, int height) {
        
    }
    
    public void clickInCustomArea(int x1, int y1, int x2, int y2) {
        
    }
    
    public void delay(int milliseconds) {
        
    }
    
    public void pressKey(KeyEvent k) {
        
    }
    
    //taken from old loader :) 
//    public void resetView(Applet applet){
//    applet.getComponent(0).dispatchEvent(new MouseEvent(applet,
//            MouseEvent.MOUSE_PRESSED,
//            System.currentTimeMillis() + 10,
//            MouseEvent.BUTTON1,
//           canvas.getWidth() - 162, 20,
//            0,
//            false));
//
//    applet.getComponent(0).dispatchEvent(new MouseEvent(applet,
//            MouseEvent.MOUSE_RELEASED,
//            System.currentTimeMillis() + 10,
//            MouseEvent.BUTTON1,
//           canvas.getWidth() - 162, 20,
//            0,
//            false));
//}
}
