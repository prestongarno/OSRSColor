
package main;

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
    public JMenuItem ScreenShot, AddTab;
    
    public MenuBar(){
        //Instantiate the menus
        File = new JMenu("File");
        Edit = new JMenu("Edit");
        Window = new JMenu("Window");
        Tools = new JMenu("Tools");
        Help = new JMenu("Help");
        
        //instantiate the menu items
        ScreenShot = new JMenuItem("ScreenShot");
        AddTab = new JMenuItem("New Tab");
        //add items to menus
        Tools.add(ScreenShot);
        Window.add(AddTab);
        //add the buttone
        add(File);
        add(Edit);
        add(Window);
        add(Tools);
        add(Help);
        //set visible?
        setVisible(true);
    }
}
