package AoC2022.Day2;
//I made variables for whatever yourMove and theirMove is in a certain round
//then depending on what you picked and the round's outcome you add points to your score
import java.util.Scanner;

public class RockPaperScissors1 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      int score = 0;
      while (stdin.hasNextLine()) {
         String theirMove = stdin.next();
         String yourMove = stdin.next();
         if (yourMove.equals("X")) {
            score += 1;
            if (theirMove.equals("A")) {
               score += 3;
            } else if (theirMove.equals("C")) {
               score += 6;
            }
         } else if (yourMove.equals("Y")) {
            score += 2;
            if (theirMove.equals("A")) {
               score += 6;
            } else if (theirMove.equals("B")) {
               score += 3;
            }
         } else {
            score += 3;
            if (theirMove.equals("B")) {
               score += 6;
            } else if (theirMove.equals("C")) {
               score += 3;
            }
         }
      }
      System.out.print(score);
   }
}