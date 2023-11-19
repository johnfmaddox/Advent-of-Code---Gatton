package ChristmasCode.Day3;

import java.util.Scanner;

public class Day3 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);

      int total = 0;

      while (stdin.hasNextLine()) {
         String line = stdin.nextLine();
         boolean done = false;
         char type = ' ';
         for (int i = 0; i < line.length() / 2 ; i++) {
             type = line.charAt(i);

            for (int j = line.length() / 2 ; j < line.length(); j++) {
               char ch = line.charAt(j);
               if (ch == type) {
                  done = true;
                  break;
               }
               
            }
            if (done) {
               break;
            }
           
         }
          if (type >= 65 && type <= 90) {
                  total += type - 38;
               } else if (type >= 97 && type <= 122) {
                  total += type - 96;
               }
     
      }
    System.out.print(total);
   }
}
