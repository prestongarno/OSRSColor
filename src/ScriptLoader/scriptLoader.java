/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScriptLoader;

import ScriptLoader.Actions.*;
import bot.bot;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Preston Garno
 */
public class scriptLoader {
    
    private ArrayList<String> lines;
    private ArrayList<OSAction> actions;
    
    public scriptLoader(File f){
        lines = new ArrayList<>();
        actions = new ArrayList<>();
        //read the file, then use the logic to call appropriate bot methods
        
    }
    
    private void readCommands(){
        //logic here to read commands
    }
    
    private void runScript(){
        bot b = new bot();
        Thread t = new Thread(b);
        b.run();
    }
    
    private OSAction evaluateAction(String line) {
        return new walk();
    }
    
}
