import java.util.*;
import java.io.*;

public class USACO {

  public static int bronze(String filename) {
    try {
      File f = new File(filename);
      Scanner in = new Scanner(f);
      String first = in.nextLine();
      // think about condensing later
      int r = Integer.parseInt(first.substring(0,first.indexOf(" ")));
      first = first.substring(first.indexOf(" ")+1);
      int c = Integer.parseInt(first.substring(0,first.indexOf(" ")));
      first = first.substring(first.indexOf(" ")+1);
      int e = Integer.parseInt(first.substring(0,first.indexOf(" ")));
      first = first.substring(first.indexOf(" ")+1);
      int n = Integer.parseInt(first);
    //  System.out.println(r+","+c+","+e+","+n);
      int[][] board = new int[r][c];
      for (int i = 0; i < r; i++) {
        for (int x = 0; x < c; x++) {
          board[i][x] = in.nextInt();
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
    return -1;
  }

  public static int silver(String filename) {
    return -1;
  }

  public static void main(String[] args) {
    USACO u = new USACO();
    System.out.println(USACO.bronze("makelake1.in"));
  }

}
