/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Overlay;

import GUImenu.MenuBar;
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
        coordinateGrid = new grid("main_grid");
        canvasOverlay.SHOW_GRID = false;
        drawables.add(new Text("It's just a prank, bro!", 50, 200, Color.RED, "just_a_prank_bro"));
        
        addDebugActionListeners();
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
    
    public grid getGrid() {
        return coordinateGrid;
    }
    
    public void move(String name, int amount, dir d){
        drawable item = getSpecifiedDrawable(name);
        if(item != null) {
            item.move(amount, d);
        } else {
            console.log("drawable '" + name + "' not found!");
        }
    }
    
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
    
    public void addDebugActionListeners(){
       MenuBar.shiftUp.addActionListener(up);
       MenuBar.shiftDown.addActionListener(down);
       MenuBar.shiftLeft.addActionListener(left);
       MenuBar.shiftRight.addActionListener(right);
       MenuBar.printGridCoordinates.addActionListener(printCoordinates);
    }
    
    private ActionListener up = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = "";
            int amount = 0;
            try{
                amount = Integer.parseInt(MenuBar.howMuchShift.getText());
                name = MenuBar.targetLine.getText();
            } catch (NumberFormatException n) {
                console.log("Invalid range!");
            } catch (Exception ex) {
                console.log("Invalid parameters!");
            }
            
            move(name, amount, dir.UP);
        }
    };
    
    private ActionListener down = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = "";
            int amount = 0;
            try{
                amount = Integer.parseInt(MenuBar.howMuchShift.getText());
                name = MenuBar.targetLine.getText();
            } catch (NumberFormatException n) {
                console.log("Invalid range!");
            } catch (Exception ex) {
                console.log("Invalid parameters!");
            }
            
            move(name, amount, dir.DOWN);
        }
    };
    
    private ActionListener left = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = "";
            int amount = 0;
            try{
                amount = Integer.parseInt(MenuBar.howMuchShift.getText());
                name = MenuBar.targetLine.getText();
            } catch (NumberFormatException n) {
                console.log("Invalid range!");
            } catch (Exception ex) {
                console.log("Invalid parameters!");
            }
            
            move(name, amount, dir.LEFT);
        }
    };
        
    private ActionListener right = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = "";
            int amount = 0;
            try{
                amount = Integer.parseInt(MenuBar.howMuchShift.getText());
                name = MenuBar.targetLine.getText();
            } catch (NumberFormatException n) {
                console.log("Invalid range!");
            } catch (Exception ex) {
                console.log("Invalid parameters!");
            }
            
            move(name, amount, dir.RIGHT);
        }
    };
    
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
