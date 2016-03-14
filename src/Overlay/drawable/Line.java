/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Overlay.drawable;

import GUImenus.MenuBar;
import console.console;
import java.awt.Color;
import java.awt.Graphics;
import resources.dir;

/**
 *
 * @author Preston Garno
 */
public class Line extends drawable {

    private int x1, x2, y1, y2;
    Color c;
    private String name;

    public Line(int x1, int y1, int x2, int y2, Color c, String name) {
        this.c = c;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        this.name = name;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(c);

        g.drawLine(x1, y1, x2, y2);
    }

    public void setX1(int i) {
        x1 = i;
    }

    public void setY1(int i) {
        y1 = i;
    }

    public void setX2(int i) {
        x2 = i;
    }

    public void setY2(int i) {
        y2 = i;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public void shiftDown(int amount) {
        try {
            y1 = y1 + amount;
            y2 = y2 + amount;
        } catch (Exception nfex) {
            console.log(nfex);
        }
    }

    public void shiftUp(int amount) {
        try {
            y1 = y1 - amount;
            y2 = y2 - amount;
        } catch (Exception nfex) {
            console.log(nfex);
        }
    }

    public void shiftRight(int amount) {
        try {
            x1 = x1 + amount;
            x2 = x2 + amount;
        } catch (Exception nfex) {
            console.log(nfex);
        }
    }

    public void shiftLeft(int amount) {
        try {
            x1 = x1 - amount;
            x2 = x2 - amount;
        } catch (Exception nfex) {
            console.log(nfex);
        }
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
            y1 = y1 - amount;
            y2 = y2 - amount;
        } else if (d == dir.DOWN) {
            y1 = y1 + amount;
            y2 = y2 + amount;
        } else if (d == dir.LEFT) {
            x1 = x1 - amount;
            x2 = x2 - amount;
        } else if (d == dir.RIGHT) {
            x1 = x1 + amount;
            x2 = x2 + amount;
        }
        
        console.log("private Line " + name + " = new Line("+this.x1+", "+this.y1+", "+this.x2+", "+this.y2+", Color.green, " + name + ");");
    }
    
    public String printConstructorCall(){
        return ("private Line " + name + " = new Line("+this.x1+", "+this.y1+", "+this.x2+", "+this.y2+", Color.green, " + name + ");");

    }
}
