/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.awt.Graphics;
import java.util.EventListener;

/**
 * @author Preston Garno
 * 
 * Hook for the canvas
 */
public interface PaintListener extends EventListener {
    public void onPaint(Graphics g);
}
