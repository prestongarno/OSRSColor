/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Overlay;

import GUImenu.MenuBar;
import Overlay.drawable.Line;
import Overlay.drawable.Rectangle;
import Overlay.drawable.drawable;
import console.console;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Action;

/**
 *
 * @author Preston Garno
 */
public class grid extends drawable {
    
    private final Rectangle BORDER = new Rectangle(0, 0, 516, 338, Color.green);
    
/*************************************/
//New Values: 
    private  Line x1 = new Line(0, 13, 515, 515, Color.green);
    private  Line x2 = new Line(0, 37, 515, 515, Color.green);
    private  Line x3 = new Line(0, 61, 515, 515, Color.green);
    private  Line x4 = new Line(0, 83, 515, 515, Color.green);
    private  Line x5 = new Line(0, 108, 515, 515, Color.green);
    private  Line x6 = new Line(0, 132, 515, 515, Color.green);
    private  Line x7 = new Line(0, 157, 515, 515, Color.green);
    private  Line x8 = new Line(0, 182, 515, 515, Color.green);
    private  Line x9 = new Line(0, 206, 515, 515, Color.green);
    private  Line x10 = new Line(0, 231, 515, 515, Color.green);
    private  Line x11 = new Line(0, 262, 515, 515, Color.green);
    private  Line x12 = new Line(0, 294, 515, 515, Color.green);
    private  Line x13 = new Line(0, 327, 515, 515, Color.green);
/*************************************/
    
    private   Line y1 = new Line(32, 0, 0, 92, Color.green);
    private   Line y2 = new Line(55, 0, 0, 174, Color.green);
    private   Line y3 = new Line(77, 0, 0, 277, Color.green);
    private   Line y4 = new Line(98, 0, 21, 338, Color.green);
    private   Line y5 = new Line(118, 0, 48, 338, Color.green);
    private   Line y6 = new Line(142, 0, 76, 338, Color.green);
    private   Line y7 = new Line(164, 0, 109, 338, Color.green);
    private   Line y8 = new Line(185, 0, 143, 338, Color.green);
    private   Line y9 = new Line(205, 0, 175, 338, Color.green);
    private   Line y10 = new Line(227, 0, 208, 338, Color.green);
    private   Line y11 = new Line(250, 0, 240, 338, Color.green);
    private   Line y12 = new Line(265, 0, 275, 338, Color.green);
    private   Line y13 = new Line(287, 0, 306, 338, Color.green);
    private   Line y14 = new Line(309, 0, 339, 338, Color.green);
    private   Line y15 = new Line(329, 0, 371, 338, Color.green);
    private   Line y16 = new Line(350, 0, 405, 338, Color.green);
    private   Line y17 = new Line(372, 0, 439, 338, Color.green);
    private   Line y18 = new Line(396, 0, 466, 338, Color.green);
    private   Line y19 = new Line(417, 0, 494, 338, Color.green);
    private   Line y20 = new Line(438, 0, 516, 338, Color.green);
    private   Line y21 = new Line(461, 0, 516, 190, Color.green);
    private   Line y22 = new Line(483, 0, 516, 105, Color.green);
    
    private   ArrayList<Line> grid = new ArrayList<Line>() {{
        
        add(x1);add(x2);add(x3);add(x4);add(x5);add(x6);add(x7);
        add(x8);add(x9);add(x10);add(x11);add(x12);add(x13);
        
        add(y1);add(y2);add(y3);add(y4);add(y5);add(y6);add(y7);
        add(y8);add(y9);add(y10);add(y11);add(y12);add(y13);
        add(y14);add(y15);add(y16);add(y17);add(y18);add(y19);add(y20);
        add(y21);add(y22);
        
        x1.setDesc("x1");x2.setDesc("x2");x3.setDesc("x3");x4.setDesc("x4");
        x5.setDesc("x5");x6.setDesc("x6");x7.setDesc("x7");x8.setDesc("x8");
        x9.setDesc("x9");x10.setDesc("x10");x11.setDesc("x11");x12.setDesc("x12");
        x13.setDesc("x13");y1.setDesc("y1");y2.setDesc("y2");y3.setDesc("y3");y4.setDesc("y4");
        y5.setDesc("y5");y6.setDesc("y6");y7.setDesc("y7");y8.setDesc("y8");
        y9.setDesc("y9");y10.setDesc("y10");y11.setDesc("y11");y12.setDesc("y12");
        y13.setDesc("y13");y14.setDesc("y14");y15.setDesc("y15");y16.setDesc("y16");y17.setDesc("y17");
        y18.setDesc("y18");y19.setDesc("y19");y20.setDesc("y20");y21.setDesc("y20");
        y21.setDesc("y21");y22.setDesc("y22");
    }};
    
    public grid(){
        
        MenuBar.shiftUp.addActionListener(shiftGridUp);
        MenuBar.shiftDown.addActionListener(shiftGridDown);
    
    }

    @Override
    public void draw(Graphics g) {
        BORDER.draw(g);
        for(Line snortLines : grid) {
            snortLines.draw(g);
        }
    }
    
    //need easy calibration method for these grid lines
    private ActionListener shiftGridUp = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            console.log("/*************************************/");
            console.log("New Values: ");
            for(int i = 0; i < 13; i++) {
                grid.get(i).shiftUp();
                console.log("private  void " + grid.get(i).getDescription() + " = new Line(" + grid.get(i).getX1() + ", " + grid.get(i).getY1() + ", " + grid.get(i).getX2() + ", " + grid.get(i).getX2());
            }
            console.log("/*************************************/");
        }
    };
    
    private ActionListener shiftGridDown = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            console.log("/*************************************/");
            console.log("New Values: ");
            for(int i = 0; i < 13; i++) {
                grid.get(i).shiftDown();
                console.log("private  void " + grid.get(i).getDescription() + " = new Line(" + grid.get(i).getX1() + ", " + grid.get(i).getY1() + ", " + grid.get(i).getX2() + ", " + grid.get(i).getX2());
            }
            console.log("/*************************************/");
        }
    };
    
    private ActionListener shiftGridRight = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            console.log("/*************************************/");
            console.log("New Values: ");
            for(int i = 13; i < 23; i++) {
                grid.get(i).shiftRight();
                console.log("private  void " + grid.get(i).getDescription() + " = new Line(" + grid.get(i).getX1() + ", " + grid.get(i).getY1() + ", " + grid.get(i).getX2() + ", " + grid.get(i).getX2());
            }
            console.log("/*************************************/");
        }
    };
}
