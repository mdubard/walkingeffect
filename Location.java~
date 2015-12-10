/**
 * Represents a location on Wellesley's campus, including the following information:
 * name, description, image of the place
 * Author: Alyssa Rivera
 * Created: December 8th, 2015
 * Last Modified: December 8th, 2015
 * Known Bugs: none
 */ 

import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Location {

  private String name, about;
  private Image picture;
  
  /**
   * Creates a Location object with a name, about, and picture
   * Imports the picture from the given fileName
   * 
   * @param n         name of the Location
   * @param a         about information of the Location
   * @param fileName  location of the picture of the Location
   */ 
  public Location(String n, String a, String fileName){
    name = n;
    about = a;
    try{
      picture = ImageIO.read(new File (fileName));
    }
    catch(IOException e){
      //System.out.println("Picture could not be imported in constructor");
      //throw e;
    }
  }
  
    /**
   * Creates a Location object with a name, an empty about, and a Wellesley logo as the image
   * 
   * @param n   name of the Location
   */
  public Location (String n){
    name = n;
    about = " ";
    try{
    picture = ImageIO.read( new File ("wellesleylogo.png"));
    }
    catch(IOException e){
    System.out.println ("picture import failed");
    }
  }  
  
  /**
   * Returns a String representation of the Location, including the name, about, and picture
   * 
   * @return   the String representation
   */ 
  public String toString(){
    return name + "\n" + about + "\n" + picture;
  }
  
  
  /****Getter Methods****/
  public String getName(){
  return name;
  }
  
  public String getAbout(){
  return about;
  }
  
  public Image getPic(){
  return picture;
  }
  
  /****Setter Methods****/
  public void setName(String n){
  name = n;
  }
  
  public void setAbout(String a){
  about = a;
  }
  
  public void setPicture(String fileName){
          try{
      picture = ImageIO.read(new File (fileName));
    }
    catch(IOException e){
      System.out.println("Picture could not be imported in setPicture()");
      //throw e;
    }
  }
  
}