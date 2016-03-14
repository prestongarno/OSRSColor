package java.awt;

import bot.bot;
import console.console;
import listener.PaintListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.peer.CanvasPeer;
import javax.accessibility.*;
import loader.*;

/**
 * @author Preston Garno
 * 
 * Overrides the java.awt.component.canvas class
 */
public class Canvas extends Component implements Accessible {

    private static final long serialVersionUID = -2284879212465893870L;
    private static int nameCounter = 0;
    private static final String base = "canvas";
    
    private BufferedImage debugImage;
    private transient PaintListener paintListener;
    
    /**
     * Public Constructor
     */
    public Canvas(){
        GamePanel.notifyCanvasReady(this);
        console.log("Canvas constructor called");
    }
    
    /**
     * Adds a listener so we can hook the canvas
     * 
     * @param listener An instance of PaintListener
     */
    public void addPaintListener(PaintListener listener) {
        paintListener = (PaintListener)AWTEventMulticaster.addInternal(paintListener, listener);
    }
    
    @Override
    public Graphics getGraphics() {
        if (debugImage == null || debugImage.getWidth() != getWidth() || debugImage.getHeight() != getHeight()) {
            debugImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }
        
        Graphics g = debugImage.getGraphics();

        if (paintListener != null) {
            paintListener.onPaint(g);
        }

        super.getGraphics().drawImage(debugImage, 0, 0, null);
        
        return g;
    }
    
    @Override
    public void setVisible(boolean visible) {
        //Main.notifyCanvasReady(this);
        super.setVisible(visible);
    }

    @Override
    void setGraphicsConfiguration(GraphicsConfiguration gc) {
        synchronized(getTreeLock()) {
            CanvasPeer peer = (CanvasPeer)getPeer();
            if (peer != null) {
                gc = peer.getAppropriateGraphicsConfiguration(gc);
            }
            super.setGraphicsConfiguration(gc);
        }
    }

    @Override
    String constructComponentName() {
        synchronized (Canvas.class) {
            return base + nameCounter++;
        }
    }

    @Override
    public void addNotify() {
        synchronized (getTreeLock()) {
            if (peer == null)
                peer = getToolkit().createCanvas(this);
            super.addNotify();
        }
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, width, height);
        super.paint(g);
    }

    @Override
    public void update(Graphics g) {
        g.clearRect(0, 0, width, height);
        paint(g);
    }

    @Override
    boolean postsOldMouseEvents() {
        return true;
    }

    @Override
    public void createBufferStrategy(int numBuffers) {
        super.createBufferStrategy(numBuffers);
    }

    @Override
    public void createBufferStrategy(int numBuffers, BufferCapabilities caps) throws AWTException {
        super.createBufferStrategy(numBuffers, caps);
    }

    @Override
    public BufferStrategy getBufferStrategy() {
        return super.getBufferStrategy();
    }

    @Override
    public AccessibleContext getAccessibleContext() {
        if (accessibleContext == null) {
            accessibleContext = new AccessibleAWTCanvas();
        }
        return accessibleContext;
    }

    public BufferedImage getScreen() {
        return debugImage;
    }

    protected class AccessibleAWTCanvas extends AccessibleAWTComponent {
        private static final long serialVersionUID = -6325592262103146699L;

        @Override
        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.CANVAS;
        }
    }
}
