package loader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import resources.SplashScreen;
import utilities.*;

/**
 * @author Preston Garno
 *
 * Holds and starts the GamePanel JPanel/AppletStub
 */
public class PanelHolder extends JPanel implements Runnable {

    public GamePanel game;
    private String world;

    public PanelHolder(String world) {
        this.world = world;
    }

    public void stopGame() {
        game.stop();
    }

    @Override
    public void run() {
        setBackground(Color.BLACK);
        setVisible(true);
        this.setPreferredSize(new Dimension(765, 553));
        setLayout(new BorderLayout());
        //Add SplashScreen
        add(new SplashScreen(), BorderLayout.CENTER);
        //start loading the applet
        game = new GamePanel(world, 765, 553);
        removeAll();
        add(game, BorderLayout.CENTER);
        game.start();
    }

}
