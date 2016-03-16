/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUImenus;

import console.console;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Preston Garno
 */
public class debugPanel extends JPanel {
    
    public static debugPanel instance = new debugPanel();
    
    public static debugPanel getInstance() {return instance;}
    
    private debugPanel(){
        //debug
        shiftUp = new JButton("^");
        shiftDown = new JButton("v");
        shiftLeft = new JButton("<-");
        shiftRight = new JButton("->");
        howMuchShift = new JTextField("0");
        howMuchShift.setColumns(5);
        targetLine = new JTextField("x1");
        targetLine.setColumns(5);
        mouse = new JLabel("Point: (0, 0)");
    }
    
    private void registerListeners(ActionListener al, JComponent j){
        
    }
    
    public void create(){
        add(shiftLeft);
        add(shiftUp);
        add(shiftDown);
        add(shiftRight);
        add(new JLabel("Target:"));
        add(targetLine);
        add(new JLabel("Amnt:"));
        add(howMuchShift);
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(this.getParent().getWidth(), 30));
        this.setVisible(true);
    }
    
    /***********************************
     *      DEBUG BUTTONS ONLY HERE
     * ********************************/
    public static JButton shiftUp, shiftDown, shiftRight, shiftLeft;
    public static JTextField howMuchShift;
    public static JTextField targetLine;
    public static JLabel mouse;
    /**********************************
     * 
     *********************************/
    
    public static MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            console.log("Point: (" + e.getX() + ", " + e.getY() + ")");
        }
        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
    };
    
    public static MouseMotionListener motionListener = new MouseMotionListener() {

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            mouse.setText("Point: (" + e.getX() + ", " + e.getY());
        }
    };
}
