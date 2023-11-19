import java.util.Scanner;

public class Day1 {
   public static void main(String args[]) {
      Scanner stdin = new Scanner(System.in);

      long mostCal1 = 0;
      long mostCal2 = 0;
      long mostCal3 = 0;
      while (stdin.hasNextLine()) {
         long totalCal = 0;
         String calories = "";
         while (stdin.hasNextLine()) {
            calories = stdin.nextLine();
            if (calories.equals("")) {
               break;
            }
            totalCal += Integer.parseInt(calories);
         }

         if (totalCal <= mostCal1 && totalCal <= mostCal2 && totalCal > mostCal3) {

            mostCal3 = totalCal;
         }

         if (totalCal <= mostCal1 && totalCal > mostCal2) {
            mostCal3 = mostCal2;
            mostCal2 = totalCal;
         }

         if (totalCal > mostCal1) {
            mostCal3 = mostCal2;
            mostCal2 = mostCal1;
            mostCal1 = totalCal;

         }

      }
      System.out.println(mostCal1);
      long threeCal = mostCal1 + mostCal2 + mostCal3;
      System.out.println(threeCal);
      stdin.close();
   }
}
