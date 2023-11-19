package AoC2022.Day10;
//I made variables for X and the cycle number
//each time I updated the cycle number and the value of X based on the value of V
//then if the pixel position was close or exactly the value of X I printed a "#"
//otherwise I printed a "."
import java.util.Scanner;

public class CathodeRay2 {

   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      int cycleNumber = 0;
      int registerX = 1;
      int pixelPosition = 0;
      while (stdin.hasNextLine()) {
         String instruction = stdin.next();
         if (instruction.equals("noop")) {
            cycleNumber++;
            if (pixelPosition == registerX || pixelPosition == registerX - 1 || pixelPosition == registerX + 1) {
               pixelPosition = draw("#", pixelPosition);
            } else {
               pixelPosition = draw(".", pixelPosition);
            }
         }
         if (instruction.equals("addx")) {
            cycleNumber++;
            int valueV = stdin.nextInt();
            if (pixelPosition == registerX || pixelPosition == registerX - 1 || pixelPosition == registerX + 1) {
               pixelPosition = draw("#", pixelPosition);
            } else {
               pixelPosition = draw(".", pixelPosition);
            }
            cycleNumber++;
            if (pixelPosition == registerX || pixelPosition == registerX - 1 || pixelPosition == registerX + 1) {
               pixelPosition = draw("#", pixelPosition);
            } else {
               pixelPosition = draw(".", pixelPosition);
            }
            registerX += valueV;
         }
      }
      stdin.close();
   }

   public static int draw(String pixel, int pixelPosition) {
      if (pixelPosition == 39) {
         System.out.println(pixel);
         return 0;
      } else {
         System.out.print(pixel);
         return pixelPosition + 1;
      }
   }
}