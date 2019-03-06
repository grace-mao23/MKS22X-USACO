import java.util.*;
import java.io.*;

public class USACO {
  public static int[][] bronz;

  public static int bronze(String filename) {
    try {
      File f = new File(filename);
      Scanner in = new Scanner(f);
      int r = in.nextInt();
      int c = in.nextInt();
      int e = in.nextInt();
      int n = in.nextInt();
    //  System.out.println(in.nextInt());
      bronz = new int[r][c];
      for (int i = 0; i < r; i++) {
        for (int x = 0; x < c; x++) {
          bronz[i][x] = in.nextInt();
        }
      }
    //  for (int[] i : bronz) {
      //  System.out.println(Arrays.toString(i));
      //}
      in.nextLine(); // getting rid of extra line
      String[] stomps = new String[n];
      for (int i = 0; i < n; i++) {
        stomps[i] = in.nextLine();
      }
      bronzeH(stomps);
      // taking elevation + adding total depth
      int depth = 0;
      for (int i = 0; i < bronz.length; i++) {
        for (int x = 0; x < bronz[i].length; x++) {
          bronz[i][x] = e - bronz[i][x]; // subtracting from elevation
          if (bronz[i][x] < 0) { // if negative
            bronz[i][x] = 0; // just make it 0
          }
          depth += bronz[i][x];
        }
      }
      return depth * 72 * 72;
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
    return -1;
  }

  private static void bronzeH(String[] stomps) {
    for (String s : stomps) {
    //  System.out.println(s);
      int row = Integer.parseInt(s.substring(0,s.indexOf(" ")));
      s = s.substring(s.indexOf(" ")+1);
      int col = Integer.parseInt(s.substring(0,s.indexOf(" ")));
      s = s.substring(s.indexOf(" ")+1);
      int change = Integer.parseInt(s);
    //  System.out.println(row+","+col+","+change);
      stomp(row-1,col-1,change);
    }
  }

  private static void stomp(int row, int col, int change) {
    int max = bronz[row][col];
    // finding the max of the 9 slots
    for (int i = row; i < row + 3; i++) {
      for (int x = col; x < col + 3; x++) {
      //  System.out.println(i+","+x+":"+bronz[i][x]);
        if (bronz[i][x] > max) {
          max = bronz[i][x];
        }
      }
    }
  //  System.out.println(max);
    int newMax = max - change;
    for (int i = row; i < row + 3; i++) {
      for (int x = col; x < col + 3; x++) {
        if (bronz[i][x] >= newMax) { // if this slot can be stomped down
          bronz[i][x] = newMax; // stomp it down
        } // else don't change it
      }
    }
  /*  for (int[] i : bronz) {
      System.out.print(Arrays.toString(i) + "\n");
    }*/
  }

  public static int silver(String filename) {
    try {
      File f = new File(filename);
      Scanner in = new Scanner(f);
      int n = in.nextInt();
      int m = in.nextInt();
      int steps = in.nextInt();
      
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
    return -1;
  }

  public static void main(String[] args) {
    USACO u = new USACO();
  //  System.out.println(USACO.bronze(args[0]));
  }

}
