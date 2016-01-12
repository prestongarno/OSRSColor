/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocr;

import console.console;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 *
 * @author Preston Garno
 */
public class ocr {

    /**
     * The instance of this canvas --> make non-staic for multiple ocr threads
     */
    public static Canvas canvas;

    public ocr() {

    }

    public static void setCanvas(Canvas c) {
        ocr.canvas = c;
    }

    public static Canvas getCanvas() {
        return canvas;
    }

    public static BufferedImage getScreenShotOfCurrentCanvas() {

        BufferedImage imageTEST = new BufferedImage(ocr.canvas.getWidth(), ocr.canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
        //apparently graphicscontext has some answers in the paintlistener that we add
        Graphics g = ocr.canvas.getGraphics();
        

        // The below code doesn't work
        /**************************************************/
        console.log("ocr method called...");
        BufferedImage image = new BufferedImage(ocr.canvas.getWidth(), ocr.canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g2d = image.createGraphics();
        ocr.canvas.print(g2d);
        g2d.dispose();
        console.log("image created...");
        /************************************************/
        
        return imageTEST;
    }
}
