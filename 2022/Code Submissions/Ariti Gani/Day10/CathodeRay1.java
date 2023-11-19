package AoC2022.Day10;
//I made variables for X and the cycle number
//each time I updated the cycle number and the value of X based on the value of V
//then if the cycle number was divisible by 20 but not 40, I found the signal strength
//then I added it to the sumOfSignalStrengths
import java.util.Scanner;

public class CathodeRay1 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      int cycleNumber = 0;
      int registerX = 1;
      int sumOfSignalStrengths = 0;
      while (stdin.hasNextLine()) {
         String instruction = stdin.next();
         if (instruction.equals("noop")) {
            cycleNumber++;
            if (cycleNumber % 20 == 0 && cycleNumber % 40 != 0) {
               sumOfSignalStrengths += cycleNumber * registerX;
            }
         }
         if (instruction.equals("addx")) {
            cycleNumber++;
            int valueV = stdin.nextInt();
            if (cycleNumber % 20 == 0 && cycleNumber % 40 != 0) {
               sumOfSignalStrengths += cycleNumber * registerX;
            }
            cycleNumber++;
            if (cycleNumber % 20 == 0 && cycleNumber % 40 != 0) {
               sumOfSignalStrengths += cycleNumber * registerX;
            }
            registerX += valueV;
         }
      }
      System.out.print(sumOfSignalStrengths);
      stdin.close();
   }
}