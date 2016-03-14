package bot.OCR.REGTextScanner;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * @author Preston Garno
 */
public class REGTextScanner {

    private BufferedImage screenGrab;
    public Point startPoint;
    private int HEIGHT;
    private int WIDTH;
    private int currentPosition;
    
    //colors for matching text
    private Color whiteMAX;
    private Color whiteMIN;
    private Color cyanMAX;
    private Color cyanMIN;
    private Color bronzeMAX;
    private Color bronzeMIN;
    private Color yellowMAX;
    private Color yellowMIN;

    public REGTextScanner() {
        this.whiteMAX = new Color(255, 255, 255);
        this.whiteMIN = new Color(196, 196, 196);
        this.cyanMAX = new Color(60, 250, 250);
        this.cyanMIN = new Color(0, 190, 190);
        this.bronzeMAX = new Color(248, 155, 90);
        this.bronzeMIN = new Color(190, 100, 45);
        this.yellowMAX = new Color(250, 250, 40);
        this.yellowMIN = new Color(200, 200, 0);
        
        currentPosition = 0;
    }

    public String doOCR(BufferedImage screenGrab) {
        this.screenGrab = screenGrab;
        HEIGHT = screenGrab.getHeight();
        WIDTH = screenGrab.getWidth();
        String result = "";
        currentPosition = getStartingPoint(currentPosition).x;
        ArrayList<Integer> rows;
        int oldPOS = 0;
        while (currentPosition < screenGrab.getWidth()) {
            
            rows = new ArrayList<>();
            while (getNumberInRow(currentPosition) > 0) {
                rows.add(getNumberInRow(currentPosition));
                currentPosition++;
            }

            int[] arrayToMatch = new int[rows.size()];
            for (int i = 0; i < arrayToMatch.length; i++) {
                arrayToMatch[i] = rows.get(i);
            }
            oldPOS = currentPosition;

            char character = RegValues.getMatch(arrayToMatch);

            result = result + character;
            currentPosition = getNextLetter();

            if((currentPosition - oldPOS) > 4 && (currentPosition - oldPOS) < 8) {
                result = result + " ";
            }
        }

        return result;
    }

    private ArrayList getNumOfPixels() {
        int[][] number;
        ArrayList<Integer> rows = new ArrayList<>();
        //while row has a white text pixel, get the number in the row and add it
        int xPos = 0;
        while (xPos < screenGrab.getWidth()) {
            //System.out.println("Element added!");
            rows.add(getNumberInRow(xPos));
            currentPosition++;
            xPos++;
        }
        currentPosition = 0;
        return rows;
    }

    private Point getStartingPoint(int currentPOS) {
        this.startPoint = null;
        int x = currentPOS;
        int y;
        while (startPoint == null) {
            while (x < WIDTH && startPoint == null) {
                y = 0;
                while (y < HEIGHT && startPoint == null) {
                    Color current = new Color(screenGrab.getRGB(x, y));
                    if (matchesAnyKnownFontColors(current)) {
                        //Find the starting point of the Text
                        this.startPoint = new Point(x, y);
                    }
                    y++;
                }
                x++;
            }
            if (startPoint == null) {
                startPoint = new Point(0, 0);
            }
        }
        return startPoint;
    }
    
    private int getNextLetter(){
        int xValue = currentPosition;
        Color current;
        for (int x = currentPosition; x < screenGrab.getWidth(); x++) {
            for (int y = 0; y<screenGrab.getHeight(); y++){
                current = new Color(screenGrab.getRGB(x, y));
                if (matchesAnyKnownFontColors(current)) {
                    xValue = x;
                    return xValue;
                }
            }
        }
        currentPosition = screenGrab.getWidth();
        return currentPosition;
    }

    private int getNumberInRow(int x) {
        int numberOfMatches = 0;
        for (int y = 0; y < screenGrab.getHeight(); y++) {
            Color current = new Color(screenGrab.getRGB(x, y));
            if (matchesAnyKnownFontColors(current)) {
                numberOfMatches++;
            }
        }
        return numberOfMatches;
    }
    
    private boolean matchesAnyKnownFontColors(Color current) {
        return isWhite(current) || isCyan(current) || isBronze(current) || isYellow(current);
    }
    
    private boolean isWhite(Color current){
        return isInRange(current, whiteMAX, whiteMIN);
    }
    
    private boolean isCyan(Color current) {
        return isInRange(current, cyanMAX, cyanMIN);
    }
    
    private boolean isBronze(Color current) {
        return isInRange(current, bronzeMAX, bronzeMIN);
    }

    private boolean isYellow(Color current) {
        return isInRange(current, yellowMAX, yellowMIN);
    }
    
    private boolean isInRange(Color target, Color MAX, Color MIN) {
        return target.getRed() >= MIN.getRed() && target.getBlue() >= MIN.getBlue() && target.getGreen() >= MIN.getGreen() && target.getRed() <= MAX.getRed() && target.getBlue() <= MAX.getBlue() && target.getGreen() <= MAX.getGreen();
    }
}
