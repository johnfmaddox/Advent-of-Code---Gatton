

import java.util.Scanner;

public class ElfCalories {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);

      int cnt = 1;
      int topelfnum = 1;

      int elftotal = 0;
      int topelf1 = 0;
      int topelf2 = 0;
      int topelf3 = 0;
      int totalofelves = 0;

      int intelf = 0;
      String elf = " ";

      while (stdin.hasNextLine()) {
         elf = stdin.nextLine();
         if (elf.equals("")) {
            elf = stdin.nextLine();
            cnt++;
            elftotal = 0;
            cnt++;

         }

         intelf = Integer.parseInt(elf);

         elftotal += intelf;

         if (elftotal > topelf1) {
            topelf3 = topelf2;
            topelf2 = topelf1;
            topelf1 = elftotal;
            topelfnum = cnt;
            
         } else if (elftotal > topelf2) {
            topelf3 = topelf2;
            topelf2 = elftotal;
         } else if (elftotal > topelf3) {
            topelf3 = elftotal;
         }

      }
      totalofelves = topelf1 + topelf2 + topelf3;
      
      System.out.println(totalofelves);

      System.out.println(topelf1 + " " + topelfnum);
   }
}
