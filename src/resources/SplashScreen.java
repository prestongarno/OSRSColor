/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import utilities.Util;

/**
 *
 * @author Preston Garno
 */
public class SplashScreen extends JPanel {
    private JLabel splash;
    
    /**
     * The classic old school runescape loading screen!
     */
    public SplashScreen(){
        splash = new JLabel(Util.loadIcon("http://www.runescape.com/img/rsp777/oldschool_ani.gif"));
        setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(765, 553));
        setBackground(Color.BLACK);
        add(splash, BorderLayout.CENTER);
        setVisible(true);
    }
}
