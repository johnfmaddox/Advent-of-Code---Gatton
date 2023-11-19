package ChristmasCode.Day10;

import java.util.Scanner;

public class Day10_2 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      
      int cnt = 0;
      int value = 1;
   
      String[][] screen = new String[6][40];
      int line = 0;
      while (stdin.hasNextLine()) {
         
         String type = stdin.next();
         line = cnt / 40;
         
         if (type.equals("noop")) {
            if (cnt - (line * 40) == value || cnt - (line * 40)== value - 1 || cnt - (line * 40)== value + 1) {
              screen[line][cnt - ((line * 40))] = "#";
            } else {
              screen[line][cnt - ((line * 40))] = ".";
            }
            cnt++; 
            line = cnt / 40;
            
            continue;
         } else {
             if (cnt - (line * 40) == value || cnt - (line * 40)== value - 1 || cnt - (line * 40)== value + 1) {
              screen[line][cnt - ((line * 40))] = "#";
            } else {
             screen[line][cnt - ((line * 40))] = ".";
            }
            cnt++; 
            line = cnt / 40;
             if (cnt - (line * 40) == value || cnt - (line * 40)== value - 1 || cnt - (line * 40)== value + 1) {
              screen[line][cnt - ((line * 40))] = "#";
            } else {
             screen[line][cnt - ((line * 40))] = ".";
            }
            cnt++; 
            line = cnt / 40;
            type = stdin.next();
            int add = Integer.parseInt(type);
            value += add;
          
            
      }
      }
      for (int i = 0; i < 6; i++) {
         for (int j = 0; j < 40; j++) {
            System.out.print(screen[i][j]);
         }
         System.out.println();
      }

   }
}
