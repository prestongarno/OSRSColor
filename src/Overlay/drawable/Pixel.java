/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Overlay.drawable;

import java.awt.Color;
import java.awt.Graphics;
import resources.dir;

/**
 *
 * @author Preston Garno
 */
public class Pixel extends drawable {
    
    private String name;
    private int x, y;
    private Color c;
    
    /**
     * EXTENDS DRAWABLE
     * Add one of these to the canvasOverlay.getDrawables() ArrayList to 
     * draw to the screen
     * @param x
     * @param y
     * @param c
     * @param name 
     */
    public Pixel(int x, int y, Color c, String name) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.name = name;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        g.drawLine(x, y, x, y);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void setToString(String name) {
        this.name = name;
    }

    @Override
    public void move(int amount, dir d) {
        if(d == dir.UP) {
            y = y - amount;
        } else if (d == dir.DOWN) {
            y = y + amount;
        } else if (d == dir.LEFT) {
            x = x - amount;
        } else if (d == dir.RIGHT) {
            x = x + amount;
        }
    }
    
}
