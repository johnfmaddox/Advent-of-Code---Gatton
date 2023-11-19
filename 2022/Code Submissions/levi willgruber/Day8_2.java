package ChristmasCode.Day8;

import java.util.Scanner;

public class Day8_2 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      int[][] trees = new int[99][99];

      for (int i = 0; i < 99; i++) {
         String input = stdin.nextLine();
         for (int j = 0; j < 99; j++) {
            char ch1 = input.charAt(j);
            String ch = String.valueOf(ch1);
            trees[i][j] = Integer.parseInt(ch);
         }
      }

      int bestScore = 0;

      for (int i = 1; i < 98; i++) {
         for (int j = 1; j < 98; j++) {

            //top
            int topCnt = 0;
            for (int k = i + 1; k < 99; k++) {
               if (trees[i][j] > trees[k][j]) {
                  topCnt++;
               } else {
                  topCnt++;
                  break;
               }

            }

            //bottom
            int botCnt = 0;
            for (int k = i - 1; k >= 0; k--) {
               if (trees[i][j] > trees[k][j]) {
                  botCnt++;
               } else {
                  botCnt++;
                  break;
               }

            }

            //right
            int riCnt = 0;
            for (int k = j + 1; k < 99; k++) {
               if (trees[i][j] > trees[i][k]) {
                  riCnt++;
               } else {
                  riCnt++;
                  break;
               }

            }

            //left
            int leCnt = 0;
            for (int k = j - 1; k >= 0; k--) {
               if (trees[i][j] > trees[i][k]) {
                  leCnt++;
               } else {
                  leCnt++;
                  break;
               }
            }
            int score = (topCnt * botCnt * leCnt * riCnt);

            if (score > bestScore) {
               bestScore = score;
            }
         }
      }
      System.out.print(bestScore);
   }

}
