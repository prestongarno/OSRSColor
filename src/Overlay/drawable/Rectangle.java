/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Overlay.drawable;

import console.console;
import java.awt.Color;
import java.awt.Graphics;
import resources.dir;

/**
 *
 * @author Preston Garno
 */
public class Rectangle extends drawable {

    private int x, y, width, height;
    Color c;
    private String name;

    public Rectangle(int x, int y, int width, int height, Color c, String name) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.c = c;
        this.name = name;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        g.drawRect(x, y, width, height);
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
        
        console.log("private  Rectangle " + name + " = new Line(" + this.x +", " + this.y + ", " + this.height + ", " + this.width + ", Color.green, " + name + ");");
    }

}
