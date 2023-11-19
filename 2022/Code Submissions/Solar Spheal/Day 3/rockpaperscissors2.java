

import java.util.Scanner;

public class rockpaperscissors2 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      
      int score = 0;
      
      while(stdin.hasNextLine()) {
         String game = stdin.nextLine();
         
         if(determine(game).equals("Rock")) {
            score += 1;
         } else if (determine(game).equals("Paper")) {
            score += 2;
         } else {
            score += 3;
         }
         
         if (game.charAt(2) == 'Y') {
            score += 3;
         } else if (game.charAt(2) == 'Z') {
            score += 6;
         }
      }
      System.out.println(score);
   }
   
   public static String determine(String game) {
      if ((game.charAt(0) == 'A' && game.charAt(2) == 'Y') || (game.charAt(0) == 'B' && game.charAt(2) == 'X') ||
      (game.charAt(0) == 'C' && game.charAt(2) == 'Z')) {
         return "Rock";
      } else if ((game.charAt(0) == 'A' && game.charAt(2) == 'Z') || (game.charAt(0) == 'B' && game.charAt(2) == 'Y') ||
      (game.charAt(0) == 'C' && game.charAt(2) == 'X')) {
         return "Paper";
      } else {
         return "Scissors";
      }
   }
   
}
