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

/**
 *
 * @author Preston Garno
 */
public class MenuBar extends JMenuBar {
    
    public static final MenuBar instance = new MenuBar();
    
    public static JMenu Tools;
    public static JMenuItem screenShot;
    public static JButton readTopLeft, saveTopLeft, scan;
    
    public MenuBar(){
        Tools = new JMenu("Tools");
        
        screenShot = new JMenuItem("ScreenShot");
        
        readTopLeft = new JButton("OCR topLeft");
        saveTopLeft = new JButton("Save topLeft");
        scan = new JButton("Scan Screen");
        
        Tools.add(screenShot);
        
        add(Tools);
        add(readTopLeft);
        add(saveTopLeft);
        add(scan);
    }
    
    public static MenuBar getInstance(){
        instance.setMaximumSize(new Dimension(500, 10));
        return instance;
    }
    
}
