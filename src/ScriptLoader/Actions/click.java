/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScriptLoader.Actions;

import ScriptLoader.OSAction;
import console.console;

/**
 *
 * @author prest
 */
public class click extends OSAction {
    
    public click() {
        
    }

    @Override
    public void perform(String[] args) {
        try {
            if (args[0].equals("1")) {
                this.leftClick(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            } else if (args[0].equals("2")) {
                this.rightClick(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            } else {
                throw new IllegalArgumentException();
            }
        } catch (Exception ex) {
            console.log("Incorrect Arguments! Requires args: int button, int x, int y");
        }
    }

    @Override
    public String toString() {
        return "click";
    }
    
}
