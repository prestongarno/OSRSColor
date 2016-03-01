package console;

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

    public static final console instance = new console();

    public static console getInstance() {
        return instance;
    }

    private JScrollPane HUD;
    private JTextField input;
    private JTextArea textBox;
    private static final String newline = "\n";

    private console() {
        setLayout(new BorderLayout(0, 5));
        //add(MenuBar.getInstance(), BorderLayout.NORTH);
        textBox = new JTextArea(1, 1);
        textBox.setEditable(false);

        HUD = new JScrollPane(textBox);
        HUD.setSize(new Dimension(765, 100));
        HUD.setSize(new Dimension(765, 100));

        input = new JTextField(765);

        add(HUD, BorderLayout.CENTER);
        
        DefaultCaret caret = (DefaultCaret) this.textBox.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER && input.isCursorSet()) {
                    log(input.getText());
                    input.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        add(input, BorderLayout.SOUTH);

        setPreferredSize(new Dimension(765, 115));
    }

    public static void log(String message) {
        instance.textBox.append(message + newline);
        

    }

    public String getLastLine() {
        String[] commands = instance.textBox.getText().split(newline);

        return commands[commands.length - 1];
    }

    public void displayException(Exception ex) {
        log(ex.getMessage());
    }

    public static void log(Exception ex) {
        StackTraceElement[] stackTrace = ex.getStackTrace();
        log("ERROR!" + ex.getClass() + " Exception at:");
        for (StackTraceElement stackTrace1 : stackTrace) {
            log(stackTrace1.toString());
        }
        
    }
}
