import java.util.*;
import java.io.*;

public class USACO {
  private static int[][] bronz;

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
      bronz = new int[r][c];
      for (int i = 0; i < r; i++) {
        for (int x = 0; x < c; x++) {
          bronz[i][x] = in.nextInt();
        }
      }
      in.nextLine(); // getting rid of extra line
      String[] stomps = new String[n];
      for (int i = 0; i < n; i++) {
        stomps[i] = in.nextLine();
      }
      bronzeH(stomps);
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
    return -1;
  }

  private static void bronzeH(String[] stomps) {
    for (String s : stomps) {
      int row = Integer.parseInt(s.substring(0,s.indexOf(" ")));
      s = s.substring(s.indexOf(" ")+1);
      int col = Integer.parseInt(s.substring(0,s.indexOf(" ")));
      s = s.substring(s.indexOf(" ")+1);
      int change = Integer.parseInt(s);
      stomp(row,col,change);
    }
  }

  private static void stomp(int row, int col, int change) {
    int max = bronz[row][col];
    // finding the max of the 9 slots
    for (int i = row; i < row + 3; i++) {
      for (int x = col; x < col + 3; x++) {
        if (bronz[row][col] > max) {
          max = bronz[row][col];
        }
      }
    }
    int newMax = max - change;
    for (int i = row; i < row + 3; i++) {
      for (int x = col; x < col + 3; x++) {
        if (bronz[row][col] >= newMax) { // if this slot can be stomped down
          bronz[row][col] = newMax; // stomp it down
        } // else don't change it
      }
    }
  }

  public static int silver(String filename) {
    return -1;
  }

  public static void main(String[] args) {
    USACO u = new USACO();
    System.out.println(USACO.bronze("makelake1.in"));
  }

}
