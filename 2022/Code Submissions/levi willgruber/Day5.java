package ChristmasCode.Day5;

import java.util.Scanner;

public class Day5 {
   public static void main(String[] args) {
 Scanner stdin = new Scanner(System.in);
      
      int total = 0;
      
      
      String[][] crane = new String[9][56];
         
         crane[0][0] = "B";
         crane[0][1] = "P";
         crane[0][2] = "N";
         crane[0][3] = "Q";
         crane[0][4] = "H";
         crane[0][5] = "D";
         crane[0][6] = "R";
         crane[0][7] = "T";
         crane[1][0] = "W";
         crane[1][1] = "G";
         crane[1][2] = "B";
         crane[1][3] = "J";
         crane[1][4] = "T";
         crane[1][5] = "V";
         crane[2][0] = "N";
         crane[2][1] = "R";
         crane[2][2] = "H";
         crane[2][3] = "D";
         crane[2][4] = "S";
         crane[2][5] = "V";
         crane[2][6] = "M";
         crane[2][7] = "Q";
         crane[3][0] = "P";
         crane[3][1] = "Z";
         crane[3][2] = "N";
         crane[3][3] = "M";
         crane[3][4] = "C";
         crane[4][0] = "D";
         crane[4][1] = "Z";
         crane[4][2] = "B";
         crane[5][0] = "V";
         crane[5][1] = "C";
         crane[5][2] = "W";
         crane[5][3] = "Z";
         crane[6][0] = "G";
         crane[6][1] = "Z";
         crane[6][2] = "N";
         crane[6][3] = "C";
         crane[6][4] = "V";
         crane[6][5] = "Q";
         crane[6][6] = "L";
         crane[6][7] = "S";
         crane[7][0] = "L";
         crane[7][1] = "G";
         crane[7][2] = "J";
         crane[7][3] = "M";
         crane[7][4] = "D";
         crane[7][5] = "N";
         crane[7][6] = "V";
         crane[8][0] = "T";
         crane[8][1] = "P";
         crane[8][2] = "M";
         crane[8][3] = "F";
         crane[8][4] = "Z";
         crane[8][5] = "C";
         crane[8][6] = "G";
         
         
         /**
         String[][] crane = new String[3][6];
         crane[0][0] = "Z";
         crane[0][1] = "N";
         crane[1][0] = "M";
         crane[1][1] = "C";
         crane[1][2] = "D";
         crane[2][0] = "P";
         */
         
      while (stdin.hasNextLine()) {
         
         String u = stdin.next();
         String Snum = stdin.next();
         String m = stdin.next();
         String Snum2 = stdin.next();
         String to = stdin.next();
         String Snum3 = stdin.next();
         
         int num = Integer.parseInt(Snum);
         int num1 = Integer.parseInt(Snum2) - 1;
         int num2 = Integer.parseInt(Snum3) - 1;
         
         String ch1 = "";
         int cnt = -1;
         while (ch1 != null) {
            cnt++;
            ch1 = crane[num1 ][cnt];
            
         }
         
         String ch2 = " ";
         int cnt2 = -1;
         while (ch2 != null) {
            cnt2++;
            ch2 = crane[num2][cnt2];
            
         }
         
         for (int i = 0; i < num ; i++) {
            crane[num2][cnt2 + i] = crane[num1][cnt - i - 1];
            crane[num1][cnt - i - 1] = null;
         }
      }
      for (int i = 0; i < 9; i++) {
         for (int j = 0; crane[i][j] != null && j < 56; j++) {
            System.out.print(crane[i][j]);
         }
         System.out.println();
      }
   }
}
