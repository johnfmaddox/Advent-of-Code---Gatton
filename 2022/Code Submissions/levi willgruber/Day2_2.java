import java.util.Scanner;

public class Day2_2 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);

      int score = 0;

      while (stdin.hasNextLine()) {
         String elf = stdin.next();
         String me = stdin.next();

         switch (me) {
            case "X":
               if (elf.equals("A")) {
                  score += 3;
               } else if (elf.equals("B")) {
                  score += 1;
               } else if (elf.equals("C")) {
                  score += 2;
               }
               break;
            case "Y":
               if (elf.equals("A")) {
                  score += 4;
               } else if (elf.equals("B")) {
                  score += 5;
               } else if (elf.equals("C")) {
                  score += 6;
               }
               break;
            case "Z":
               if (elf.equals("A")) {
                  score += 8;
               } else if (elf.equals("B")) {
                  score += 9;
               } else if (elf.equals("C")) {
                  score += 7;
               }
         }

      }
      System.out.print(score);
   }
}
