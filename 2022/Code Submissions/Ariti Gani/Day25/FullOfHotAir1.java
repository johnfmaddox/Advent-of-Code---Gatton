package AoC2022.Day25;
//I made variables for the decimal sum
//each time I converted the SNAFU number to a normal number and then added the values up
//then I converted the decimal sum back to a SNAFU number
import java.util.Scanner;

public class FullOfHotAir1 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      long decimalSum = 0;
      while (stdin.hasNextLine()) {
         String sNAFUNum = stdin.nextLine();
         for (int i = 0; i <= sNAFUNum.length() - 1; i++) {
            if (sNAFUNum.charAt(i) == '-') {
               decimalSum += -1 * Math.pow(5, sNAFUNum.length() - 1 - i);
            } else if (sNAFUNum.charAt(i) == '=') {
               decimalSum += -2 * Math.pow(5, sNAFUNum.length() - 1 - i);
            } else {
               decimalSum += (sNAFUNum.charAt(i) - '0') * Math.pow(5, sNAFUNum.length() - 1 - i);
            }
         }
      }
      String sNAFUSum = "";
      long power = Math.round(Math.log(decimalSum) / Math.log(5));
      for (int i = 0; i <= power; i++) {
         sNAFUSum += '0';
      }
      for (int i = 0; i <= sNAFUSum.length() - 1; i++) {
         int digit = (int) (decimalSum / Math.pow(5, sNAFUSum.length() - 1 - i));
         sNAFUSum = replace(sNAFUSum, convertToSNAFU(digit), i);
         if (digit > 2) {
            sNAFUSum = theGoodPlace(sNAFUSum, digit, i);
         }
         decimalSum -= digit * Math.pow(5, sNAFUSum.length() - 1 - i);
      }
      System.out.print(sNAFUSum);
      stdin.close();
   }

   public static char convertToSNAFU(int digit) {
      if (digit == -1 || digit == 4) {
         return '-';
      } else if (digit == -2 || digit == 3) {
         return '=';
      } else if (digit == -3) {
         return '2';
      } else if (digit == -4) {
         return '1';
      } else {
         return (char) (digit + '0');
      }
   }

   public static char increaseSNAFbyOne(char sNappy) {
      if (sNappy == '=') {
         return '-';
      } else if (sNappy == '-') {
         return '0';
      } else if (sNappy == '2') {
         return '=';
      } else {
         return (char) (((sNappy - '0') + 1) + '0');
      }
   }

   public static String theGoodPlace(String sum, int digit, int index) {
      for (int i = index - 1; i >= 0; i--) {
         char currentSubject = increaseSNAFbyOne(sum.charAt(i));
         sum = replace(sum, currentSubject, i);
         if (currentSubject == '=') {
            continue;
         } else {
            break;
         }
      }
      return sum;
   }

   public static String replace(String str, char ch, int index) {
      return str.substring(0, index) + ch + str.substring(index + 1);
   }
}