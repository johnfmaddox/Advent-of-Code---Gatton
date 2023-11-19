import java.util.Scanner;

public class Day2 {
   public static void main(String[] args) {
   Scanner stdin = new Scanner(System.in);
   
   int score = 0;
   
   while (stdin.hasNextLine()) {
      String elf = stdin.next();
      String me = stdin.next();
      
      switch (me) {
         case "X":
            score += 1;
            if (elf.equals("A")) {
               score += 3;
            } else if (elf.equals("B")) {
               score +=0;
            } else if (elf.equals("C")) {
               score +=6;
            }
            break;
         case "Y":
            if (elf.equals("A")) {
               score += 6;
            } else if (elf.equals("B")) {
               score +=3;
            } else if (elf.equals("C") ){
               score +=0;
            }
            score += 2;
            break;
         case "Z":
            if (elf.equals("A") ){
               score += 0;
            } else if (elf.equals("B")) {
               score +=6;
            } else if (elf.equals("C")) {
               score +=3;
            }
            score += 3;
            break;
      }
      
      
   }
System.out.print(score);

   }
}
