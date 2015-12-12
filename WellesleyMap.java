/* 
 * Team: Mary DuBard, Hannah Murphy, Alyssa Rivera
 * Writer for this Class: Mary DuBard
 * 
 * File name: WalkingEffectGUI.java
 * Date Created: 12/12/15
 * Last Updated: 12/12/15
 * 
 * Class that creates Map object for Wellesley
 */
import java.util.*;

public class WellesleyMap extends Map{
  public WellesleyMap(){
    //Create locations for Wellesley Map
    Location ksc = new Location("(1) Sports Center");
    Location resQ = new Location("(2) Res Quad");
    Location alum = new Location("(3) Alumnae Hall");
    Location lulu = new Location("(4) Lulu");
    Location acaQ = new Location("(5) Acad Quad");
    Location sciCen = new Location("(6) Science Center");
    Location twr = new Location("(7) Tower Court");
    Location lib = new Location("(8) Library");
    Location stone = new Location("(9) Stone-Davis");
    Location east = new Location("(10) East Campus Dorms");
    
    //Add locations to Wellesley Map
    addVertex(ksc);
    addVertex(resQ);
    addVertex(alum);
    addVertex(lulu);
    addVertex(acaQ);
    addVertex(sciCen);
    addVertex(twr);
    addVertex(lib);
    addVertex(stone);
    addVertex(east);
    
    //Create Paths: Path(distance, stairs, hilly, directions)
    //(1)KSC will go to ResQ and Alum
    Path ksc2resQ = new Path(.2, false, true, new LinkedList<String>(Arrays.asList("KSC", "ResQ")));
    Path ksc2alum = new Path(.05, false, false, new LinkedList<String>(Arrays.asList("KSC", "Alum")));
    //(2)ResQ will go to KSC(above), Lulu, AcaQ, and SciCen
    Path resQ2lulu = new Path(.1, false, true, new LinkedList<String>(Arrays.asList("ResQ", "Lulu")));
    Path resQ2acaQ = new Path(.2, true, true, new LinkedList<String>(Arrays.asList("ResQ", "AcaQ")));
    Path resQ2sciCen = new Path(.3, true, true, new LinkedList<String>(Arrays.asList("ResQ", "SciCen")));
    //(3)Alum will go to KSC(above), Lulu, and Twr
    Path alum2lulu = new Path(.14, false, false, new LinkedList<String>(Arrays.asList("Alum", "Lulu")));
    Path alum2twr = new Path(.2, false, true, new LinkedList<String>(Arrays.asList("Alum", "Twr")));
    //(4)Lulu will go to Alum(above), ResQ(above), AcaQ, Twr, and Lib
    Path lulu2acaQ = new Path(.2, true, false, new LinkedList<String>(Arrays.asList("Lulu", "AcaQ")));
    Path lulu2twr = new Path(.1, false, false, new LinkedList<String>(Arrays.asList("Lulu", "Twr")));
    Path lulu2lib = new Path(.2, false, true, new LinkedList<String>(Arrays.asList("Lulu", "Lib")));
    //(5)AcaQ will go to ResQ(above), Lulu(above), SciCen, Twr, Lib, Stone, and East
    Path acaQ2sciCen = new Path(.2, true, false, new LinkedList<String>(Arrays.asList("AcaQ", "SciCen")));
    Path acaQ2twr = new Path(.2, true, false, new LinkedList<String>(Arrays.asList("AcaQ", "Twr")));
    Path acaQ2lib = new Path(.2, true, true, new LinkedList<String>(Arrays.asList("AcaQ", "Lib")));
    Path acaQ2stone = new Path(.3, true, true, new LinkedList<String>(Arrays.asList("AcaQ", "Stone")));
    Path acaQ2east = new Path(.4, true, true, new LinkedList<String>(Arrays.asList("AcaQ", "East")));
    //(6)SciCen will go to ResQ(above), AcaQ(above), Lib, Stone, and East
    Path sciCen2lib = new Path(.3, false, false, new LinkedList<String>(Arrays.asList("SciCen", "Lib")));
    Path sciCen2stone = new Path(.2, false, false, new LinkedList<String>(Arrays.asList("SciCen", "Stone")));
    Path sciCen2east = new Path(.2, true, false, new LinkedList<String>(Arrays.asList("SciCen", "East")));
    //(7)Twr will go to Alum(above), Lulu(above), AcaQ(above), and Lib
    Path twr2lib = new Path(.2, false, true, new LinkedList<String>(Arrays.asList("Twr", "Lib")));
    //(8)Lib will go to Lulu(above), AcaQ(above), SciCen(above), Twr(above), Stone, and East
    Path lib2stone = new Path(.2, false, true, new LinkedList<String>(Arrays.asList("Lib", "Stone")));
    Path lib2east = new Path(.3, true, true, new LinkedList<String>(Arrays.asList("Lib", "East")));
    //(9)Stone will go to AcaQ(above), SciCen(above), Lib(above) and East
    Path stone2east = new Path(.1, true, true, new LinkedList<String>(Arrays.asList("Stone", "East")));
    //(10)East will go to AcaQ(above), SciCen(above), Lib(above), and Stone(above)
    
    //add Paths to Wellesley Map
    addEdge(ksc, resQ, ksc2resQ);
    addEdge(ksc, alum, ksc2alum);
    addEdge(resQ, lulu, resQ2lulu);
    addEdge(resQ, acaQ, resQ2acaQ);
    addEdge(resQ, sciCen, resQ2sciCen);
    addEdge(alum, lulu, alum2lulu);
    addEdge(alum, twr, alum2twr);
    addEdge(lulu, acaQ, lulu2acaQ);
    addEdge(lulu, twr, lulu2twr);
    addEdge(lulu, lib, lulu2lib);
    addEdge(acaQ, sciCen, acaQ2sciCen);
    addEdge(acaQ, twr, acaQ2twr);
    addEdge(acaQ, lib, acaQ2lib);
    addEdge(acaQ, stone, acaQ2stone);
    addEdge(acaQ, east, acaQ2east);
    addEdge(sciCen, lib, sciCen2lib);
    addEdge(sciCen, stone, sciCen2stone);
    addEdge(sciCen, east, sciCen2east);
    addEdge(twr, lib, twr2lib);
    addEdge(lib, stone, lib2stone);
    addEdge(lib, east, lib2east);
    addEdge(stone, east, stone2east);
  }
}