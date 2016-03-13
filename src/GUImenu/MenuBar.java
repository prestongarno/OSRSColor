/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUImenu;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

/**
 *
 * @author Preston Garno
 */
public class MenuBar extends JMenuBar {
    
    public static final MenuBar instance = new MenuBar();
    
    public static JMenu Tools;
    public static JMenuItem screenShot, showGrid;
    public static JButton readTopLeft, saveTopLeft, scan;
    
    /***********************************
     * 
     *      DEBUG BUTTONS ONLY HERE
     * 
     * ********************************/
    public static JButton shiftUp, shiftDown;
    public static JTextField howMuchShift;
    /**********************************
     * 
     *********************************/
    
    public MenuBar(){
        Tools = new JMenu("Tools");
        
        screenShot = new JMenuItem("ScreenShot");
        showGrid = new JMenuItem("Show Coord. Grid");
        
        readTopLeft = new JButton("OCR topLeft");
        saveTopLeft = new JButton("Save topLeft");
        scan = new JButton("Scan Screen");
        
        Tools.add(screenShot);
        Tools.add(showGrid);
        
        add(Tools);
        add(readTopLeft);
        add(saveTopLeft);
        add(scan);
        
        //debug
        shiftUp = new JButton("^");
        shiftDown = new JButton("v");
        howMuchShift = new JTextField("0");
        howMuchShift.setColumns(5);
        
        add(shiftUp);
        add(shiftDown);
        add(howMuchShift);
    }
    
    public static MenuBar getInstance(){
        instance.setMaximumSize(new Dimension(500, 10));
        return instance;
    }
    
}
