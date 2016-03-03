/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScriptLoader;

import bot.bot;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Preston Garno
 */
public class scriptLoader {
    
    private ArrayList<String> commands;
    
    public scriptLoader(File f){
        commands = new ArrayList<>();
        //read the file, then use the logic to call appropriate bot methods
        
    }
    
    private void readCommands(){
        //logic here
    }
    
    private void runScript(){
        bot b = new bot();
        Thread t = new Thread(b);
        b.run();
    }
    
}
