package console;

import GUImenus.debugPanel;
import ScriptLoader.CMD;
import ScriptLoader.OSAction;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;
//import main.MenuBar;

/**
 *
 * @author Preston Garno
 */
public class console extends JPanel {
    
    /**
     * The one and only
     */
    public static final console instance = new console();
    
    /**
     * Returns the console but using public final instance saved me
     * so much typing in the end
     */
    public static console getInstance() {
        return instance;
    }

    private JScrollPane HUD;
    private JTextField input;
    private JTextArea textBox;
    private static final String newline = "\n";
    
    /**
     * Public constructor
     */
    private console() {
        setLayout(new BorderLayout(0, 5));
        //add(MenuBar.getInstance(), BorderLayout.NORTH);
        textBox = new JTextArea(1, 1);
        textBox.setEditable(false);

        HUD = new JScrollPane(textBox);
        HUD.setSize(new Dimension(600, 150));
        input = new JTextField(600);
        add(debugPanel.getInstance(), BorderLayout.NORTH);
        add(HUD, BorderLayout.CENTER);
        
        DefaultCaret caret = (DefaultCaret) this.textBox.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            
            String[] raw;
            String[] args;
            
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER && input.isCursorSet()) {
                    log(input.getText());
                    
                    try {
                        
                        boolean validCommand = false;
                        
                        raw = input.getText().split("\\s+");
                        args = new String[raw.length - 1];
                        
                        if(raw.length > 0) {
                            for(int i = 1; i < raw.length; i++) {
                                args[i-1] = raw[i];
                            }
                        }
                        for (OSAction a : CMD.commands) {
                            if(raw[0].equals(a.toString())) {
                                try {
                                    a.perform(args);
                                } catch (Exception meh) {
                                    log(meh);
                                }
                                validCommand = true;
                            }
                        }
                        if (validCommand == false) {
                            log("Invalid input!");
                        }
                    } catch (Exception ex) {
                        log("Invalid Input: " + ex.getLocalizedMessage());
                        log(ex);
                    } finally {
                        input.setText("");
                    }
                    
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        add(input, BorderLayout.SOUTH);
        
        setPreferredSize(new Dimension(600, 200));
    }
    
    /**
     * Write to the console
     * @param message
     */
    public static void log(String message) {
        instance.textBox.append(message + newline);
    }
    
    /**
     * eventually used to run commands from the console
     */
    public String getLastLine() {
        String[] commands = instance.textBox.getText().split(newline);
        return commands[commands.length - 1];
    }
    
    /**
     * print stacktrace since it won't print to standard console because 
     * of the Xboot JVM arg
     */
    public static void log(Exception ex) {
        StackTraceElement[] stackTrace = ex.getStackTrace();
        log("ERROR!" + ex.getClass() + " Exception at:");
        for (StackTraceElement stackTrace1 : stackTrace) {
            log(stackTrace1.toString());
        }
        
    }
}
