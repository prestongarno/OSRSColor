/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import console.console;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Preston Garno
 */
public class Main {

    /**
     * ******************************
     * Main class should start the frame
     *
     * @param args Default java Main class parameters
     * *****************************
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new Frame();
        } catch (UnsupportedLookAndFeelException e) {
            console.log(e);
        } catch (ClassNotFoundException e) {
            console.log(e);
        } catch (InstantiationException e) {
            console.log(e);
        } catch (IllegalAccessException e) {
            console.log(e);
        } catch (Exception e) {
            console.log(e);
        }
        
    }
}