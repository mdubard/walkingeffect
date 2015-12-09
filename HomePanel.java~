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
  private JPanel navi;
  private JComboBox orig, dest;
  private JButton submit;
  
  public HomePanel(){
    setLayout (new BorderLayout());
    
    header = new JLabel("\nPick your origin and destination below to receive the quickest path between them!", SwingConstants.CENTER);
    header.setFont(new Font("Courier New", Font.PLAIN, 16));
    
    String[] locs = {"(1) Acad Quad", "(2) Library", "(3) Lulu", "(4) Res Quad", "(5) Science Center"};
    
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
    navi.setLayout(new BoxLayout(navi, BoxLayout.PAGE_AXIS));
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
    
    //adds map image
    try{
      BufferedImage myPicture = ImageIO.read(new File("map.png"));
      ImageIcon pic = new ImageIcon(myPicture);
      Image img = pic.getImage();
      BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
      Graphics g = bi.createGraphics();
      g.drawImage(img, 100, 20, 500, 300, null); //locates and sizes image
      ImageIcon newIcon = new ImageIcon(bi);
      JLabel picLabel = new JLabel(newIcon);  //adds image to label
      add(picLabel, BorderLayout.EAST); //adds label to panel
    }
    catch(IOException io){
      System.out.println(io);
    }
    
    //Initializes footer
    footer = new JLabel("<Directions here>", SwingConstants.CENTER);
    footer.setFont(new Font("Courier New", Font.PLAIN, 16));
    
    //adds elements to frame
    add(header, BorderLayout.NORTH);
    add(navi, BorderLayout.WEST);
    add(footer, BorderLayout.SOUTH);
  }
  
  private class submitListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
    }
  }
}