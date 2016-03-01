
package main;

import console.console;
import controller.controller;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

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
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                } else {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                }
            }
        } catch (Exception e) {
            
        }
        try {
            new controller();
        } catch (Exception e) {
            console.log(e);
        }
    }
}
