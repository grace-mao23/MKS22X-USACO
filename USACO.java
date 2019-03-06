import java.util.*;
import java.io.*;

public class USACO {
  private static int[][] bronz;
  private static int[][] silv;
  private static int[][] sums;
  private static char[][] silve;

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
      silve = new char[n][m];
      silv = new int[n][m];
      sums = new int[n][m];
      for (int i = 0; i < n; i++) {
        String s = in.next();
        silve[i] = s.toCharArray();
      }
    //  for (char[] c : silv) {char[][]
    //    System.out.println(Arrays.toString(c));
    //  }
      int r1 = in.nextInt();
      int c1 = in.nextInt();
      int r2 = in.nextInt();
      int c2 = in.nextInt();
      return silverH(r1-1,c1-1,r2-1,c2-1,steps);
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
    return -1;
  }

  private static int silverH(int r1, int c1, int r2, int c2, int steps) {
    for (int i = 0; i < silv.length; i++) {
      for (int x = 0; x < silv[i].length; x++) {
        if (i == r1 && x == c1) { // START
          silv[i][x] = 1;
        } else if (silve[i][x] == '.') { // EMPTY SPACE
          silv[i][x] = 0;
        } else { // TREES
          silv[i][x] = -1;
        }
      }
    }
    for (int i = 0; i < steps; i++) {
      for (int x = 0; x < silv.length; x++) {
        for (int y = 0; y < silv[x].length; y++) {
          if (silv[x][y] != -1) {
            int sum = 0;
            if (valid(x-1,y)) {
              sum += silv[x-1][y];
            }
            if (valid(x,y+1)) {
              sum += silv[x][y+1];
            }
            if (valid(x+1,y)) {
              sum += silv[x+1][y];
            }
            if (valid(x,y-1)) {
              sum += silv[x][y-1];
            }
            sums[x][y] = sum;
          }
        /*  for (int[] iz : silv) {
            System.out.println(Arrays.toString(iz));
          }
          System.out.println("@@@@@@@@@@@");
        } */
        }
      }
      for (int j = 0; j < silv.length; j++) {
        for (int k = 0; k < silv[j].length; k++) {
          if (silv[j][k] != -1) {
            silv[j][k] = sums[j][k];
            sums[j][k] = 0;
          }
        }
      }
    /*  //// TESTING ////
      for (int[] iz : silv) {
        System.out.println(Arrays.toString(iz));
      }
      System.out.println("----------");
      ///////////////// */
    }
    return silv[r2][c2];
  }

  private static boolean valid(int x, int y) {
    return (x >= 0 && x < silv.length && y >= 0 && y < silv[x].length && silv[x][y] != -1);
  }

  public static void main(String[] args) {
    USACO u = new USACO();
    System.out.println(USACO.silver(args[0]));
  //  System.out.println(USACO.bronze(args[0]));
  }

}
