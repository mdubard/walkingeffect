/* 
 * Team: Mary DuBard, Hannah Murphy, Alyssa Rivera
 * Writer for this Class: Mary DuBard
 * 
 * File name: WalkingEffectGUI.java
 * Date Created: 12/8/15
 * Last Updated: 12/10/15
 * 
 * Class that creates the Walking Effect GUI
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class WalkingEffectGUI{
  
  public static void main(String[] args){
    // creates and shows a Frame titled "The Walking Effect"
    JFrame frame = new JFrame("The Walking Effect");
    
    //creates a tabbed pane
    JTabbedPane tp = new JTabbedPane();
    
    //creates Map object
    Map map = new WellesleyMap();
    
    //adds three tabs
    AboutPanel about = new AboutPanel();
    HomePanel home = new HomePanel(map);
    AddLocationPanel addLoc = new AddLocationPanel(map);
    ExplorePanel ep = new ExplorePanel(map);
    tp.addTab("About", about);
    tp.addTab("Home", new JScrollPane(home));
    tp.addTab("Add Location", new JScrollPane(addLoc));
    tp.addTab("Explore", new JScrollPane(ep));
    
    //default close
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //adds tabbed panel to frame
    frame.getContentPane().add(tp);
    //sets size to screen size
    frame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    //frame.setResizable(false);
    frame.pack();
    
    //shows frame
    frame.setVisible(true);
  }
}