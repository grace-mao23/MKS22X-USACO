import java.util.*;
import java.io.*;

public class USACO {

  public static int bronze(String filename) {
    try {
      File f = new File(filename);
      Scanner in = new Scanner(f);
      String first = in.nextLine();
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
    return -1;
  }

  public static int silver(String filename) {
    return -1;
  }

}
