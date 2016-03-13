/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Overlay;

import Overlay.drawable.*;
import console.console;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Preston Garno
 */
public class canvasOverlay {
    
    private static canvasOverlay instance = new canvasOverlay();
    
    public static canvasOverlay getInstance(){
        return instance;
    }
    
    private Graphics g;
    private ArrayList<drawable> drawables;
    
    private final Rectangle BORDER = new Rectangle(0, 0, 516, 338, Color.green);
    
    private final Line x1 = new Line(0, 5, 515, 5, Color.green);
    private final Line x2 = new Line(0, 29, 515, 29, Color.green);
    private final Line x3 = new Line(0, 53, 515, 53, Color.green);
    private final Line x4 = new Line(0, 75, 515, 75, Color.green);
    private final Line x5 = new Line(0, 100, 515, 100, Color.green);
    private final Line x6 = new Line(0, 124, 515, 124, Color.green);
    private final Line x7 = new Line(0, 149, 515, 149, Color.green);
    private final Line x8 = new Line(0, 174, 515, 174, Color.green);
    private final Line x9 = new Line(0, 198, 515, 198, Color.green);
    private final Line x10 = new Line(0, 223, 515, 223, Color.green);
    private final Line x11 = new Line(0, 254, 515, 254, Color.green);
    private final Line x12 = new Line(0, 286, 515, 286, Color.green);
    private final Line x13 = new Line(0, 319, 515, 319, Color.green);
    
    private final Line y1 = new Line(32, 0, 0, 92, Color.green);
    private final Line y2 = new Line(55, 0, 0, 174, Color.green);
    private final Line y3 = new Line(77, 0, 0, 277, Color.green);
    private final Line y4 = new Line(98, 0, 21, 338, Color.green);
    private final Line y5 = new Line(118, 0, 48, 338, Color.green);
    private final Line y6 = new Line(142, 0, 76, 338, Color.green);
    private final Line y7 = new Line(164, 0, 109, 338, Color.green);
    private final Line y8 = new Line(185, 0, 143, 338, Color.green);
    private final Line y9 = new Line(205, 0, 175, 338, Color.green);
    private final Line y10 = new Line(227, 0, 208, 338, Color.green);
    private final Line y11 = new Line(250, 0, 240, 338, Color.green);
    private final Line y12 = new Line(265, 0, 275, 338, Color.green);
    private final Line y13 = new Line(287, 0, 306, 338, Color.green);
    private final Line y14 = new Line(309, 0, 339, 338, Color.green);
    private final Line y15 = new Line(329, 0, 371, 338, Color.green);
    private final Line y16 = new Line(350, 0, 405, 338, Color.green);
    private final Line y17 = new Line(372, 0, 439, 338, Color.green);
    private final Line y18 = new Line(396, 0, 466, 338, Color.green);
    private final Line y19 = new Line(417, 0, 494, 338, Color.green);
    
    private final Line y20 = new Line(438, 0, 516, 338, Color.green);
    private final Line y21 = new Line(461, 0, 516, 190, Color.green);
    private final Line y22 = new Line(483, 0, 516, 105, Color.green);
    
    
    private final ArrayList<Line> grid = new ArrayList<Line>() {{
        add(x1);add(x2);add(x3);add(x4);add(x5);add(x6);add(x7);
        add(x8);add(x9);add(x10);add(x11);add(x12);add(x13);
        
        add(y1);add(y2);add(y3);add(y4);add(y5);add(y6);add(y7);
        add(y8);add(y9);add(y10);add(y11);add(y12);add(y13);
        
        add(y14);add(y15);add(y16);add(y17);add(y18);add(y19);add(y20);
        add(y21);add(y22);
    }};
    
    private static boolean SHOW_GRID;
    
    //this will be the overlay to seperate the tiles, inventory, etc
    private canvasOverlay(){
        drawables = new ArrayList<>();
        
        canvasOverlay.SHOW_GRID = true;
        /*
         * This is the grid for OSRS
         * Add all the lines here, use a booolean flag to show or nah
         */
        grid.add(x1);

        drawables.add(new Text("Hahahaha F*ck you", 200, 200, Color.RED));
        //drawables.add(new Line(12, 12, 64, 64, Color.RED));
    }
    
    public void drawAll(Graphics g){
        BORDER.draw(g);
        for (drawable drawMe : drawables) {
            drawMe.draw(g);
        }
        if(canvasOverlay.SHOW_GRID == true) {
            for(Line snortLines : grid) {
                snortLines.draw(g);
            }
        }
    }
    
    public void addDrawable(drawable d) {
        drawables.add(d);
    }
    
    public drawable getDrawable(int index) {
        try {
            return drawables.get(index);
        } catch (Exception ex) {
            console.log(ex);
            return null;
        }
    }
    
    public void removeDrawable(int index) {
        try {
            drawables.remove(index);
        } catch (Exception ex) {
            console.log(ex);
        }
    }
    
}
