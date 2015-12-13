/* 
 * Team: Mary DuBard, Hannah Murphy, Alyssa Rivera
 * Writer for this Class: Mary DuBard
 * 
 * File name: AboutPanel.java
 * Date Created: 12/13/15
 * Last Updated: 12/13/15
 * 
 * Class that contains Panel elements for the About tab of the Walking Effect GUI
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class AboutPanel extends JPanel{
  JLabel header;
  
  public AboutPanel(){
    //set font to default as helvetica
    Font headerFont = new Font("Helvetica", Font.PLAIN, 20);
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
    
    header = new JLabel("Welcome to the Walking Effect!", SwingConstants.CENTER);
    header.setFont(headerFont);
    
    JPanel picPanel = new JPanel();
    try{
      BufferedImage myPicture = ImageIO.read(new File("logo.png"));
      ImageIcon pic = new ImageIcon(myPicture);
      Image img = pic.getImage();
      BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
      Graphics g = bi.createGraphics();
      g.drawImage(img, 100, 50, 400, 280, null); //locates and sizes image
      ImageIcon newIcon = new ImageIcon(bi);
      JLabel picLabel = new JLabel(newIcon);  //adds image to label
      picPanel.add(picLabel); //adds label to panel
    }
    catch(IOException io){
      System.out.println(io);
    }
    
    add(header);
    add(picPanel);
  }
}