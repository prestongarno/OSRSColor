/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Overlay.drawable;

import GUImenu.MenuBar;
import console.console;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Preston Garno
 */
public class Line extends drawable {

    private int x1, x2, y1, y2;
    Color c;
    
    //I'm too lazy to write the name of each variable when
    //changing up a million instances of this object
    //So I'm writing code to to write code
    private String description;

    public Line(int x1, int y1, int x2, int y2, Color c) {
        this.c = c;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        
        this.description = "none";
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
    
    public String getDescription(){
        return description;
    }
    
    public void setDesc(String description){
        this.description = description;
    }

    public void shiftDown() {
        try {
            y1 = y1 + Integer.parseInt(MenuBar.howMuchShift.getText());
            y2 = y2 + Integer.parseInt(MenuBar.howMuchShift.getText());
        } catch (NumberFormatException nfex) {
            console.log(nfex);
        }
    }

    public void shiftUp() {
        try {
            y1 = y1 - Integer.parseInt(MenuBar.howMuchShift.getText());
            y2 = y2 - Integer.parseInt(MenuBar.howMuchShift.getText());
        } catch (NumberFormatException nfex) {
            console.log(nfex);
        }
    }

    public void shiftRight() {
        try {
            x1 = x1 + Integer.parseInt(MenuBar.howMuchShift.getText());
            x2 = x2 + Integer.parseInt(MenuBar.howMuchShift.getText());
        } catch (NumberFormatException nfex) {
            console.log(nfex);
        }
    }
}
