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
  
  public HomePanel(){
    setLayout (new BorderLayout());
    
    header = new JLabel("\nPick your origin and destination below to receive the quickest path between them!", SwingConstants.CENTER);
    header.setFont(new Font("Courier New", Font.PLAIN, 16));
    
    String[] locs = {"(1) Acad Quad", "(2) Library", "(3) Lulu", "(4) Res Quad", "(5) Science Center"}; 
    //^^will be taken from Map object
    
    //initialize combo boxes, using String array ratings for values
    orig = new JComboBox(locs);
    dest = new JComboBox(locs);
    
    //initializes labels for combo boxes
    origin = new JLabel("Origin: ");
    origin.setFont(new Font("Courier New", Font.PLAIN, 15));
    destination = new JLabel("Destination: ");
    destination.setFont(new Font("Courier New", Font.PLAIN, 15));
    
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
    navi.add(Box.createRigidArea(new Dimension(0, 100)));
    navi.add(submit);
    navi.add(Box.createRigidArea (new Dimension (0, 100)));
    
    //creates panel for map and key
    map = new JPanel();
    map.setLayout(new BoxLayout(map, BoxLayout.X_AXIS));
    map.add(Box.createRigidArea(new Dimension(100, 0)));
    
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
    
    keyText = new JTextArea(1, 10);
    keyText.setEditable(false);
    keyText.setRows(1);
    for(int i = 0; i < locs.length; i++){
      keyText.append(locs[i]);
      keyText.append("\n");
    }
    
    JScrollPane jp = new JScrollPane(keyText);
    map.add(jp);
    
    //Initializes footer
    footer = new JLabel("<Directions here>", SwingConstants.CENTER);
    footer.setFont(new Font("Courier New", Font.PLAIN, 16));
    
    //adds elements to frame
    add(header, BorderLayout.NORTH);
    add(navi, BorderLayout.WEST);
    add(map, BorderLayout.EAST);
    add(footer, BorderLayout.SOUTH);
  }
  
  private class submitListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      //save combo box values as a string, if no value was chosen, the default value is 1
      String origString = orig.getSelectedItem().toString();
      String destString = dest.getSelectedItem().toString();
      //call getDirections(origString, destString)
      
      footer.setText("Directions from " + origString + " to " + destString + ".");
    }
  }
}