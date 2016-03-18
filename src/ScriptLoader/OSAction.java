/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScriptLoader;

import robot.bot;
import controller.controller;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author Preston Garno
 */
public abstract class OSAction {

    protected Component target;
    protected BufferedImage canvas;
    protected Random rand;

    public OSAction() {
        this.target = controller.getApplet().getComponent(0);
        this.canvas = bot.CANVAS;
    }

    public abstract void perform(String[] args);
    
    @Override
    public abstract String toString();

    public void leftClick(int x, int y) {
        target.dispatchEvent(leftDown(x, y));
        target.dispatchEvent(leftUp(x, y));
    }

    public void rightClick(int x, int y) {
        target.dispatchEvent(rightDown(x, y));
        target.dispatchEvent(rightUp(x, y));
    }

    public void clickInBox(int x, int y, int width, int height, int mouseButton) {
        rand = new Random();
        int randomHeight = 1;
        int randomWidth = 1;
        randomHeight = 1 + rand.nextInt((height - 1) + 1);
        randomWidth = 1 + rand.nextInt((width - 1) + 1);
        
        if(mouseButton == MouseEvent.BUTTON1) {
            leftClick(x + randomWidth, y + randomHeight);
        } else if (mouseButton == MouseEvent.BUTTON2) {
            rightClick(x + randomWidth, y + randomHeight);
        } else if (mouseButton == MouseEvent.BUTTON3) {
            
        } else {
            throw new IllegalArgumentException("No such MouseButton!");
        }
    }

    public void clickInPolygon(int x1, int y1, int x2, int y2) {
        
    }

    public void delay(int milliseconds) {

    }

    public void pressKey(KeyEvent k) {

    }
    
    private MouseEvent leftDown(int x, int y) {
        return new MouseEvent(target,
                MouseEvent.MOUSE_PRESSED,
                System.currentTimeMillis() + 5,
                MouseEvent.BUTTON1,
                x, y, 0,
                false);
    }
    
    private MouseEvent leftUp(int x, int y) {
        return new MouseEvent(target,
                MouseEvent.MOUSE_RELEASED,
                System.currentTimeMillis() + 5,
                MouseEvent.BUTTON1,
                x, y, 0,
                false);
    }
    
    private MouseEvent rightDown(int x, int y) {
        return new MouseEvent(target,
                MouseEvent.MOUSE_PRESSED,
                System.currentTimeMillis() + 5,
                MouseEvent.BUTTON1,
                x, y, 0,
                false);
    }
    
    private MouseEvent rightUp(int x, int y) {
        return new MouseEvent(target,
                MouseEvent.MOUSE_RELEASED,
                System.currentTimeMillis() + 5,
                MouseEvent.BUTTON1,
                x, y, 0,
                false);
    }
}
