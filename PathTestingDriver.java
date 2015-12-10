public class PathTestingDriver{
  public static void main (String[] args){
  
  Path a = new Path (1, 5, false, true);
  System.out.println("\nA: " +a);
  
  Path b = new Path (5, 1, true, false);
  System.out.println("\nB: " + b);
  
  System.out.println("\nA compared to B (-4): " + a.compareTo(b));
  System.out.println("B compared to A (4): " + b.compareTo(a));
  System.out.println("A compared to 'Bunny' (MIN_VALUE): " + a.compareTo("bunny"));
  
  }
}