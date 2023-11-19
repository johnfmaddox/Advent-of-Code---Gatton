package AoC2022.Day1;
//I used the space in between each input to get the calories that each Elf holds
//then I converted the String cals input to an integer and added it to the inventory
//if a certain elf's inventory is greater than the current highest number of cals
//then make most cals equal to the elf's inventory
import java.util.Scanner;

public class CalorieCounting1 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      int mostCals = 0;
      int inventory = 0;
      while (stdin.hasNextLine()) {
         String cals = stdin.nextLine();
         if (cals.equals("")) {
            if (inventory > mostCals) {
               mostCals = inventory;
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
      System.out.print(mostCals);
   }
}