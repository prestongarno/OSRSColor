/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScriptLoader;

import controller.controller;
import java.applet.Applet;
import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * @author Preston Garno
 */
public abstract class OSAction{
    
    protected Applet app;
    
    ActionEvent DankMeme;
    
    public OSAction(){
        this.app = controller.getApplet();
    }
    
    public abstract void perform();
    
    public void click(int x, int y){
        
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
