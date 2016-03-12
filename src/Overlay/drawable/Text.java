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
public class Text extends drawable {
    
    private String message;
    private int x,y;
    private Color c;
    
    
    public Text(String message, int x, int y, Color c){
        this.message = message;
        this.x = x;
        this.y = y;
        this.c = c;
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        //g.drawString("This is a Test", 50, 50);
        g.drawString(message, x, y);
    }
    
}
