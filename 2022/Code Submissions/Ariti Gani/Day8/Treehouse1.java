package AoC2022.Day8;

//I made a String variable called treeRow
//then I made String arrays called grid
//I used a method to determine if a tree in the grid was taller than all its neighbors
//if it was I added it to visibleTrees
import java.util.Scanner;

public class Treehouse1 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      String treeRow = stdin.nextLine();
      int edgeDimensions = treeRow.length();
      String[] grid = new String[edgeDimensions];
      int visibleTrees = edgeDimensions * 2 + (edgeDimensions - 2) * 2;
      for (int i = 0; i <= grid.length - 2; i++) {
         grid[i] = treeRow;
         treeRow = stdin.nextLine();
      }
      grid[grid.length - 1] = treeRow;
      for (int i = 1; i <= grid.length - 2; i++) {
         visibleTrees += numOfVisible(grid[i], grid, i);
      }
      System.out.print(visibleTrees);
      stdin.close();
   }

   public static int numOfVisible(String row, String[] grid, int j) {
      int visibleInRow = 0;
      for (int i = 1; i <= row.length() - 2; i++) {
         if (tallerThanTreesToTheLeft(row.charAt(i), i, row)) {
            visibleInRow++;
            continue;
         }
         if (tallerThanTreesToTheRight(row.charAt(i), i, row)) {
            visibleInRow++;
            continue;
         }
         if (tallerThanTreesToTheTop(row.charAt(i), i, j, grid)) {
            visibleInRow++;
            continue;
         }
         if (tallerThanTreesToTheBottom(row.charAt(i), i, j, grid)) {
            visibleInRow++;
            continue;
         }
      }
      return visibleInRow;
   }

   public static boolean tallerThanTreesToTheLeft(char treeHeight, int treeIndex, String row) {
      for (int i = treeIndex - 1; i >= 0; i--) {
         if (treeHeight - '0' <= row.charAt(i) - '0') {
            return false;
         }
      }
      return true;
   }

   public static boolean tallerThanTreesToTheRight(char treeHeight, int treeIndex, String row) {
      for (int i = treeIndex + 1; i <= row.length() - 1; i++) {
         if (treeHeight - '0' <= row.charAt(i) - '0') {
            return false;
         }
      }
      return true;
   }

   public static boolean tallerThanTreesToTheTop(char treeHeight, int treeIndex, int gridIndex, String[] grid) {
      for (int i = gridIndex - 1; i >= 0; i--) {
         if (treeHeight - '0' <= grid[i].charAt(treeIndex) - '0') {
            return false;
         }
      }
      return true;
   }

   public static boolean tallerThanTreesToTheBottom(char treeHeight, int treeIndex, int gridIndex, String[] grid) {
      for (int i = gridIndex + 1; i <= grid.length - 1; i++) {
         if (treeHeight - '0' <= grid[i].charAt(treeIndex) - '0') {
            return false;
         }
      }
      return true;
   }
}