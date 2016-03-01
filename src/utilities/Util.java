/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javafx.scene.layout.BorderStroke;

/**
 * @author Preston Garno
 *
 * Utilities class, Singleton design
 */
public class Util {

    private static final Random random = new Random();

    /**
     * Instance of the class to be returned
     */
    private static Util instance = new Util();
    /**
     * date for formatting screenshots
     */
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy-hh-mm-ss");

    /**
     * Private Class constructor.
     */
    private Util() {
    }

    /**
     * Returns the static instance of the utilities class
     * 
     * @return instance
     */
    public static Util getInstance() {
        return instance;
    }
    
    /**
     * Returns the a random number in the specified range
     * 
     * @param Min The Minimum in the range
     * @param Max the maximum number possible
     * 
     * @return randomNumber
     */
    public static int random(int Min, int Max) {
        return random.nextInt(Math.abs(Max - Min)) + Min;
    }

    /**
     * Pauses the current thread for specified time
     * 
     * @param Time the time in milliseconds
     */
    public static void sleep(int Time) {
        try {
            Thread.sleep(Time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Pauses the current thread for specified amount of time
     * 
     * @param Min Minimum amount of time possible
     * @param Max the maximum amount of time possible
     */
    public static void sleepRandom(int Min, int Max) {
        sleep(random(Min, Max));
    }
    
    /**
     * Returns the current date
     * 
     * @return Calendar.getInstance().getTime()
     */
    private static Date getDate() {
        return Calendar.getInstance().getTime();
    }
    
    /**
     * Loads and returns an image from specified path
     * All exceptions are caught
     * 
     * @param ResourcePath the path of the image
     * 
     * @return Image
     */
    public static Image loadResourceImage(String ResourcePath) {
        try {
            return ImageIO.read(instance.getClass().getResource(ResourcePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Loads and returns an ImageIcon loaded from the specified path
     * all exceptions are caught
     * 
     * @return ImageIcon
     */
    public static ImageIcon loadIcon(String url) {
        try {
            return new ImageIcon(new URL(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
