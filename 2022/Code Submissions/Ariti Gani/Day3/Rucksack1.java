package AoC2022.Day3;
//I got each String and went through the first half of the characters
//then I made a method to see if a certain character appeared in both String halves
//if there are duplicate items in the rucksack, then determine the item's priority
//and add to the total priorities
import java.util.Scanner;

public class Rucksack1 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      int totalPriorities = 0;
      while (stdin.hasNextLine()) {
         String rucksack = stdin.nextLine();
         for (int i = 0; i <= (rucksack.length() / 2) - 1; i++) {
            if (found(rucksack.charAt(i), rucksack)) {
               totalPriorities += priority(rucksack.charAt(i));
               break;
            }
         }
      }
      System.out.print(totalPriorities);
   }

   public static boolean found(char item, String rucksack) {
      for (int j = (rucksack.length() / 2); j <= rucksack.length() - 1; j++) {
         if (rucksack.charAt(j) == item) {
            return true;
         }

      }
      return false;
   }

   public static int priority(char item) {
      String alphabet = "abcdefghijklmnopqrstuvwxyz";
      for (int i = 0; i <= alphabet.length() - 1; i++) {
         if (alphabet.charAt(i) == item) {
            return (i + 1);
         }
      }
      for (int i = 0; i <= alphabet.length() - 1; i++) {
         if (((alphabet.toUpperCase()).charAt(i)) == item) {
            return (i + 27);
         }
      }
      return 0;
   }
}