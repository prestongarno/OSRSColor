/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUImenus;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

/**
 * @author Preston Garno
 */
public class MenuBar extends JMenuBar {
    
    /**
     * The single static instance of the MenuBar for the application
     */
    public static final MenuBar instance = new MenuBar();
    
    /**
     * Menu for "tools" of the application, mainly debug
     */
    public static JMenu Tools;
    /**
     * JMenuItems 
     */
    public static JMenuItem screenShot, showGrid, printGridCoordinates;
    /**
     * JButtons for things needed to have mouse focus somewhere else (select
     * by pressing enter)
     */
    public static JButton readTopLeft, saveTopLeft, scan;
    
    /***********************************
     *      DEBUG BUTTONS ONLY HERE
     * ********************************/
    public static JButton shiftUp, shiftDown, shiftRight, shiftLeft;
    public static JTextField howMuchShift;
    public static JTextField targetLine;
    /**********************************
     * 
     *********************************/
    
    /**
     * public constructor, instantiates and sets text for ALL menu items
     */
    public MenuBar(){
        Tools = new JMenu("Tools");
        
        screenShot = new JMenuItem("ScreenShot");
        showGrid = new JMenuItem("Show Coord. Grid");
        printGridCoordinates = new JMenuItem("Print grid coord.");
        
        readTopLeft = new JButton("OCR topLeft");
        saveTopLeft = new JButton("Save topLeft");
        scan = new JButton("Scan Screen");
        
        Tools.add(screenShot);
        Tools.add(showGrid);
        Tools.add(printGridCoordinates);
        
        add(Tools);
        add(readTopLeft);
        add(saveTopLeft);
        add(scan);
        
        //debug
        shiftUp = new JButton("^");
        shiftDown = new JButton("v");
        shiftLeft = new JButton("<-");
        shiftRight = new JButton("->");
        howMuchShift = new JTextField("0");
        howMuchShift.setColumns(5);
        targetLine = new JTextField("x1");
        targetLine.setColumns(5);
        
        add(shiftLeft);
        add(shiftUp);
        add(shiftDown);
        add(shiftRight);
        add(new JLabel("Target:"));
        add(targetLine);
        add(new JLabel("Amnt:"));
        add(howMuchShift);
    }
    
    /**
     * elegant way to get the instance of the menu, kinda pointless
     */
    public static MenuBar getInstance(){
        instance.setMaximumSize(new Dimension(500, 10));
        return instance;
    }
    
}
