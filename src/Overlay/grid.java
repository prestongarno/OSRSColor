/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Overlay;

import Overlay.drawable.Line;
import Overlay.drawable.Rectangle;
import Overlay.drawable.drawable;
import console.console;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import resources.dir;
/**
 *
 * @author Preston Garno
 */
public class grid extends drawable {
    
    private String name;
    
    private Rectangle BORDER = new Rectangle(0, 0, 516, 338, Color.green, "game_border");
    
    /********************/
    private Line x1 = new Line(0, 19, 515, 19, Color.green, "x1");
    private Line x2 = new Line(0, 37, 515, 37, Color.green, "x2");
    private Line x3 = new Line(0, 61, 515, 61, Color.green, "x3");
    private Line x4 = new Line(0, 98, 515, 98, Color.green, "x4");
    private Line x5 = new Line(0, 121, 515, 121, Color.green, "x5");
    private Line x6 = new Line(0, 145, 515, 145, Color.green, "x6");
    private Line x7 = new Line(0, 168, 515, 168, Color.green, "x7");
    private Line x8 = new Line(0, 196, 515, 196, Color.green, "x8");
    private Line x9 = new Line(0, 223, 515, 223, Color.green, "x9");
    private Line x10 = new Line(0, 253, 515, 253, Color.green, "x10");
    private Line x11 = new Line(0, 282, 515, 282, Color.green, "x11");
    private Line x12 = new Line(0, 314, 515, 314, Color.green, "x12");
    private Line x13 = new Line(0, 338, 515, 338, Color.green, "x13");
    private Line y1 = new Line(32, 0, 0, 92, Color.green, "y1");
    private Line y2 = new Line(55, 0, 0, 174, Color.green, "y2");
    private Line y3 = new Line(77, 0, 0, 277, Color.green, "y3");
    private Line y4 = new Line(98, 0, 21, 338, Color.green, "y4");
    private Line y5 = new Line(118, 0, 48, 338, Color.green, "y5");
    private Line y6 = new Line(142, 0, 76, 338, Color.green, "y6");
    private Line y7 = new Line(164, 0, 109, 338, Color.green, "y7");
    private Line y8 = new Line(185, 0, 143, 338, Color.green, "y8");
    private Line y9 = new Line(205, 0, 175, 338, Color.green, "y9");
    private Line y10 = new Line(225, 0, 206, 338, Color.green, "y10");
    private Line y11 = new Line(247, 0, 237, 338, Color.green, "y11");
    private Line y12 = new Line(265, 0, 275, 338, Color.green, "y12");
    private Line y13 = new Line(287, 0, 306, 338, Color.green, "y13");
    private Line y14 = new Line(309, 0, 339, 338, Color.green, "y14");
    private Line y15 = new Line(331, 0, 373, 338, Color.green, "y15");
    private Line y16 = new Line(350, 0, 405, 338, Color.green, "y16");
    private Line y17 = new Line(372, 0, 439, 338, Color.green, "y17");
    private Line y18 = new Line(396, 0, 466, 338, Color.green, "y18");
    private Line y19 = new Line(417, 0, 494, 338, Color.green, "y19");
    private Line y20 = new Line(438, 0, 516, 338, Color.green, "y20");
    private Line y21 = new Line(461, 0, 516, 190, Color.green, "y21");
    private Line y22 = new Line(483, 0, 516, 105, Color.green, "y22");
    /********************/
    
    private   ArrayList<Line> lines = new ArrayList<Line>() {{
        
        add(x1);add(x2);add(x3);add(x4);add(x5);add(x6);add(x7);
        add(x8);add(x9);add(x10);add(x11);add(x12);add(x13);
        
        add(y1);add(y2);add(y3);add(y4);add(y5);add(y6);add(y7);
        add(y8);add(y9);add(y10);add(y11);add(y12);add(y13);
        add(y14);add(y15);add(y16);add(y17);add(y18);add(y19);add(y20);
        add(y21);add(y22);
        
        x1.setToString("x1");x2.setToString("x2");x3.setToString("x3");x4.setToString("x4");
        x5.setToString("x5");x6.setToString("x6");x7.setToString("x7");x8.setToString("x8");
        x9.setToString("x9");x10.setToString("x10");x11.setToString("x11");x12.setToString("x12");
        x13.setToString("x13");y1.setToString("y1");y2.setToString("y2");y3.setToString("y3");y4.setToString("y4");
        y5.setToString("y5");y6.setToString("y6");y7.setToString("y7");y8.setToString("y8");
        y9.setToString("y9");y10.setToString("y10");y11.setToString("y11");y12.setToString("y12");
        y13.setToString("y13");y14.setToString("y14");y15.setToString("y15");y16.setToString("y16");y17.setToString("y17");
        y18.setToString("y18");y19.setToString("y19");y20.setToString("y20");y21.setToString("y20");
        y21.setToString("y21");y22.setToString("y22");
    }};
    
    public grid(String name){
        this.name = name;
    }
    
    public ArrayList<Line> getLines(){
        return lines;
    }

    @Override
    public void draw(Graphics g) {
        BORDER.draw(g);
        for(Line snortLines : lines) {
            snortLines.draw(g);
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
        
        //BORDER.move(amount, d);
        console.log("/********************/");
        if(d == dir.UP) {
            for(Line ofCoke : lines) {
                ofCoke.move(amount, d);
            }
        } else if (d == dir.DOWN) {
            for(Line ofCoke : lines) {
                ofCoke.move(amount, d);
            }
        } else if (d == dir.LEFT) {
            for(Line ofCoke : lines) {
                ofCoke.move(amount, d);
            }
        } else if (d == dir.RIGHT) {
            for(Line ofCoke : lines) {
                ofCoke.move(amount, d);
            }
        }
        console.log("/********************/");
    }
    
    
}
