/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Overlay.drawable;

import java.awt.Graphics;
import resources.dir;

/**
 *
 * @author Preston Garno
 */
public abstract class drawable {
    
    private String name;
    
    public drawable(){
        
    }
    
    public abstract void draw(Graphics g);
    
    public abstract void move(int amount, dir d);
    
    @Override
    public abstract String toString();
    
    public abstract void setToString(String name);
}
