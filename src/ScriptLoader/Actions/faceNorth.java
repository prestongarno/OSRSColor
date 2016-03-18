/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScriptLoader.Actions;

import ScriptLoader.OSAction;
import console.console;
import java.awt.event.MouseEvent;

/**
 *
 * @author Preston Garno
 */
public class faceNorth extends OSAction {
    
    /**
     * public constructor
     * 
     * EVERY OS ACTION MUST CALL super()!!!! Or Null pointer is inevitable
     */
    public faceNorth() {
        super();
    }
    
    @Override
<<<<<<< HEAD
    public void perform(String[] args) {
        clickInBox(551, 13, 20, 20, MouseEvent.BUTTON1);
    }
    
    @Override
    public String toString() {
         return "resetView";
    }
    
=======
    public void perform() {
        clickInBox(551, 13, 20, 20, MouseEvent.BUTTON1);
    }
    
>>>>>>> 4996f662915e46926c8f82832715f0a0ac045952
}