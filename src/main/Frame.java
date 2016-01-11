/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import console.console;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import loader.PanelHolder;
import loader.tabbedPane;
import resources.SplashScreen;
import utilities.ScreenImage;

/**
 *
 * @author Preston Garno
 */
public class Frame extends JFrame {

    tabbedPane tabs = null;
    SplashScreen loading = new SplashScreen();
    MenuBar menu = new MenuBar();

    public Frame() {

        this.setTitle("OSRSColor");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        centerFrame();

        tabs = new tabbedPane();

        setLayout(new BorderLayout());
        addMenuActions();
        add(menu, BorderLayout.NORTH);
        add(tabs, BorderLayout.CENTER);
        add(console.getInstance(), BorderLayout.SOUTH);
        remove(loading);

        //stop all applets when frame closes
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                tabs.stopAllApplets();
                dispose();
                super.windowClosed(e);
                System.exit(0);
            }
        });

        setSize(770, 710);

    }

    private void centerFrame() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int cX = (toolkit.getScreenSize().width / 2) - (getWidth() / 2);
        int cY = (toolkit.getScreenSize().height / 2) - (getHeight() / 2);
        setMinimumSize(new Dimension(765, 553));
        setLocation(cX, cY);
        setBackground(Color.BLACK);
        add(loading);
        setVisible(true);
        setResizable(true);
    }

    public void screenshot(Canvas c) {

        //BufferedImage image = ScreenImage.createImage(c);
        BufferedImage image = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = (Graphics2D) image.getGraphics();
        c.print(g2);
        g2.dispose();

        try {
            ScreenImage.saveImage("plz_work.png", image);
            console.getInstance().log("ScreenShot taken!");
        } catch (Exception ex) {
            System.out.println("ERORRRRRRRR");
            console.getInstance().log("Error taking Screenshot!");
        }
    }

    private void addMenuActions() {
        menu.ScreenShot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenshot(tabs.games.get(0).game.getCanvas());
            }
        });
        
        menu.AddTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewTab();
            }
        });
    }
    
    //need to correctly show the splashscreen...
    public void addNewTab() {
        tabs.addGame(new PanelHolder("http://oldschool.runescape.com"));
        log("PanelHolder() instance created and added to ArrayList!");
        Thread thread = new Thread(tabs.games.get(tabs.games.size() - 1));
        thread.start();
        tabs.addTab("OSRS " + tabs.getTabCount(), tabs.games.get(tabs.games.size() - 1));
        log("New panel added!");
        tabs.addThread(thread);
    }
    
    public static void log(String message) {
        console.getInstance().log(message);
    }
}
