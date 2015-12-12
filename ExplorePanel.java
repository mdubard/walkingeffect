/* 
 * Team: Mary DuBard, Hannah Murphy, Alyssa Rivera
 * Writer for this Class: Mary DuBard, Alyssa Rivera
 * 
 * File name: ExplorePanel.java
 * Date Created: 12/8/15
 * Last Updated: 12/11/15
 * 
 * Class that contains Panel elements for the Explore tab of the Walking Effect GUI
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Scanner;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ExplorePanel extends JPanel{
  private JButton exploreButton;
  private JLabel header, name, picLabel;
  private JTextArea about, keyText;
  private JScrollPane aboutScroll;
  private JComboBox locMenu;
  private Map map;
  private Location[] locations;
  private Location chosenLocation;
  
  
  public ExplorePanel(Map m){ //pass in Map from GUI driver
    //testing
    map = m;
    Location a = new Location("A", "The letter A", "wellesleylogo.png");
    Location b = new Location ("B", "the letter B", "bTest.jpeg");
    map.addVertex(a);
    map.addVertex(b);
    map.addEdge(a, b, new Path(2, false, false));
    chosenLocation = new Location (" ");
    //get location information (from Map passed in)
    //map = m;
    locations = map.getAllVertices();
    
    
    
    //initialize everything
    
    exploreButton = new JButton("Explore!");
    exploreButton.addActionListener(new ExploreButtonListener());
    
    header = new JLabel("Use this menu to learn more about the locations on Wellesley's campus.");
    name = new JLabel ("You Selected" + chosenLocation.getName());
    
    locMenu = new JComboBox();
    //locMenu.setPreferredSize(new Dimension (50, 100));
    
    locMenu.addItem("Select a Location");
    for(int i = 0; i < map.n(); i++){
      locMenu.addItem(locations[i].getName());
    }
    
    about = new JTextArea("About " + chosenLocation.getAbout());
    about.setPreferredSize(new Dimension(500, 150));
    about.setLineWrap(true);
    aboutScroll = new JScrollPane (about, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    
    //layout manager, addeverything
    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
    leftPanel.add(Box.createRigidArea (new Dimension (5, 70)));
    leftPanel.add(locMenu);
    leftPanel.add(Box.createRigidArea (new Dimension (5, 30)));
    leftPanel.add(exploreButton);
    leftPanel.add(Box.createRigidArea (new Dimension (5, 80)));
    
    JPanel rightPanel = new JPanel();
    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.X_AXIS));
    //rightPanel.add(Box.createRigidArea(new Dimension(100, 0)));
    //adds map image
    try{
      BufferedImage myPicture = ImageIO.read(new File("map.png"));
      ImageIcon pic = new ImageIcon(myPicture);
      Image img = pic.getImage();
      BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
      Graphics g = bi.createGraphics();
      g.drawImage(img, 100, 50, 500, 350, null); //locates and sizes image
      ImageIcon newIcon = new ImageIcon(bi);
      JLabel picLabel = new JLabel(newIcon);  //adds image to label
      rightPanel.add(picLabel); //adds label to panel
    }
    catch(IOException io){
      System.out.println(io);
    }
    keyText = new JTextArea(12, 20);
    keyText.setMaximumSize(keyText.getPreferredSize());
    keyText.setEditable(false);
    keyText.append("Map Key: ");
    //keyText.setRows(1);
    for(int i = 0; i < map.n(); i++){
      keyText.append("\n");
      keyText.append(locations[i].getName());
    }
    
    JScrollPane jp = new JScrollPane(keyText);
    jp.setMaximumSize(keyText.getPreferredSize());
    rightPanel.add(jp);
    
    
    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new BorderLayout());
    bottomPanel.add(name, BorderLayout.NORTH);
    bottomPanel.add(about, BorderLayout.WEST);
  //  try{
      ImageIcon pic = new ImageIcon(chosenLocation.getPic());
      Image img = pic.getImage();
      BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
      Graphics g = bi.createGraphics();
      g.drawImage(img, 100, 50, 500, 350, null); //locates and sizes image
      ImageIcon newIcon = new ImageIcon(bi);
      picLabel = new JLabel(newIcon);  //adds image to label
      bottomPanel.add(picLabel); //adds label to panel
   // }
    
    
    //add picture to bottom panel
    this.setLayout (new BorderLayout());
    this.add(header, BorderLayout.NORTH);
    this.add(leftPanel, BorderLayout.WEST);
    this.add(rightPanel, BorderLayout.EAST);
    this.add(bottomPanel, BorderLayout.SOUTH);
    
    
    
    
    
  }
  
  private class ExploreButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      //System.out.println("action");
      String s = locMenu.getItemAt(locMenu.getSelectedIndex()).toString();
      System.out.println("Selected: " + s);
      if(s.equals("Select a Location")){
        return;
      }
      else{
        for (int i = 0; i<map.n(); i++){
          if(s.equals(locations[i].getName())){
            chosenLocation = locations[i];
            System.out.println("Location found in array");
          } 
        }
        name.setText ("You Selected:    " + chosenLocation.getName());
        about.setText("About:     " + chosenLocation.getAbout());
        
      ImageIcon pic = new ImageIcon(chosenLocation.getPic());
      Image img = pic.getImage();
      BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
      Graphics g = bi.createGraphics();
      g.drawImage(img, 100, 50, 500, 350, null); //locates and sizes image
      ImageIcon newIcon = new ImageIcon(bi);
      picLabel.setIcon(newIcon);
        
        
      }
      
    }
  } 
}