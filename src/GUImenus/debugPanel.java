/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUImenus;

<<<<<<< HEAD
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

=======
>>>>>>> 1eed2cea68c447eb9371898c18086f233de1b0de
/**
 *
 * @author Preston Garno
 */
<<<<<<< HEAD
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
    }
    
    private void registerListeners(ActionListener al, JComponent j){
        //register them here, need getters for all buttons though
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
    /**********************************
     * 
     *********************************/
=======
public class debugPanel {
>>>>>>> 1eed2cea68c447eb9371898c18086f233de1b0de
    
}
