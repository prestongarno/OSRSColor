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
public class Line extends drawable {
    
    public int x1, x2, y1, y2;
    Color c;
    
    public Line(int x1, int y1, int x2, int y2, Color c) {
        this.c = c;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    
    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        
        g.drawLine(x1, y1, x2, y2);
    }
    
}
