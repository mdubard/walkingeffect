/* 
 * Team: Mary DuBard, Hannah Murphy, Alyssa Rivera
 * Writer for this Class: Hannah Murphy
 * 
 * File name: WalkingEffectGUI.java
 * Date Created: 12/8/15
 * Last Updated: 12/10/15
 * 
 * Class that creates the Walking Effect GUI
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javafoundations.*;


public class Map implements Graph<Location>{//, Iterator<Location>{
  
  private int n;   // number of vertices in the graph
  private Path[][] arcs;   // adjacency matrix of arcs
  private Location[] vertices; 
  public static final int NOT_FOUND = -1;
  private static final int DEFAULT_CAPACITY = 1;
  private final int INFINITY = 1000000;
  
  /* Constructor
   * Makes a Map object with all of the pre-loaded Locations and Paths
   */ 
  public Map(){
    vertices = new Location[DEFAULT_CAPACITY];
    arcs = new Path[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
    n = 0;
  }
  
  /*public void addEdge(Path newPath){
   int index1 = getIndex(newPath.getOrigin());
   int index2 = getIndex(newPath.getDestination());
   if (index1 != NOT_FOUND && index2 != NOT_FOUND) {
   addArc(index1, index2, newPath);
   addArc(index2, index1, newPath);
   }
   }*/
  
  /******************************************************************
    Inserts an arc from srcVertex to destVertex.
    If the vertices exist, else does not change the graph. 
    ******************************************************************/
  public void addArc(Location srcVertex, Location destVertex, Path newPath) {
    int src = getIndex(srcVertex);
    int dest = getIndex(destVertex);
    if (src != NOT_FOUND && dest != NOT_FOUND) {
      addArc(src, dest, newPath);
    }
  }
  
  /******************************************************************
    Helper. Inserts an edge between two vertices of the graph.
    @throws IllegalArgumentException if either index is invalid.
    ******************************************************************/
  protected void addArc(int srcIndex, int destIndex, Path newPath) {
    if (!indexIsValid(srcIndex) || !indexIsValid(destIndex)) {
      throw new IllegalArgumentException("One or more invalid indices: " + srcIndex + ", " + destIndex);
    }
    arcs[srcIndex][destIndex] = newPath;
  }
  
  protected int getIndex(Location loc) {
    for (int i = 0; i < n; i++) {
      if (vertices[i].equals(loc)) {
        return i;
      }
    }
    return NOT_FOUND;
  }
  /******************************************************************
    Inserts an edge between two vertices of the graph.
    If one or both vertices do not exist, ignores the addition.
    ******************************************************************/
  public void addEdge(Location vertex1, Location vertex2, Path edge) { //also add path parameters
    int index1 = getIndex(vertex1);
    int index2 = getIndex(vertex2);
    if (index1 != NOT_FOUND && index2 != NOT_FOUND) {
      addArc(index1, index2, edge);
      addArc(index2, index1, edge);
    }
  }
  
  public void addEdge(Location vertex1, Location vertex2) { //also add path parameters
    int index1 = getIndex(vertex1);
    int index2 = getIndex(vertex2);
    if (index1 != NOT_FOUND && index2 != NOT_FOUND) {
      Path edge = new Path(NOT_FOUND, false, false);
      addArc(index1, index2, edge);
      addArc(index2, index1, edge);
    }
  }
  
  /******************************************************************
    Inserts an arc from srcVertex to destVertex.
    If the vertices exist, else does not change the graph. 
    ******************************************************************/
  public void addArc(Location srcVertex, Location destVertex){//, Path edge) { //add path variables
    int src = getIndex(srcVertex);
    int dest = getIndex(destVertex);
    if (src != NOT_FOUND && dest != NOT_FOUND) {
      Path edge = new Path(NOT_FOUND, false, false);
      addArc(src, dest, edge);
    }
  }
  public boolean isUndirected(){
    throw new UnsupportedOperationException();
    
  }
  /******************************************************************
    Helper. Inserts an edge between two vertices of the graph.
    @throws IllegalArgumentException if either index is invalid.
    ******************************************************************/
  /*protected void addArc(int srcIndex, int destIndex, Path edge) { //add path variables
   if (!indexIsValid(srcIndex) || !indexIsValid(destIndex)) {
   throw new IllegalArgumentException("One or more invalid indices: " + srcIndex + ", " + destIndex);
   }
   //Path p = new Path();//add variables
   arcs[srcIndex][destIndex] = edge;
   }*/
  @SuppressWarnings("unchecked")
  private void expandCapacity() {
    Location[] largerVertices = new Location[vertices.length*2];
    Path[][] largerAdjMatrix = 
      new Path[vertices.length*2][vertices.length*2];
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        largerAdjMatrix[i][j] = arcs[i][j];
      }
      largerVertices[i] = vertices[i];
    }
    
    vertices = largerVertices;
    arcs = largerAdjMatrix;
  }
  
  
  /*protected int getIndex(Location loc) {
   for (int i = 0; i < n; i++) {
   if (vertices[i].equals(loc)) {
   return i;
   }
   }
   return NOT_FOUND;
   }*/ 
  
  public void addVertex (Location vertex) {
    if (getIndex(vertex) != NOT_FOUND) return;
    if (n == vertices.length) {
      expandCapacity();
    }
    
    vertices[n] = vertex;
    for (int i = 0; i <= n; i++) {
//   if (arcs[n][i] || arcs[i][n]) throw new RuntimeException("Corrupted AdjacencyMatrix");
      arcs[n][i] = null;
      arcs[i][n] = null;
    }      
    n++;
  }
  
  public boolean isArc(Location srcVertex, Location destVertex) {
    int src = getIndex(srcVertex);
    int dest = getIndex(destVertex);
    return src != NOT_FOUND && dest != NOT_FOUND && arcs[src][dest] != null;
  }
  
  public boolean isEmpty() {
    return n == 0;
  }
  
  /******************************************************************
    Returns the number of vertices in the graph.
    ******************************************************************/
  public int n() {
    return n;
  }
  
  /******************************************************************
    Returns the number of arcs in the graph by counting them.
    ******************************************************************/
  public int m() {
    int total = 0;
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (arcs[i][j] != null) {
          total++;
        }
      }
    }
    return total; 
  }
  private class VerticesIterator implements Iterator<Location> {
    private int cursor = 0;
    
    /** Check if the iterator has a next vertex */
    public boolean hasNext() {
      return cursor < n;
    }
    
    /** Get the next vertex. */
    public Location next() {
      if (cursor >= n) {
        throw new NoSuchElementException();
      } else {
        return vertices[cursor++];
      }
    }
    
    /** Remove is not supported in this iterator. */
    public void remove() {
      throw new UnsupportedOperationException();
    } 
  }
  
  /**
   * Create a new iterator that will iterate over the vertices of the array when asked.
   * @return the new iterator.
   */
  public Iterator<Location> iterator() {
    return new VerticesIterator();
  }
  
  /**
   * Check if the graph contains the given vertex.
   */
  public boolean containsVertex(Location vertex) {
    return getIndex(vertex) != NOT_FOUND;
  }
  
  
  /******************************************************************
    Returns true iff an arc exists between two given indices. 
    @throws IllegalArgumentException if either index is invalid.
    ******************************************************************/
  protected boolean isArc(int srcIndex, int destIndex) {
    if (!indexIsValid(srcIndex) || !indexIsValid(destIndex)) {
      throw new IllegalArgumentException("One or more invalid indices: " + srcIndex + ", " + destIndex);
    }
    return arcs[srcIndex][destIndex] != null;
  }
  
  public boolean isEdge(Location srcVertex, Location destVertex) {
    int src = getIndex(srcVertex);
    int dest = getIndex(destVertex);
    return src != NOT_FOUND && dest != NOT_FOUND && isArc(src, dest) && isArc(dest, src);
  }
  
  public void removeVertex (Location vertex) {
    int index = getIndex(vertex);
    if (index != NOT_FOUND) {
      removeVertex(index);
    }
  } 
  /******************************************************************
    Returns the vertex object that is at a certain index
    ******************************************************************/
  protected Location getVertex(int v) {
    if (!indexIsValid(v)) {
      throw new IllegalArgumentException("No such vertex index: " + v);
    }
    return vertices[v]; 
  }
  
  protected void removeVertex (int index) {
    if (!indexIsValid(index)) {
      throw new IllegalArgumentException("No such vertex index");
    }
    n--;
    
    // Remove vertex.
    for (int i = index; i < n; i++) {
      vertices[i] = vertices[i+1];
    }
    
    // Move rows up.
    for (int i = index; i < n; i++) {
      for (int j = 0; j <= n; j++) {
        arcs[i][j] = arcs[i+1][j];
      }
    }
    
    // Move columns left
    for (int i = index; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arcs[j][i] = arcs[j][i+1];
      }
    }
    
    // Erase last row and last column
    for (int a = 0; a < n; a++) {
      arcs[n][a] = null;
      arcs[a][n] = null;
    }
  }
  /******************************************************************
    Retrieve from a graph the vertices x pointing to vertex v (x->v)
    and returns them onto a linked list
    ******************************************************************/
  public LinkedList<Location> getPredecessors(Location loc) {
    LinkedList<Location> neighbors = new LinkedList<Location>();
    
    int v = getIndex(loc); 
    
    if (v == NOT_FOUND) return neighbors;
    for (int i = 0; i < n; i++) {
      if (arcs[i][v] != null) {
        neighbors.add(getVertex(i)); // if T then add i to linked list
      }
    }    
    return neighbors;    
  }
  
  /******************************************************************
    * Retrieve from a graph the vertices x following vertex v (v->x)
    and returns them onto a linked list
    ******************************************************************/
  public LinkedList<Location> getSuccessors(Location loc){
    LinkedList<Location> neighbors = new LinkedList<Location>();
    
    int v = getIndex(loc); 
    
    if (v == NOT_FOUND) return neighbors;
    for (int i = 0; i < n; i++) {
      if (arcs[v][i] != null) {
        neighbors.add(getVertex(i)); // if T then add i to linked list
      }
    }    
    return neighbors;    
  }
  
  /******************************************************************
    Returns true if the given index is valid. 
    ******************************************************************/
  protected boolean indexIsValid(int index) {
    return index < n && index >= 0;  
  } 
  public void removeEdge(Location vertex1, Location vertex2) {
    int index1 = getIndex(vertex1);
    int index2 = getIndex(vertex2);
    if (index1 != NOT_FOUND && index2 != NOT_FOUND) {
      removeArc(index1, index2);
      removeArc(index2, index1);
    }
  }
  
  
  /******************************************************************
    Removes an arc from vertex src to vertex dest,
    if the vertices exist, else does not change the graph. 
    ******************************************************************/
  public void removeArc(Location srcVertex, Location destVertex) {
    int src = getIndex(srcVertex);
    int dest = getIndex(destVertex);
    if (src != NOT_FOUND && dest != NOT_FOUND) {
      removeArc(src, dest);
    }
  }
  
  /******************************************************************
    Helper. Removes an arc from index v1 to index v2.
    @throws IllegalArgumentException if either index is invalid.
    ******************************************************************/
  protected void removeArc(int srcIndex, int destIndex) {
    if (!indexIsValid(srcIndex) || !indexIsValid(destIndex)) {
      throw new IllegalArgumentException("One or more invalid indices: " + srcIndex + ", " + destIndex);
    }
    arcs[srcIndex][destIndex] = null;
  }
  
  public Map getDirections(){
    return new Map();
  }
  
  
  public String toString() {
    if (n == 0) {
      return "Graph is empty";
    }
    
    String result = "";
    
    //result += "\nArcs\n";
    //result += "---------\n";
    result += "\ni ";
    
    for (int i = 0; i < n; i++) {
      result += "" + getVertex(i);
      if (i < 10) {
        result += " ";
      }
    }
    result += "\n";
    
    for (int i = 0; i < n; i++) {
      result += "" + getVertex(i) + " ";
      
      for (int j = 0; j < n; j++) {
        if (arcs[i][j] != null) {
          result += "1 ";
        } else {
          result += "- "; //just empty space
        }
      }
      result += "\n";
    }
    
    return result;
  }
  
  public void saveTGF(String tgf_file_name){
    throw new UnsupportedOperationException();
  }
  
  /**
   * getDirections(Location a, Location b)
   * Returns directions for shortest path between a and b
   **/ 
  public int[] getDirections(Location orig, Location dest){
    //double[] tempDistances = new double[n]; //array to store calculated shortest distance to node from origin
    PriorityQueue<Location> q = new PriorityQueue<Location>(); //a priority queue that prioritizes by distance from origin
    int[] previous = new int[n]; //stores index of node visited before each node ie if previous[3] = 1, then we traveled from node 1 to node 3
    
    for(int i = 0; i < n; i++){
      vertices[i].setDistance(INFINITY); //sets shortest distance from orig to node as infinity
    }
    
    orig.setDistance(0); //sets distance from origin to itself as 0
    
    
    for(int i = 0; i < n; i++){
      q.enqueue(vertices[i]); //adds all vertices to the queue
      previous[i] = -2; //sets previous to default of -2
    }
    
    previous[getIndex(orig)] = -1; //sets previous of origin to -1
    
    //System.out.println("Queue: " + q); //testing
    
    while(!q.isEmpty()){
      Location temp = q.dequeue();
      
      //System.out.println("Temp: " + temp.getName()); //testing
      
      if(temp != dest){ //if temp isn't destination
        LinkedList<Location> babies = getSuccessors(temp); //get successors of temp
        
        //System.out.println(temp.getName() + "'s Successors: " + babies); //testing
        
        while(babies.peek() != null){ //while there are successors of temp
          Location baby = babies.remove();
          //check if we got here from the parent; ie we're traveling backwards
          if(previous[getIndex(temp)] != getIndex(baby)){
            
            //System.out.println(temp + "'s child: " + baby); //testing
            //System.out.println(temp + "'s distance: " + temp.getDistance()); //testing
            
            double alt = temp.getDistance() + getDistanceBetween(temp, baby); //find the distance traveled to baby from origin
            
            //System.out.println("Distance from origin to " + baby + ": " + alt); //testing
            
            if(alt < baby.getDistance()){ //if this distance from origin is smaller than previous distance from origin
              baby.setDistance(alt); //set distance to new distance
              previous[getIndex(baby)] = getIndex(temp); //say which node we traveled from
              
              //System.out.println("baby index: " + getIndex(baby)); //testing
              //System.out.println("temp index: " + getIndex(temp)); //testing
            }
            if(!q.isEmpty())
              q.reorder(); //reorder queue after new distance changes
          }
        }
      }
    }
    return previous; //return array of previous indexes
  }
  
  private double getDistanceBetween(Location a, Location b){
    //if b is a successor of a
    LinkedList successors = getSuccessors(a);
    if(!successors.contains(b))
      return NOT_FOUND;
    
    return arcs[getIndex(a)][getIndex(b)].getDistance();
  }
  
  public String directionsString(Location orig, Location dest){
    int[] directions = getDirections(orig, dest);
    LinkedStack<String> names = new LinkedStack<String>();
    int temp = getIndex(dest);
    while(temp!= -1){
      names.push(getVertex(temp).getName());
      temp = directions[temp];
    }
    String result = "";
    while(!names.isEmpty()){
      result+= names.pop() + "\t";
    }
    return result;
    
  }
  
  public String[] getLocations(){
    String[] locs = new String[n];
    for(int i = 0; i < n; i++){
      locs[i] = vertices[i].getName();
    }
    return locs;
  }
  
  public Location[] getAllVertices(){
    return vertices;
  }
  
  public Location findLocation(String loc){
    for(int i = 0; i < n; i++){
      if(vertices[i].getName().equalsIgnoreCase(loc))
        return vertices[i];
    }
    return null;
  }
  
  public static void main(String[] args){
    Map m = new Map();
    /*
     Location scienceCenter = new Location("Science Center");
     //vertices[0] = scienceCenter;
     m.addVertex(scienceCenter);
     Location resQuad = new Location("Residential Quad");
     //vertices[1] = resQuad;
     m.addVertex(resQuad);
     Location lulu = new Location("Lulu Capus Center");
     //vertices[2] = lulu;
     m.addVertex(lulu);
     Path resQuad2lulu = new Path(3, 4, true, true);
     m.addEdge(resQuad, lulu, resQuad2lulu);
     
     Path scienceCenter2resQuad = new Path(3, 4, true, true);
     m.addEdge(scienceCenter, resQuad, scienceCenter2resQuad);
     System.out.println(m);
     */
    
    Location a = new Location("A");
    Location b = new Location("B");
    Location c = new Location("C");
    Location d = new Location("D");
    Location e = new Location("E");
    
    m.addVertex(a);
    m.addVertex(b);
    m.addVertex(c);
    m.addVertex(d);
    m.addVertex(e); 
    
    m.addEdge(a, b, new Path(3, true, true));
    m.addEdge(a, c, new Path(1, true, true));
    m.addEdge(b, d, new Path(1, true, true));
    m.addEdge(c, e, new Path(5, true, true));
    m.addEdge(d, e, new Path(1, true, true));
    
    int[] test = m.getDirections(a, e);
    for(int i = 0; i < test.length; i++){
      System.out.print(test[i] + "|");
    }
    
    System.out.println("\n" + m.directionsString(a, e));
    System.out.println("\n" + m.directionsString(a, b));
  }
  
}
