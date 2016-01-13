
package ocr;

import java.util.ArrayList;

/**
 *
 * @author pgarno
 * 
 * Class check number of pixels per row, runs through alphabet for matches
 * 
 */
public class titleOCR {
    
    private static final titleOCR instance = new titleOCR();
    
    private titleOCR(){
        
    }
    
    /**Get the static instance of this class*/
    public titleOCR getInstance(){
        return instance;
    }
    
    public static String loopAlphabet(){
        
        //Here we have call the method for each char possible for a match
        //If no match, search for y != any of the possible colors (i.e. the next character)
        ArrayList<String> characters = new ArrayList<>();
        //add all of the possible characters here
        //74 total characters.  A lot of freaking methods we have to write
        return null;
    }
}
