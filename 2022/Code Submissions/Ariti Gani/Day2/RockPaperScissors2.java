package AoC2022.Day2;
//I made variables for whatever yourMove and theirMove is in a certain round
//then depending on what you picked and the round's outcome you add points to your score
import java.util.Scanner;

public class RockPaperScissors2 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      int score = 0;
      while (stdin.hasNextLine()) {
         String theirMove = stdin.next();
         String yourMove = stdin.next();
         if (yourMove.equals("X")) {
            if (theirMove.equals("A")) {
               score += 3;
            } else if (theirMove.equals("C")) {
               score += 2;
            } else {
               score += 1;
            }
         } else if (yourMove.equals("Y")) {
            score += 3;
            if (theirMove.equals("A")) {
               score += 1;
            } else if (theirMove.equals("B")) {
               score += 2;
            } else {
               score += 3;
            }
         } else {
            score += 6;
            if (theirMove.equals("B")) {
               score += 3;
            } else if (theirMove.equals("C")) {
               score += 1;
            } else {
               score += 2;
            }
         }
      }
      System.out.print(score);
   }
}