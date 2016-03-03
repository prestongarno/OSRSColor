/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScriptLoader;

/**
 *
 * @author Preston Garno
 */
public abstract class OSAction {
    
    public abstract void perform();
    
    public void clickInBox(int x, int y, int width, int height) {
        
    }
    
    public void clickInCustomArea(int x1, int y1, int x2, int y2) {
        
    }
    
    public void selectTile(int x, int y){
        
    }
        
    
    public void delay(int milliseconds) {
        
    }
    
    public void faceNorth(){
        
    }
    
    public void gotoStandardView(){
        
    }
    
    public void updatePlayer(){
        
    }
    
    public void readInventory(){
        
    }
    
}
