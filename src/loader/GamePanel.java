package loader;

import GUImenus.MenuFunctions;
import GUImenus.debugPanel;
import Overlay.*;
import console.console;
import listener.PaintListener;
import utilities.*;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import controller.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//import ocr.ocr;
import resources.SplashScreen;

/**
 * @author Preston Garno
 *
 * JPanel that loads and starts the game applet
 */
public class GamePanel extends JPanel implements AppletStub, Runnable {

    private static final long serialVersionUID = 5627929030422355843L;
    private final HashMap<String, String> parameters = new HashMap<>();
    //**The game applet.  Public because the canvas needs to be accessed easily*/
    public Applet applet;
    private URLClassLoader loader;
    private URL codebase, documentBase;
    private SplashScreen loadingScreen;
    private Point p;

    public GamePanel() {
        applet = new Applet();
    };
    
    @Override
    public void run() {
        //this.create("http://oldschool.runescape.com", 765, 553);
        
        this.create("http://oldschool.runescape.com", 765, 553);
    }

    /**
     * Public constructor, loads and adds the applet to the panel
     *
     * @param world the specified world to start the game in
     * @param width width of the applet
     * @param height height of the applet
     */
    public void create(String world, int width, int height) {

        try {

            this.setLayout(new BorderLayout(0, 0));
            loadingScreen = new SplashScreen();
            this.add(loadingScreen, BorderLayout.CENTER);
            controller.frame.pack();
            //download "jav_config.ws" and find main class
            HTTPSocket socket = new HTTPSocket(world + "/jav_config.ws");
            String lines[] = socket.getPage(null).replaceAll("param=|msg=", "").split("\r|\n|\r\n"); //param=|msg=(.*?)\r|\n|\r\n

            for (String line : lines) {
                if (line.length() > 0) {
                    int idx = line.indexOf("=");
                    parameters.put(line.substring(0, idx), line.substring(idx + 1));
                }
            }

            //start applet
            codebase = documentBase = new URL(parameters.get("codebase"));
            loader = new URLClassLoader(new URL[]{new URL(codebase + parameters.get("initial_jar"))});
            applet = (Applet) loader.loadClass(parameters.get("initial_class").replace(".class", "")).newInstance();
            applet.setStub(this);
            applet.setPreferredSize(new Dimension(width, height));
            this.remove(loadingScreen);
            this.add(applet, BorderLayout.CENTER);
            this.start();
            MenuFunctions.addActions();
            controller.frame.pack();
            this.getApplet().getComponent(0).addMouseListener(debugPanel.mouseListener);
            //this.getApplet().getComponent(0).addMouseMotionListener(debugPanel.motionListener);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Loading.. Please Check Your Internet Connection.", "Error Loading..", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * ****************************
     * Get the canvas and draws on it
     *
     * @param canvas the current canvas instance
     *****************************
     */
    public static void notifyCanvasReady(Canvas canvas) {
        canvas.addPaintListener((PaintListener) g -> {
            controller.setBotCanvasInstance();
            
            canvasOverlay.getInstance().drawAll(g);
        });
    }

    /**
     * 
     * Starts the applet 
     */
    public void start() {
        if (applet != null) {
            applet.init();
            applet.start();

            while (applet.getComponentCount() < 1) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {

                }
            }
        }
    }

    /**
     * 
     * Stops the applet, calls destroy() 
     */
    public void stop() {
        if (applet != null) {
            applet.stop();
            applet.destroy();
            applet = null;
        }
    }

    /**
     * ******************************
     * Method to get the current instance of the applet
     *
     * @return applet the game applet 
     */
    public Applet getApplet() {
        return applet;
    }

    /**
     * ******************************
     * Gets and returns the canvas from the applet
     *
     * @return canvas the game canvas 
     */
    public Canvas getCanvas() {
        return (Canvas) applet.getComponent(0);
    }

    /**
     * ******************************
     * Returns the classloader
     *
     * @return loader the class loader 
     */
    public ClassLoader getClassLoader() {
        return loader;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public URL getDocumentBase() {
        return documentBase;
    }

    @Override
    public URL getCodeBase() {
        return codebase;
    }

    @Override
    public String getParameter(String name) {
        return parameters.get(name);
    }

    @Override
    public AppletContext getAppletContext() {
        return applet.getAppletContext();
    }

    @Override
    public void appletResize(int width, int height) {
        applet.setSize(width, height);
    }

    public BufferedImage getScreen() {
        return this.getCanvas().getScreen();
    }

}
