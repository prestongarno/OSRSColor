/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScriptLoader;

import ScriptLoader.Actions.click;
import ScriptLoader.Actions.faceNorth;
import java.util.ArrayList;

/**
 *
 * @author Preston Garno
 */
public class CMD {
    public static final faceNorth FACENORTH = new faceNorth();
    public static final click clickConsole = new click();
    
    public static final ArrayList<OSAction> commands = new ArrayList<OSAction>() {{
        
        add(FACENORTH);
        add(clickConsole);
        
        }
    };
}
