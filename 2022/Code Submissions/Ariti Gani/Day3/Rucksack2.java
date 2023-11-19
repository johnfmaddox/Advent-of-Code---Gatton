package AoC2022.Day3;
//I made strings for three elves
//then I went through the rucksack of the first elf
//if the same item is found in all three rucksacks then determine its priority
//and add to the total priorities
import java.util.Scanner;

public class Rucksack2 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      int totalPriorities = 0;
      while (stdin.hasNextLine()) {
         String elf1 = stdin.nextLine();
         String elf2 = stdin.nextLine();
         String elf3 = stdin.nextLine();
         for (int i = 0; i <= elf1.length() - 1; i++) {
            if (found(elf1.charAt(i), elf2) && found(elf1.charAt(i), elf3)) {
               totalPriorities += priority(elf1.charAt(i));
               break;
            }
         }
      }
      System.out.print(totalPriorities);
   }

   public static boolean found(char item, String elf) {
      for (int i = 0; i <= elf.length() - 1; i++) {
         if (elf.charAt(i) == item) {
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