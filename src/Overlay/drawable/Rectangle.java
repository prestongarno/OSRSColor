/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Overlay.drawable;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Preston Garno
 */
public class Rectangle extends drawable {
    
    private int x, y, width, height;
    Color c;
    
    public Rectangle(int x, int y, int width, int height, Color c){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.c = c;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        g.drawRect(x, y, width, height);
    }
    
}
