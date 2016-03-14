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
public class Text extends drawable {
    
    private String message;
    private int x,y;
    private Color c;
    private String name;
    
    
    public Text(String message, int x, int y, Color c, String name){
        this.message = message;
        this.x = x;
        this.y = y;
        this.c = c;
        this.name = name;
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        //g.drawString("This is a Test", 50, 50);
        g.drawString(message, x, y);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void setToString(String name) {
        this.name = name;
    }

    @Override
    public void move(int amount, dir d) {
        if (d == dir.UP) {
            y = y - amount;
        } else if (d == dir.DOWN) {
            y = y + amount;
        } else if (d == dir.LEFT) {
            x = x - amount;
        } else if (d == dir.RIGHT) {
            x = x + amount;
        }
    }
    
    public void setMessage(String message){
        this.message = message;
    }
    
}
