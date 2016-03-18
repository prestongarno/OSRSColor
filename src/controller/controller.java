/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import GUImenus.MenuBar;
import GUImenus.debugPanel;
import ScriptLoader.OSAction;
import robot.bot;
import console.console;
import java.applet.Applet;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.ToolTipManager;
import loader.GamePanel;

/**
 *
 * @author Preston Garno
 */
public final class controller {
    
    /**
     * Holds the main game, script, bot threads
     */
    private static ArrayList<Thread> ThreadManager;
    
    /**
     * the bot
     */
    private bot robot;
    /**
     * The game/applet loader
     */
    public static GamePanel game;
    /**
     * The frame, am I overdoing this?
     */
    public static JFrame frame;
    
    /**
     * Public constructor
     */
    public controller() {
        robot = new bot();
        game = new GamePanel();
        this.display();
    }
    
    /**
     * Starts the game
     */
    private void startGameThread() {
        Thread gameThread = new Thread(game);
        gameThread.start();
    }
    
    /**
     * Starts the bot
     */
    private void startRobotThread() {
        Thread botThread = new Thread(robot);
        botThread.start();
    }
    
    /**
     * Add a thread to the manager
     * @param t
     */
    public static void addThread(Thread t) {
        ThreadManager.add(t);
    }
    
    /**
     * Kill specified thread
     * @param index
     */
    public static void killThread(int index) {
        ThreadManager.get(index).destroy();
    }
    
    /**
     * Starts specified thread
     * @param index
     */
    public static void startThread(int index) {
        ThreadManager.get(index).start();
    }
    
    /**
     * Show the application
     */
    public void display() {
        try {
            JPopupMenu.setDefaultLightWeightPopupEnabled(false);
            ToolTipManager.sharedInstance().setLightWeightPopupEnabled(false);
            startRobotThread();
            startGameThread();
            frame = new JFrame("OCRScape 0.1");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.addWindowListener(onClose);
            frame.setResizable(false);
            frame.setLayout(new BorderLayout());
            frame.add(MenuBar.getInstance(), BorderLayout.NORTH);
            frame.add(game, BorderLayout.CENTER);
            frame.add(console.getInstance(), BorderLayout.SOUTH);
            game.setPreferredSize(new Dimension(770, 505));
            debugPanel.getInstance().create();
            frame.pack();
            frame.setVisible(true);
        } catch(Exception ex) {
            console.log(ex);
        }

    }
    
    /**
     * pass game canvas to the bot for further dissection
     */
    public static void setBotCanvasInstance(){
        bot.CANVAS = game.getScreen();
    }

    /**
     * Brutally force all threads to stop and end the application
     */
    private WindowAdapter onClose = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            frame.setVisible(false);
            game.stop();
            System.exit(0);
        }
    };
    
    public static Applet getApplet(){
        return game.getApplet();
    }
}
