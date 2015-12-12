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
    Map map = new Map();
    
    Location lulu = new Location("Lulu");
    Location lib = new Location("Library");
    Location resQ = new Location("Res Quad");
    Location sciCen = new Location("Science Center");
    Location acaQ = new Location("Acad Quad");
    
    map.addVertex(lulu);
    map.addVertex(lib);
    map.addVertex(resQ);
    map.addVertex(sciCen);
    map.addVertex(acaQ);
    
    map.addEdge(lulu, acaQ, new Path(4, false, false));
    map.addEdge(lib, acaQ, new Path(4, false, false));
    map.addEdge(lulu, resQ, new Path(4, false, false));
    map.addEdge(resQ, sciCen, new Path(8, false, false));
    map.addEdge(lib, sciCen, new Path(5, false, false));
    
    //adds three tabs
    HomePanel home = new HomePanel(map); //will pass map into home
    AddLocationPanel addLoc = new AddLocationPanel();
    ExplorePanel ep = new ExplorePanel(map);
    tp.addTab("Home", new JScrollPane(home));
    tp.addTab("Add Location", new JScrollPane(addLoc));
    tp.addTab("Explore", new JScrollPane(ep));
    
    //default close
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //adds tabbed panel to frame
    frame.getContentPane().add(tp);
    //sets size
    frame.setPreferredSize(new Dimension(1000,500));
    //frame.setResizable(false);
    frame.pack();
    
    //shows frame
    frame.setVisible(true);
  }
}