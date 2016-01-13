package loader;

import console.*;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JTabbedPane;

/**
 * @author Preston Garno
 */
public class tabbedPane extends JTabbedPane {

    //**ArrayList of game objects*/
    public ArrayList<PanelHolder> games = null;
    public ArrayList<Thread> threadManager = null;

    public tabbedPane() {
        games = new ArrayList<>();
        threadManager = new ArrayList<>();

        setVisible(true);
    }
    
    public void addGame(PanelHolder game) {
        games.add(game);
    }

    public void stopAllApplets() {
        games.stream().forEach((game) -> {
            game.stopGame();
        });
        threadManager.stream().forEach((threadManager1) -> {
            threadManager1.stop();
        });
    }
    
    public void stopApplet(int index){
        try {
            console.log("Index of tab closed: " + index + " = Index of game applet: " + index);
            games.get(index).stopGame();
            threadManager.get(index).stop();
        } catch (Exception ex) {
            console.log(ex);
        }
    }
    
    public void addThread(Thread thread) {
        threadManager.add(thread);
    }
    
    public int lastGameIndex(){
        return games.size() - 1;
    }
}
