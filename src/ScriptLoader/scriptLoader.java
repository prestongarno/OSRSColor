/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScriptLoader;

import ScriptLoader.Actions.*;
import robot.bot;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Preston Garno
 */
public class scriptLoader {
    
    private ArrayList<String> lines;
    private ArrayList<OSAction> actions;
    
    /**
     * Public constructor
     */
    public scriptLoader(File f){
        lines = new ArrayList<>();
        actions = new ArrayList<>();
        //read the file, then use the logic to call appropriate bot methods
        
    }
    
    /**
     * Reads the commands from the file, performs input validation
     */
    private void readCommands(){
        //logic here to read commands
    }
    
    /**
     * Runs the commands through
     */
    private void runScript(){
        bot b = new bot();
        Thread t = new Thread(b);
        b.run();
    }
    
    /**
<<<<<<< HEAD
     * call the appropriate static method when entered into console
     */
    private OSAction evaluateAction(String line, String[] args) {
        for(OSAction command : CMD.commands) {
            if (command.toString().equals(line)) {
                command.perform(args);
            } 
        }
        throw new IllegalArgumentException("Command " + line + " not found!");
=======
     * Don't know what I was thinking when I wrote this method but I think it's 
     * input validation on the .txt file
     */
    private OSAction evaluateAction(String line) {
        return new walk();
>>>>>>> 4996f662915e46926c8f82832715f0a0ac045952
    }
    
}
