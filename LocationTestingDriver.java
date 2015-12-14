/**
 * Team: Mary DuBard, Hannah Murphy, Alyssa Rivera
 * Author for this class: Alyssa Rivera
 * File Name: LocationTestingDriver.java
 * Created: December 8th, 2015
 * Updated: December 8th, 2015
 * Known bugs: None
 * 
 * Tests the Location class and methods
 * 
 */ 

public class LocationTestingDriver{
  public static void main (String[] args){
  
    Location a = new Location("Science Center");
    System.out.println (a);
    
    Location b = new Location ("Tower Court", "I am a res hall with the most students on campus and a bangin' Great Hall"
                              , "towerCourt.jpg");
    System.out.println(b);
    
    System.out.println("A's about ( ):\t" + a.getAbout());
    a.setPicture("sciCent.jpg");
    a.setAbout("I hold science classrooms, the Science Library, confusing stairs, the Leaky Beaker, and taxidermied animals.");
    System.out.println (a);
    
  }
 
}