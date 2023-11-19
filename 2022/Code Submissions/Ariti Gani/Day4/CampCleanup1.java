package AoC2022.Day4;

//I made and initialized four strings
//then I converted them to integers to get the ranges
//if one integer range fully contains the other then add 1 to fullyContains
import java.util.Scanner;

public class CampCleanup1 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      int fullyContains = 0;
      while (stdin.hasNextLine()) {
         String pairs = stdin.nextLine();
         String firstElf1 = "";
         String lastElf1 = "";
         String firstElf2 = "";
         String lastElf2 = "";
         int i = 0;
         while (pairs.charAt(i) != '-') {
            firstElf1 += pairs.charAt(i);
            i++;
         }
         int j = i + 1;
         while (pairs.charAt(j) != ',') {
            lastElf1 += pairs.charAt(j);
            j++;
         }
         int k = j + 1;
         while (pairs.charAt(k) != '-') {
            firstElf2 += pairs.charAt(k);
            k++;
         }
         int l = k + 1;
         while (l <= pairs.length() - 1) {
            lastElf2 += pairs.charAt(l);
            l++;
         }
         int fromElf1 = convertString(firstElf1);
         int toElf1 = convertString(lastElf1);
         int fromElf2 = convertString(firstElf2);
         int toElf2 = convertString(lastElf2);
         if (fromElf1 <= fromElf2 && toElf1 >= toElf2) {
            fullyContains++;
         } else if (fromElf2 <= fromElf1 && toElf2 >= toElf1) {
            fullyContains++;
         }
      }
      System.out.print(fullyContains);
   }

   public static int convertString(String elf) {
      int digit = 1;
      int convertedString = 0;
      for (int i = elf.length() - 1; i >= 0; i--) {
         convertedString += ((elf.charAt(i) - '0') * digit);
         digit *= 10;
      }
      return convertedString;
   }
}