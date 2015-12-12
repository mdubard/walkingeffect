/* 
 * Team: Mary DuBard, Hannah Murphy, Alyssa Rivera
 * Writer for this Class: Mary DuBard
 * 
 * File name: HomePanel.java
 * Date Created: 12/8/15
 * Last Updated: 12/8/15
 * 
 * Class that contains Panel elements for the Home tab of the Walking Effect GUI
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class HomePanel extends JPanel{
  private JLabel header, origin, destination, footer;
  private JPanel navi, map;
  private JComboBox orig, dest;
  private JButton submit;
  private JTextArea keyText;
  private JTextPane directions;
  private String[] locs;
  private Map m;
  private JCheckBox stairs;
  private JCheckBox steep;
  
  public HomePanel(Map ma){
    //on load reload locs?
    m = ma;
    setLayout (new BorderLayout());
    
    header = new JLabel("\nPick your origin and destination below to receive the quickest path between them!", SwingConstants.CENTER);
    header.setFont(new Font("Courier New", Font.PLAIN, 16));
    
    locs = m.getLocations(); 
    //^^will be taken from Map object
    
    //initialize combo boxes, using String array ratings for values
    orig = new JComboBox(locs);
    dest = new JComboBox(locs);
    stairs = new JCheckBox("Avoid Stairs");
    steep = new JCheckBox("Avoid Hills");
    
    //initializes labels for combo boxes
    origin = new JLabel("Origin: ");
    origin.setFont(new Font("Helvetica", Font.PLAIN, 15));
    destination = new JLabel("Destination: ");
    destination.setFont(new Font("Helvetica Light", Font.PLAIN, 15));
    
    //creates submit button
    submit = new JButton("Submit");
    submit.addActionListener(new submitListener());
    submit.setFont(new Font("Courier New", Font.PLAIN, 12));
    
    //Creates panel for navigation options
    navi = new JPanel();
    navi.setLayout(new BoxLayout(navi, BoxLayout.Y_AXIS));
    navi.add(Box.createRigidArea(new Dimension(0, 50)));
    navi.add(origin);
    navi.add(Box.createRigidArea(new Dimension(0, 5)));
    navi.add(orig);
    navi.add(Box.createRigidArea(new Dimension(0, 50)));
    navi.add(destination);
    navi.add(dest);
    navi.add(stairs);
    navi.add(steep);
    navi.add(Box.createRigidArea(new Dimension(0, 100)));
    navi.add(submit);
    navi.add(Box.createRigidArea (new Dimension (0, 100)));
    
    //creates panel for map and key
    map = new JPanel();
    map.setLayout(new BoxLayout(map, BoxLayout.X_AXIS));
    //map.add(Box.createRigidArea(new Dimension(100, 0)));
    
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
      map.add(picLabel); //adds label to panel
    }
    catch(IOException io){
      System.out.println(io);
    }
    
    keyText = new JTextArea(12, 20);
    keyText.setMaximumSize(keyText.getPreferredSize());
    keyText.setEditable(false);
    keyText.append("Map Key: ");
    //keyText.setRows(1);
    for(int i = 0; i < locs.length; i++){
      keyText.append("\n");
      keyText.append(locs[i]);
    }
    
    JScrollPane jp = new JScrollPane(keyText);
    jp.setMaximumSize(keyText.getPreferredSize());
    map.add(jp);
    
    //Initializes footer
    directions = new JTextPane();
    directions.setEditable(false);
    directions.setText("<Directions here>");
    directions.setFont(new Font("Courier New", Font.PLAIN, 16));
    StyledDocument doc = directions.getStyledDocument();
    SimpleAttributeSet center = new SimpleAttributeSet();
    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
    doc.setParagraphAttributes(0, doc.getLength(), center, false);
    
    JScrollPane jp2 = new JScrollPane(directions);
    jp2.setMaximumSize(directions.getPreferredSize());
    
    //adds elements to frame
    add(header, BorderLayout.NORTH);
    add(navi, BorderLayout.WEST);
    add(map, BorderLayout.EAST);
    add(directions, BorderLayout.SOUTH);
  }
  
  private class submitListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      //save combo box values as a string, if no value was chosen, the default value is 1
      String origString = orig.getSelectedItem().toString();
      String destString = dest.getSelectedItem().toString();
      String stairsString = "Stairs an option. ";
      String hills = "Hills an option. ";
      if(stairs.isSelected())
        stairsString = "Stairs not an option. ";
      if(steep.isSelected())
        hills = "Hills not an option. ";
      
      directions.setText("Directions from " + origString + " to " + destString + ". " + stairsString + hills + "\n" + m.directionsString(m.findLocation(origString), m.findLocation(destString)));
      //add getDirections(origString, destString) to footer
    }
  }
}