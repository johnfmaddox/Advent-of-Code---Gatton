package AoC2022.Day8;
//I made a String variable called treeRow
//then I made String arrays called grid
//I used a method to determine a tree's scenic score based on its height
//then I made a variable to update the highest scenic score for a tree in the grid
import java.util.Scanner;

public class Treehouse2 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      String treeRow = stdin.nextLine();
      int edgeDimensions = treeRow.length();
      String[] grid = new String[edgeDimensions];
      int highestScenicScore = 0;
      for (int i = 0; i <= grid.length - 2; i++) {
         grid[i] = treeRow;
         treeRow = stdin.nextLine();
      }
      grid[grid.length - 1] = treeRow;
      for (int i = 1; i <= grid.length - 2; i++) {
         for (int j = 1; j <= grid[i].length() - 2; j++) {
            int scenicScore = getScenicScore(grid[i].charAt(j), grid[i], grid, i, j);
            if (scenicScore > highestScenicScore) {
               highestScenicScore = scenicScore;
            }
         }
      }
      System.out.print(highestScenicScore);
      stdin.close();
   }

   public static int getScenicScore(char treeHeight, String row, String[] grid, int rowIndex, int treeIndex) {
      return treesSeenToLeft(treeHeight, treeIndex, row) * treesSeenToRight(treeHeight, treeIndex, row)
            * treesSeenToTop(treeHeight, treeIndex, rowIndex, grid)
            * treesSeenToBottom(treeHeight, treeIndex, rowIndex, grid);
   }

   public static int treesSeenToLeft(char treeHeight, int treeIndex, String row) {
      int treesSeen = 0;
      for (int i = treeIndex - 1; i >= 0; i--) {
         treesSeen++;
         if (treeHeight - '0' <= row.charAt(i) - '0' || i == 0) {
            break;
         }
      }
      return treesSeen;
   }

   public static int treesSeenToRight(char treeHeight, int treeIndex, String row) {
      int treesSeen = 0;
      for (int i = treeIndex + 1; i <= row.length() - 1; i++) {
         treesSeen++;
         if (treeHeight - '0' <= row.charAt(i) - '0' || i == row.length() - 1) {
            break;
         }
      }
      return treesSeen;
   }

   public static int treesSeenToTop(char treeHeight, int treeIndex, int rowIndex, String[] grid) {
      int treesSeen = 0;
      for (int i = rowIndex - 1; i >= 0; i--) {
         treesSeen++;
         if (treeHeight - '0' <= grid[i].charAt(treeIndex) - '0' || i == 0) {
            break;
         }
      }
      return treesSeen;
   }

   public static int treesSeenToBottom(char treeHeight, int treeIndex, int rowIndex, String[] grid) {
      int treesSeen = 0;
      for (int i = rowIndex + 1; i <= grid.length - 1; i++) {
         treesSeen++;
         if (treeHeight - '0' <= grid[i].charAt(treeIndex) - '0' || i == grid.length - 1) {
            break;
         }
      }
      return treesSeen;
   }
}