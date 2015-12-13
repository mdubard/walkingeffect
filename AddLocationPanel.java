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
  private JTextField locN, distField1, distField2, timeField1, timeField2;
  private JCheckBox hasHillsCheck1, hasStairsCheck1, hasHillsCheck2, hasStairsCheck2;
  
  public AddLocationPanel(){
    setLayout (new BorderLayout());
    
    //set font to default as helvetica
    Font headerFont = new Font("Helvetica", Font.PLAIN, 18);
    Font customFont = new Font("Helvetica", Font.PLAIN, 15);
    Font keyFont = new Font("Helvetica", Font.PLAIN, 13);
    
    try {
      //create the font to use. Specify the size!
      headerFont = Font.createFont(Font.TRUETYPE_FONT, new File("fontBold.ttf")).deriveFont(25f);
      customFont = Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf")).deriveFont(20f);
      keyFont = Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf")).deriveFont(15f);
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      //register the font
      ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf")));
    } catch (IOException e) {
      e.printStackTrace();
    }
    catch(FontFormatException e)
    {
      e.printStackTrace();
    }
    
    header = new JLabel("\nFill in the fields below to add a custom location to your map!", SwingConstants.CENTER);
    header.setFont(headerFont);
    
    String[] locs = {"(1) Sports Center", "(2) Res Quad", "(3) Alumnae Hall", "(4) Lulu", "(5) Acad Quad", "(6) Science Center", "(7) Tower Court", "(8) Library", "(9) Stone Davis", "(10) East Dorms"}; 
    //^^will be taken from Map object
    
    //initialize combo boxes, using String array ratings for values
    nearbyLoc1Combo = new JComboBox(locs);
    nearbyLoc1Combo.setFont(keyFont);
    nearbyLoc2Combo = new JComboBox(locs);
    nearbyLoc2Combo.setFont(keyFont);
    
    enterName = new JLabel("Name of New Location");
    enterName.setFont(customFont);
    JPanel locName = new JPanel();
    locN = new JTextField(20);
    locName.add(locN);
    
    //initializes labels for combo boxes
    nearbyLoc1 = new JLabel("Nearby Location 1: ");
    nearbyLoc1.setFont(customFont);
    nearbyLoc2 = new JLabel("Nearby Location 2: ");
    nearbyLoc2.setFont(customFont);
    
    JPanel distOne = new JPanel();
    dist1 = new JLabel("Distance to Location 1: ");
    dist1.setFont(customFont);
    distField1 = new JTextField(10);
    distOne.add(distField1);
    //JPanel timeOne = new JPanel();
    //time1 = new JLabel("Time to Location 1: ");
    //timeField1 = new JTextField(10);
    //timeOne.add(timeField1);
    hasHillsCheck1 = new JCheckBox("The Path to Location 1 has Hills");
    hasHillsCheck1.setFont(keyFont);
    hasStairsCheck1 = new JCheckBox("The Path to Location 1 has Stairs");
    hasStairsCheck1.setFont(keyFont);
    
    JPanel distTwo = new JPanel();
    dist2 = new JLabel("Distance to Location 2: ");
    dist2.setFont(customFont);
    distField2 = new JTextField(20);
    distTwo.add(distField2);
    //time2 = new JLabel("Time to Location 2: ");
    //timeField2 = new JTextField(20);
    hasHillsCheck2 = new JCheckBox("The Path to Location 2 has Hills");
    hasHillsCheck2.setFont(keyFont);
    hasStairsCheck2 = new JCheckBox("The Path to Location 2 has Stairs");
    hasStairsCheck2.setFont(keyFont);
    
    //creates submit button
    add = new JButton("Add Location");
    add.setPreferredSize(new Dimension(40, 40));
    //add.addActionListener(new AddButtonListener(map));
    add.setFont(customFont);
    
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
    navi.add(distOne);
    //navi.add(time1);
    //navi.add(timeField1);
    navi.add(hasHillsCheck1);
    navi.add(hasStairsCheck1);
    
    navi.add(Box.createRigidArea(new Dimension(0, 10)));
    navi.add(nearbyLoc2);
    navi.add(nearbyLoc2Combo);
    //navi.add(Box.createRigidArea(new Dimension(0, 100)));
    navi.add(dist2);
    navi.add(distTwo);
    //navi.add(time2);
    //navi.add(timeField2);
    navi.add(hasHillsCheck2);
    navi.add(hasStairsCheck2);
    navi.add(add);
    //navi.add(add);
    //navi.add(Box.createRigidArea (new Dimension (0, 100)));
    
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
    
    //map.add(availLocs);
    mapPic.add(jp);
    
    //Initializes footer
    footer = new JLabel("<Directions here>", SwingConstants.CENTER);
    footer.setFont(customFont);
    
    //adds elements to frame
    add(header, BorderLayout.NORTH);
    add(navi, BorderLayout.WEST);
    add(mapPic, BorderLayout.EAST);
    add(footer, BorderLayout.SOUTH);
  }
  
  private class AddButtonListener implements ActionListener{
    
    private Map map;
    
    public void AddButtonListener(Map map){
      //save combo box values as a string, if no value was chosen, the default value is 1
      String newLocName = locN.getText();
      Location l = new Location(newLocName);
      map.addVertex(l);
      try{
        String newNearbyLoc1 = nearbyLoc1Combo.getSelectedItem().toString();
        double locDist1 = Double.parseDouble(distField1.getText());
        //double timeDist1 = Double.parseDouble(timeField1.getText());
        boolean hasHills1 = hasHillsCheck1.isSelected();
        boolean hasStairs1 = hasStairsCheck1.isSelected();
        
        Path p = new Path(locDist1, hasStairs1, hasHills1);
        map.addEdge(l, map.findLocation(newNearbyLoc1), p);
      }catch(NullPointerException e){
        System.out.println("You must enter at least 1 Nearby Location");
      }
      
      try{
        String newNearbyLoc2 = nearbyLoc2Combo.getSelectedItem().toString();
        double locDist2 = Double.parseDouble(distField2.getText());
        //double timeDist1 = Double.parseDouble(timeField1.getText());
        boolean hasHills2 = hasHillsCheck2.isSelected();
        boolean hasStairs2 = hasStairsCheck2.isSelected();
        
        Path p = new Path(locDist2, hasStairs2, hasHills2);
        map.addEdge(l, map.findLocation(newNearbyLoc2), p);
      }catch(NullPointerException e){
        //System.out.println("You must enter at least 1 Nearby Location");
      }
      footer.setText("Directions from ");
      //add getDirections(origString, destString) to footer
    }
    
    public void actionPerformed(ActionEvent event){
    }
  }
}
