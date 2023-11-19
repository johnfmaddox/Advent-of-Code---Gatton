package ChristmasCode.Day3;

import java.util.Scanner;

public class Day3_2 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      
      int total = 0;
      while (stdin.hasNextLine()) {
      char type = ' ';
      
    
         String elf1 = stdin.next();
         String elf2 = stdin.next();
         String elf3 = stdin.next();
         boolean done = false;
         for (int j = 0; j < elf1.length() && !done; j++) {
            type = elf1.charAt(j);
            
            for (int k = 0; k < elf2.length() && !done; k++) {
               char type2 = elf2.charAt(k);
               
               if (type == type2) {
                  for (int y = 0; y < elf3.length() ; y++) {
                     char type3 = elf3.charAt(y);
                     if (type3 == type2) {
                        done = true;
                        break;
                     
                  }
               }
            }
            
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
