
package console;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Preston Garno
 */
public class console extends JPanel {
    
    public static final console instance = new console();
    
    public static console getInstance(){ return instance;}
    
    private JScrollPane HUD;
    private JTextField input;
    private JTextArea textBox;
    private final String newline = "\n";
    
    private console(){
        setLayout(new BorderLayout(0, 5));
        
        
        textBox = new JTextArea(1, 1);
        textBox.setEditable(false);
        
        HUD = new JScrollPane(textBox);
        HUD.setPreferredSize(new Dimension(765, 100));
        
        input = new JTextField(765);
        
        add(HUD, BorderLayout.CENTER);
        
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
        
        setMinimumSize(new Dimension(765, 115));
    }
    
    public void log(String message) {
        instance.textBox.append(message + newline);
    }
    
    public String getLastLine(){
        String[] commands = instance.textBox.getText().split(newline);
        
        return commands[commands.length - 1];
    }
    
    
}
