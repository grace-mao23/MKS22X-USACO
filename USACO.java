import java.util.*;
import java.io.*;

public class USACO {

  public static int bronze(String filename) {
    try {
      File f = new File(filename);
      Scanner in = new Scanner(f);
      String first = in.nextLine();
      int r = Integer.parseInt(first.substring(0,first.indexOf(" ")));
      first = first.substring(first.indexOf(" ")+1);
      int c = Integer.parseInt(first.substring(0,first.indexOf(" ")));
      
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
    return -1;
  }

  public static int silver(String filename) {
    return -1;
  }

}