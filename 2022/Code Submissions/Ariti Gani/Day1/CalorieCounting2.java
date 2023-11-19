package AoC2022.Day1;
//I calculated the inventory for each individual elf
//then i went through the current mostCals, secondMostCals, and thirdMostCals
//and the first one that the inventory is larger than shifts all the other variables

import java.util.Scanner;

public class CalorieCounting2 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      int mostCals = 0;
      int secondMostCals = 0;
      int thirdMostCals = 0;
      int inventory = 0;
      while (stdin.hasNextLine()) {
         String cals = stdin.nextLine();
         if (cals.equals("")) {
            if (inventory > mostCals) {
               thirdMostCals = secondMostCals;
               secondMostCals = mostCals;
               mostCals = inventory;
            } else if (inventory > secondMostCals) {
               thirdMostCals = secondMostCals;
               secondMostCals = inventory;
            } else if (inventory > thirdMostCals) {
               thirdMostCals = inventory;
            }
            inventory = 0;
            continue;
         } else {
            int digit = 1;
            for (int i = cals.length() - 1; i >= 0; i--) {
               inventory += ((cals.charAt(i) - '0') * digit);
               digit *= 10;
            }
         }
      }
      if (inventory > mostCals) {
         thirdMostCals = secondMostCals;
         secondMostCals = mostCals;
         mostCals = inventory;
      } else if (inventory > secondMostCals) {
         thirdMostCals = secondMostCals;
         secondMostCals = inventory;
      } else if (inventory > thirdMostCals) {
         thirdMostCals = inventory;
      }
      int total = mostCals + secondMostCals + thirdMostCals;
      System.out.print(total);
   }
}