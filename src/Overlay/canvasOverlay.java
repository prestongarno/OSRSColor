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
    private ArrayList<Line> grid;
    
    private static boolean SHOW_GRID;
    
    //this will be the overlay to seperate the tiles, inventory, etc
    private canvasOverlay(){
        drawables = new ArrayList<>();
        
        canvasOverlay.SHOW_GRID = false;
        /*
         * This is the grid for OSRS
         * Add all the lines here, use a booolean flag to show or nah
         */
        
        
        drawables.add(new Text("Hahahaha F*ck you", 200, 200, Color.RED));
        drawables.add(new Line(12, 12, 64, 64, Color.RED));
    }
    
    public void drawAll(Graphics g){
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
