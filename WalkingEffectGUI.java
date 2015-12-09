/* 
 * Team: Mary DuBard, Hannah Murphy, Alyssa Rivera
 * Writer for this Class: Mary DuBard
 * 
 * File name: WalkingEffectGUI.java
 * Date Created: 12/8/15
 * Last Updated: 12/8/15
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
    
    //adds three tabs
    HomePanel home = new HomePanel();
    AddLocationPanel addLoc = new AddLocationPanel();
    ExplorePanel ep = new ExplorePanel();
    tp.addTab("Home", home);
    tp.addTab("Add Location", addLoc);
    tp.addTab("Explore", ep);
    
    //default close
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //adds tabbed panel to frame
    frame.getContentPane().add(tp);
    //sets size
    frame.setPreferredSize(new Dimension(1000,500));
    frame.setResizable(false);
    frame.pack();
    
    //shows frame
    frame.setVisible(true);
  }
}