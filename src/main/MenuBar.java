
package main;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Preston Garno
 */
public class MenuBar extends JMenuBar {
    //**List of all menu options*/
    private JMenu File, Edit, Window, Tools, Help;
    //**List of all Menu Items*/
    //public in order to simplify assigning actionlisteners
    public JMenuItem ScreenShot, AddTab, RemoveTab;
    public JButton saveTopText;
    
    public MenuBar(){
        //Instantiate the menus
        File = new JMenu("File");
        Edit = new JMenu("Edit");
        Window = new JMenu("Window");
        Tools = new JMenu("Tools");
        Help = new JMenu("Help");
        
        //gettopleft button develping OCR
        saveTopText = new JButton("TopLeft");
        
        //instantiate the menu items
        ScreenShot = new JMenuItem("ScreenShot");
        AddTab = new JMenuItem("New Tab");
        RemoveTab = new JMenuItem("Close Tab");
        //add items to menus
        Tools.add(ScreenShot);
        Window.add(AddTab);
        Window.add(RemoveTab);
        //add the buttone
        add(File);
        add(Edit);
        add(Window);
        add(Tools);
        add(Help);
        add(saveTopText);
        //set visible?
        setVisible(true);
    }
}
