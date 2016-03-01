/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bot.bot;
import java.util.ArrayList;
import loader.GamePanel;

/**
 *
 * @author Preston Garno
 */
public class controller {
    
    private static ArrayList<Thread> ThreadManager;
    
    private bot robot;
    public static GamePanel game;
    
    public controller(){
        robot = new bot();
        game = new GamePanel();
        this.display();
    }
    
    private void startGameThread(){
        Thread gameThread = new Thread(game);
        gameThread.run();
    }
    
    private void startRobotThread() {
        Thread botThread = new Thread(robot);
        botThread.run();
    }
    
    public static void addThread() {
        
    }
    
    public static void killThread(int index) {
        ThreadManager.get(index).destroy();
    }
    
    public static void startThread(int index) {
        ThreadManager.get(index).start();
    }
    
    public void display(){
        
    }
}
