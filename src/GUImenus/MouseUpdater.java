/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUImenus;

import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author Preston Garno
 */
public class MouseUpdater implements Runnable {

    Component c;
    JLabel j;
    Point p;
    int x, y;

    public MouseUpdater(Component c, JLabel j) {
        this.c = c;
        this.j = j;
        p = new Point(0, 0);
        x = y = 0;

        c.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                //
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                //
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                //resume the updating thread
            }
            @Override
            public void mouseExited(MouseEvent e) {
                //pause the thread
            }
        });
    }

    @Override
    public void run() {
        
    }

    public void printLocation() {
        String s = this.getLocation();
    }

    public String getLocation() {
        p = MouseInfo.getPointerInfo().getLocation();
        x = p.x;
        y = p.y;
        String location = (x + " - " + y);
        return location;
    }

}
