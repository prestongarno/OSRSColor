/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Overlay;

import GUImenus.MenuBar;
import GUImenus.debugPanel;
import Overlay.drawable.*;
import console.console;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import resources.dir;

/**
 *
 * @author Preston Garno
 */
public class canvasOverlay {
    
    /**
     * The one and only static instance of the canvas overlay
     */
    private static canvasOverlay instance = new canvasOverlay();
    
    /**
     * Returns the instance of the canvas, kinda pointless IMO
     * @return static instance of canvasOverlay()
     */
    public static canvasOverlay getInstance(){
        return instance;
    }
    
    /**
     * The almighty Graphics g which somehow paints all drawables to the canvas
     */
    private Graphics g;
    /**
     * ArrayList for any drawables except the coordinate grid and the inventory
     */
    private ArrayList<drawable> drawables;
    /**
     * Outlines tiles
     */
    private grid coordinateGrid;
    /**
     * Boolean flag whether or not to show the grid
     */
    private static boolean SHOW_GRID;
    
    /**
     * private constructor.  
     * Instantiates drawable arrays, adds action listeners for drawable calibration
     */
    private canvasOverlay(){
        drawables = new ArrayList<>();
        coordinateGrid = new grid("main_grid");
        canvasOverlay.SHOW_GRID = false;
        
        addDebugActionListeners();
    }
    
    /**
     * Draws the grid if needed
     * Iterates through all drawables and calles the drawable.draw() function
     * @param g
     */
    public void drawAll(Graphics g){
        for (drawable drawMe : drawables) {
            drawMe.draw(g);
        }
        if(canvasOverlay.SHOW_GRID == true) {
            coordinateGrid.draw(g);
        }
    }
    
    /**
     * Add a drawable to the canvas
     * @param d
     */
    public void addDrawable(drawable d) {
        drawables.add(d);
    }
    
    /**
     * @param index
     * @return drawable
     * Returns the specified drawable from arraylist of drawables
     */
    public drawable getDrawable(int index) {
        try {
            return drawables.get(index);
        } catch (Exception ex) {
            console.log(ex);
            return null;
        }
    }
    
    /**
     * Removes drawable from list specified by index
     * @param index
     */
    public void removeDrawable(int index) {
        try {
            drawables.remove(index);
        } catch (Exception ex) {
            console.log(ex);
        }
    }
    
    /**
     * Removes drawable from list specified by name
     * @param name
     */
    public void removeDrawable(String name) {
        int oldSize = drawables.size();
        for (drawable d : drawables) {
            if (d.toString().equals(name)) {
                drawables.remove(d);
            }
        }
        if (oldSize == drawables.size()) {
            throw new IllegalArgumentException("Not found!");
        }
    }
    
    /**
     * Changes bool flag to show or hide coordinate grid
     * @param SHOW_GRID
     */
    public static void setGridVisible(boolean SHOW_GRID) {
        canvasOverlay.SHOW_GRID = SHOW_GRID;
    }
    
    /**
     * Get the current state of boolean SHOW_GRID
     * @return SHOW_GRID
     */
    public static boolean getGridVisible() {
        return canvasOverlay.SHOW_GRID;
    }
    
    /**
     * Getter for the instance of grid
     * @return coordinateGrid
     */
    public grid getGrid() {
        return coordinateGrid;
    }
    
    /**
     * Moves the drawable specified by name, direction, and pixel amount
     * @param name
     * @param amount
     * @param d 
     */
    public void move(String name, int amount, dir d){
        drawable item = getSpecifiedDrawable(name);
        if(item != null) {
            item.move(amount, d);
        } else {
            console.log("drawable '" + name + "' not found!");
        }
    }
    
    /**
     * Gets the drawable specified by name
     * @return drawable
     */
    private drawable getSpecifiedDrawable(String name){
        for (Line ofCoke : coordinateGrid.getLines()) {
            if(name.equals(ofCoke.toString())) {
                return ofCoke;
            }
        }
        
        for (drawable d : drawables) {
            if (name.equals(d.toString())) {
                return d;
            }
        }
        return null;
    }
    
    /**
     * Adds functions for calibrating/debugging the drawables on the canvas
     */
    public void addDebugActionListeners(){
       debugPanel.shiftUp.addActionListener(up);
       debugPanel.shiftDown.addActionListener(down);
       debugPanel.shiftLeft.addActionListener(left);
       debugPanel.shiftRight.addActionListener(right);
       MenuBar.printGridCoordinates.addActionListener(printCoordinates);
    }
    
    /**
     * Input sanitization, moves drawable up
     */
    private ActionListener up = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = "";
            int amount = 0;
            try{
                amount = Integer.parseInt(debugPanel.howMuchShift.getText());
                name = debugPanel.targetLine.getText();
            } catch (NumberFormatException n) {
                console.log("Invalid range!");
            } catch (Exception ex) {
                console.log("Invalid parameters!");
            }
            
            move(name, amount, dir.UP);
        }
    };
    
    /**
     * Input sanitization, moves drawable down
     */
    private ActionListener down = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = "";
            int amount = 0;
            try{
                amount = Integer.parseInt(debugPanel.howMuchShift.getText());
                name = debugPanel.targetLine.getText();
            } catch (NumberFormatException n) {
                console.log("Invalid range!");
            } catch (Exception ex) {
                console.log("Invalid parameters!");
            }
            
            move(name, amount, dir.DOWN);
        }
    };
    
    /**
     * Input sanitization, moves drawable left
     */
    private ActionListener left = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = "";
            int amount = 0;
            try{
                amount = Integer.parseInt(debugPanel.howMuchShift.getText());
                name = debugPanel.getInstance().targetLine.getText();
            } catch (NumberFormatException n) {
                console.log("Invalid range!");
            } catch (Exception ex) {
                console.log("Invalid parameters!");
            }
            
            move(name, amount, dir.LEFT);
        }
    };

    /**
     * Input sanitization, moves drawable right
     */
    private ActionListener right = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = "";
            int amount = 0;
            try{
                amount = Integer.parseInt(debugPanel.howMuchShift.getText());
                name = debugPanel.targetLine.getText();
            } catch (NumberFormatException n) {
                console.log("Invalid range!");
            } catch (Exception ex) {
                console.log("Invalid parameters!");
            }
            
            move(name, amount, dir.RIGHT);
        }
    };
    
    /**
     * Prints coordinates of the grid
     */
    private ActionListener printCoordinates = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            console.log("/********************/");
            for(Line ofCoke : coordinateGrid.getLines()) {
                console.log(ofCoke.printConstructorCall());
            }
            console.log("/********************/");
        }
    };
}
