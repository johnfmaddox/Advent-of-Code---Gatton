package Day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day8 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner stdin = new Scanner(System.in);

      int[][] trees = new int[99][99];

      int cnt = 99 + 99 + 97 + 97;

      for (int i = 0; i < 99; i++) {
         String input = stdin.nextLine();
         for (int j = 0; j < 99; j++) {
            char ch1 = input.charAt(j);
            String ch = String.valueOf(ch1);
            trees[i][j] = Integer.parseInt(ch);
         }
      }

      for (int i = 1; i < 98; i++) {

         for (int j = 1; j < 98; j++) {
            boolean visible = false;
            //bottom
            for (int k = i + 1; k < 99; k++) {
               if (trees[i][j] > trees[k][j]) {
                  visible = true;
               } else {
                  visible = false;
                  break;
               }

            }
           
            if (!visible) {

               //right

               for (int k = j + 1; k < 99; k++) {
                  if (trees[i][j] > trees[i][k]) {
                     visible = true;
                  } else {
                     visible = false;
                     break;
                  }

               }
              
            }
            if (!visible) {

               //top
               for (int k = 0; k < i; k++) {
                  if (trees[i][j] > trees[k][j]) {
                     visible = true;

                  } else {
                     visible = false;
                     break;
                  }

               }
              
            }
            if (!visible) {

               //left
               for (int k = 0; k < j; k++) {
                  if (trees[i][j] > trees[i][k]) {
                     visible = true;
                  } else {
                     visible = false;
                     break;
                  }

               }
              
            }

            if (visible) {
           
               cnt++;
            }

         }

      }

      System.out.print(cnt);
   }

}
