/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bot.bot;
import console.console;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
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

    public static void endAllThreads() {
        for (Thread ThreadManager1 : ThreadManager) {
            ThreadManager1.stop();
        }
    }

    public void display() {
        try {
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
            frame.pack();
            frame.setVisible(true);
        } catch(Exception ex) {
            console.log(ex);
        }

    }

    private WindowAdapter onClose = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            frame.setVisible(false);
            endAllThreads();
            game.stop();
            System.exit(0);
        }
    };
}
