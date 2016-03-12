/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import GUImenu.MenuBar;
import bot.bot;
import console.console;
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

    private static ArrayList<Thread> ThreadManager;

    private bot robot;
    public static GamePanel game;
    public static JFrame frame;

    public controller() {
        robot = new bot();
        game = new GamePanel();
        this.display();
    }

    private void startGameThread() {
        Thread gameThread = new Thread(game);
        gameThread.start();
    }

    private void startRobotThread() {
        Thread botThread = new Thread(robot);
        botThread.start();
    }

    public static void addThread(Thread t) {
        ThreadManager.add(t);
    }

    public static void killThread(int index) {
        ThreadManager.get(index).destroy();
    }

    public static void startThread(int index) {
        ThreadManager.get(index).start();
    }
    
    
    //this is the static class to pass all actions that are to be done to the game
    public static void doAction(){
        
    }

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
            frame.pack();
            frame.setVisible(true);
        } catch(Exception ex) {
            console.log(ex);
        }

    }
    
    public static void setBotCanvasInstance(){
        bot.CANVAS = game.getScreen();
    }

    private WindowAdapter onClose = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            frame.setVisible(false);
            game.stop();
            System.exit(0);
        }
    };
}
