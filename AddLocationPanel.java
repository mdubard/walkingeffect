import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class AddLocationPanel extends JPanel{
  private JLabel header, enterName, nearbyLoc1, nearbyLoc2, dist1, dist2, time1, time2, hasHills, hasStairs, availLocs, footer;
  private JPanel navi, mapPic;
  private JComboBox nearbyLoc1Combo, nearbyLoc2Combo;
  private JButton add;
  private JTextArea keyText;
  private JTextField locName, distField1, distField2, timeField1, timeField2;
  private JCheckBox hasHillsCheck1, hasStairsCheck1, hasHillsCheck2, hasStairsCheck2;
  private Map instanceMap;
  private String[] locs, comboLocs;
  
  public AddLocationPanel(Map map){
    instanceMap = map;
    setLayout (new BorderLayout());
    
    header = new JLabel("\nFill in the fields below to add a custom location to your map!", SwingConstants.CENTER);
    header.setFont(new Font("Courier New", Font.PLAIN, 16));
    
    locs = instanceMap.getLocations();
    
    comboLocs = instanceMap.getLocationsCombo();
      //initialize combo boxes, using String array ratings for values
    nearbyLoc1Combo = new JComboBox(comboLocs);
    nearbyLoc2Combo = new JComboBox(comboLocs);
    
    enterName = new JLabel("Name of new Location");
    enterName.setFont(new Font("Courier New", Font.PLAIN, 15));
    locName = new JTextField(20);
    
    //initializes labels for combo boxes
    nearbyLoc1 = new JLabel("Nearby Location 1: ");
    nearbyLoc1.setFont(new Font("Courier New", Font.PLAIN, 15));
    nearbyLoc2 = new JLabel("Nearby Location 2: ");
    nearbyLoc2.setFont(new Font("Courier New", Font.PLAIN, 15));
    
    dist1 = new JLabel("Distance to Location 1: ");
    distField1 = new JTextField(10);
    time1 = new JLabel("Time to Location 1: ");
    timeField1 = new JTextField(10);
    hasHillsCheck1 = new JCheckBox("The Path to Location 1 has Hills");
    hasStairsCheck1 = new JCheckBox("The Path to Location 1 has Stairs");
    
    dist2 = new JLabel("Distance to Location 2: ");
    distField2 = new JTextField(20);
    time2 = new JLabel("Time to Location 2: ");
    timeField2 = new JTextField(20);
    hasHillsCheck2 = new JCheckBox("The Path to Location 2 has Hills");
    hasStairsCheck2 = new JCheckBox("The Path to Location 2 has Stairs");
    
    //creates submit button
    add = new JButton("Add Location");
    add.setPreferredSize(new Dimension(40, 40));
    add.addActionListener(new AddButtonListener());
    add.setFont(new Font("Courier New", Font.PLAIN, 12));
    
    //Creates panel for navigation options
    navi = new JPanel();
    navi.setLayout(new BoxLayout(navi, BoxLayout.Y_AXIS));
    navi.add(Box.createRigidArea(new Dimension(0, 50)));
    navi.add(enterName);
    navi.add(locName);
    
    navi.add(nearbyLoc1);
    //navi.add(Box.createRigidArea(new Dimension(0, 5)));
    navi.add(nearbyLoc1Combo);
    navi.add(dist1);
    navi.add(distField1);
    //navi.add(time1);
    //navi.add(timeField1);
    navi.add(hasHillsCheck1);
    navi.add(hasStairsCheck1);
    
    navi.add(Box.createRigidArea(new Dimension(0, 10)));
    navi.add(nearbyLoc2);
    navi.add(nearbyLoc2Combo);
    navi.add(dist2);
    navi.add(distField2);
    navi.add(hasHillsCheck2);
    navi.add(hasStairsCheck2);
    navi.add(add);

    
    //creates panel for map and key
    mapPic = new JPanel();
    mapPic.setLayout(new BoxLayout(mapPic, BoxLayout.X_AXIS));
    mapPic.add(Box.createRigidArea(new Dimension(100, 0)));
    
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
      mapPic.add(picLabel); //adds label to panel
    }
    catch(IOException io){
      System.out.println(io);
    }
    
    keyText = new JTextArea(12, 20);
    keyText.setMaximumSize(keyText.getPreferredSize());
    keyText.setEditable(false);
    keyText.append("Map Key: ");
    keyText.setRows(1);
    for(int i = 0; i < locs.length; i++){
      keyText.append("\n");
      keyText.append(locs[i]);
    }
    
    JScrollPane jp = new JScrollPane(keyText);
    jp.setMaximumSize(keyText.getPreferredSize());
    
    availLocs = new JLabel("Already Added Locations:");
    
    mapPic.add(jp);
    
    //Initializes footer
    footer = new JLabel("<Directions here>", SwingConstants.CENTER);
    footer.setFont(new Font("Courier New", Font.PLAIN, 16));
    
    //adds elements to frame
    add(header, BorderLayout.NORTH);
    add(navi, BorderLayout.WEST);
    add(mapPic, BorderLayout.EAST);
    add(footer, BorderLayout.SOUTH);
  }
  
  private class AddButtonListener implements ActionListener{
    private String newNearbyLoc1;
    private String newNearbyLoc2;
    
    public void actionPerformed(ActionEvent event){
      footer.setText("Yo");
      
      //save combo box values as a string, if no value was chosen, the default value is 1
      String newLocName = locName.getText();
      Location l = new Location(newLocName);
      footer.setText(newLocName);
      instanceMap.addVertex(l);
      /*String[] locs = instanceMap.getLocations();
      String s = ""; 
      for(int i = 0; i < locs.length; i++){
        s += locs[i] + " ";
      }
      footer.setText(s);
*/
      
      newNearbyLoc1 = nearbyLoc1Combo.getSelectedItem().toString();
      if(newNearbyLoc1 != "No location selected."){
        try{
          //footer.setText("You have to enter at least one nearby location! try again");
        //newNearbyLoc1 = nearbyLoc1Combo.getSelectedItem().toString();
        double locDist1 = Double.parseDouble(distField1.getText());
        //double timeDist1 = Double.parseDouble(timeField1.getText());
        boolean hasHills1 = hasHillsCheck1.isSelected();
        boolean hasStairs1 = hasStairsCheck1.isSelected();
        
        Path p = new Path(locDist1, hasStairs1, hasHills1);
        footer.setText(p.toString());
        instanceMap.addEdge(l, instanceMap.findLocation(newNearbyLoc1), p);
      }catch(NullPointerException e){
        System.out.println("You must enter valid input");
      }catch(NumberFormatException n){
        System.out.println("You must enter valid input");
      }
      
      
      
      newNearbyLoc2 = nearbyLoc2Combo.getSelectedItem().toString();
      System.out.println(newNearbyLoc2.equals("No location selected."));
      if(!newNearbyLoc2.equals("No location selected.")){
        try{
          //footer.setText("You have to enter at least one nearby location! try again");
          double locDist2 = Double.parseDouble(distField2.getText());
          //double timeDist1 = Double.parseDouble(timeField1.getText());
          boolean hasHills2 = hasHillsCheck2.isSelected();
          boolean hasStairs2 = hasStairsCheck2.isSelected();
          
          Path p = new Path(locDist2, hasStairs2, hasHills2);
          instanceMap.addEdge(l, instanceMap.findLocation(newNearbyLoc2), p);
        }catch(NullPointerException e){
          System.out.println("You must enter valid input.");
        }catch(NumberFormatException n){
          System.out.println("You must enter valid input");
        }
      }
      footer.setText("New Location \"" + l.toString() + "\" has been added to the map, along with paths that lead to " + newNearbyLoc1 + " and " + newNearbyLoc2 + ".");
      }else{
         footer.setText("You have to enter at least one nearby location! try again");
      }
      locs = instanceMap.getLocations();
      keyText.setText("");
      keyText.append("Map Key: ");
      keyText.setRows(1);
      for(int i = 0; i < locs.length; i++){
        keyText.append("\n");
        keyText.append(locs[i]);
      }
    }
    
    
  }
}
