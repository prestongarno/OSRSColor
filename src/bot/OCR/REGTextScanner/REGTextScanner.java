package OCR.REGTextScanner;

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

    public REGTextScanner() {
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
            //System.out.println("Old POS: " + oldPOS + " Current: " + currentPosition);
            if((currentPosition - oldPOS) > 4 && (currentPosition - oldPOS) < 8) {
                result = result + " ";
            }
            //System.out.println(result);
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
                    if (current.getRed() > 194 && current.getBlue() > 194 && current.getGreen() > 194) {
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
                if (current.getRed() > 194 && current.getBlue() > 194 && current.getGreen() > 194) {
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
            if (current.getRed() > 196 && current.getBlue() > 196 && current.getGreen() > 196) {
                //System.out.println("Match found");
                numberOfMatches++;
            }
        }
        return numberOfMatches;
    }

}
