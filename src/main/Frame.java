/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import console.console;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import loader.PanelHolder;
import loader.tabbedPane;
import utilities.ScreenImage;

/**
 * @author Preston Garno
 *
 * KEEP THIS CLASS AS SIMPLE AS POSSIBLE!!!
 */
public class Frame extends JFrame {

    tabbedPane tabs = null;
    MenuBar menu = new MenuBar();

    public Frame() {

        this.setTitle("OSRSColor");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        centerFrame();

        tabs = new tabbedPane();
        tabs.setBounds(new Rectangle(765, 503));

        setLayout(new BorderLayout());
        try {
            addMenuActions();
        } catch (Exception ex) {
            console.log(ex);
        }
        add(menu, BorderLayout.NORTH);
        add(tabs, BorderLayout.CENTER);
        add(console.getInstance(), BorderLayout.SOUTH);

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
        addNewTab();
        console.log("End of Constructor");
    }

    private void centerFrame() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int cX = (toolkit.getScreenSize().width / 2) - (getWidth() / 2);
        int cY = (toolkit.getScreenSize().height / 2) - (getHeight() / 2);
        setMinimumSize(new Dimension(765, 553));
        setLocation(cX, cY);
        setBackground(Color.BLACK);
        setVisible(true);
        setResizable(true);
    }

    public void testSaveImage(BufferedImage image) {
        try {
            ScreenImage.saveImage(image);
            console.getInstance().log("ScreenShot Saved!");
        } catch (Exception ex) {
            console.log(ex);
        }
    }

    private void addMenuActions() {
        menu.ScreenShot.addActionListener(screenShot);
        menu.ScreenShot.setAccelerator(KeyStroke.getKeyStroke('P', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        
        menu.saveTopText.addActionListener(saveTopLeft);
        

        menu.AddTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewTab();
            }
        });

        menu.RemoveTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentSelection = tabs.getSelectedIndex();
                tabs.removeTabAt(currentSelection);
                //stop the spplet after closing the tab
                tabs.stopApplet(currentSelection);
            }
        });
    }

    public void addNewTab() {
        try {
            tabs.addGame(new PanelHolder("http://oldschool.runescape.com"));
            console.log("PanelHolder() instance created and added to ArrayList! index: " + tabs.lastGameIndex());
            Thread thread = new Thread(tabs.games.get(tabs.lastGameIndex()));
            thread.start();
            tabs.addTab("OSRS " + tabs.getTabCount(), tabs.games.get(tabs.lastGameIndex()));
            console.log("Index of game instance added: " + tabs.lastGameIndex());
            tabs.addThread(thread);
        } catch (Exception ex) {
            console.log(ex);
        }
    }

    private ActionListener screenShot = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                BufferedImage image = tabs.games.get(tabs.getSelectedIndex()).game.getCanvas().getScreen();
                testSaveImage(image);
            } catch (Exception ex) {
                console.log(ex);
            }
        }
    };

    private ActionListener saveTopLeft = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //good luck figuring out this method chain lmao
                BufferedImage topLeft = tabs.games.get(tabs.getSelectedIndex()).game.getCanvas().getScreen().getSubimage(0, 4, 380, 16);
                testSaveImage(topLeft);
                console.log("Top Left saved!");
            } catch (Exception ex) {
                console.log(ex);
            }
        }
    };
}
