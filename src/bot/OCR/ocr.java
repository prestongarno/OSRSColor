/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot.OCR;

import java.awt.image.BufferedImage;
import OCR.REGTextScanner.REGTextScanner;

/**
 * @author Preston Garno
 */
public class ocr {
    
    private REGTextScanner regScanner;
    
    public ocr() {
        this.regScanner = new REGTextScanner();
    }
    
    public String readTopLeft(BufferedImage screenGrab){
        return regScanner.doOCR(screenGrab);
    }
    
    // need an anti-ban scanner thread running constantly.
    
    public String readChatBox() {
        return "";
    }

}
