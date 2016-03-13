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
    private grid coordinateGrid;
    private static boolean SHOW_GRID;
    
    //this will be the overlay to seperate the tiles, inventory, etc
    private canvasOverlay(){
        drawables = new ArrayList<>();
        coordinateGrid = new grid();
        canvasOverlay.SHOW_GRID = false;
        drawables.add(new Text("Hahahaha F*ck you", 200, 200, Color.RED));
    }
    
    public void drawAll(Graphics g){
        for (drawable drawMe : drawables) {
            drawMe.draw(g);
        }
        if(canvasOverlay.SHOW_GRID == true) {
            coordinateGrid.draw(g);
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
    
    public static void setGridVisible(boolean SHOW_GRID) {
        canvasOverlay.SHOW_GRID = SHOW_GRID;
    }
    
    public static boolean getGridVisible() {
        return canvasOverlay.SHOW_GRID;
    }
}
