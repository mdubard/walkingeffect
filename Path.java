/* Class to represent a Path object
 * Created: December 7th, 2015
 * Last Modified: December 7th, 2015
 * Known Bugs: none
 */

public class Path implements Comparable<Path> {
  //double time; //time in minutes needed to walk the path at normal rate 
  double distance; //distance of path in feet (???)
  boolean hasStairs; boolean hasHills;
  
  
  /**
   *   Constructs a Path object given a time, distance, info on stairs, and info on hills
   * 
   * @param t       the time it takes to walk this path
   * @param dist    the distance of the path in feet
   * @param stairs  true if the path contains stairs
   * @param hill    true if the path is hilly
   */ 
  public Path (double dist, boolean stairs, boolean hill){
    //time = t;
    distance = dist;
    hasStairs = stairs;
    hasHills = hill;
  }
  
  /**
   * Constructs a Path object with time and distance of 0, no stairs, and no hills
   * Pretty much just a helper method for compareTo()
   * 
   */ 
  private Path(){
    //time = 0;
    distance = 0;
    hasStairs = false;
    hasHills = false;
  }
  
  /**
   * Compares this path to that path. Returns a floored int of difference in time between the two paths.
   * Negative when this is a shorter walk than that. Zero when the times are equal. Positive when this is longer.
   * Takes Object type as parameter to satisfy Comparable's abstract method, returns Integer.MIN_VALUE if param not Path
   * 
   * @param that the Path to compare to this path
   * @return     the difference in walking times of the paths
   */ 
  public int compareTo(Path that){
    return (int) (this.getDistance() - that.getDistance());
  }
   
  
  /**
   * Returns a String representation of this Path, including all the information
   * 
   * @return
   */ 
  public String toString() {
    return "Minutes: " + this.calculateTime() + "\tDistance: " + this.getDistance() + 
      "\nAccessiblity: " +(this.hasStairs()?"Has Stairs" : "No Stairs") + "\t" +
      (this.hasHills()? "Has Hills" : "No Hills");
  }
  

  
  /**
   * Returns the time it takes to walk this path, calculated by distance
   * average walking speed: 3.1 miles per hour  = 273 feet per minute
   * 
   * @return    the time it takes to walk this path
   */ 
  public double calculateTime(){
    return distance/273;
  }
  
    
  /****Getter Methods****/
  
    /**
   * Returns the distance of this path
   * 
   * @return    the distance of this path
   */ 
  
  public double getDistance(){
  return distance;
  }
  
    /**
   * Returns whether this path has stairs
   * 
   * @return    true if this path has stairs, false otherwise
   */ 
  
  public boolean hasStairs(){
  return hasStairs;
  }
  
    /**
   * Returns whether this path has hills
   * 
   * @return    true if this path has hills, false otherwise
   */ 
  
  public boolean hasHills(){
  return hasHills;
  }
  
  /****Setter Methods****/
  
   /**
   * Sets the distance of this path to the inputted double
   * 
   * @param  d    the distance of this path
   */ 
  public void setDistance(int d){
    distance = d;
  }
  
   /**
   * Sets the hasStairs field of this path to the inputted boolean
   * 
   * @param  s    the user input of stair information
   */ 
  public void setHasStairs(boolean s){
    hasStairs = s;
  }
  
   /**
   * Sets the hasHills field of this path to the inputted boolean
   * 
   * @param  h    the user input of hill information
   */ 
  public void setHasHillss(boolean h){
    hasHills = h;
  }
  
  
               



}