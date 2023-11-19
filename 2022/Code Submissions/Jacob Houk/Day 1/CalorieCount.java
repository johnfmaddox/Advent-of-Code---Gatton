package Day1;


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CalorieCount {
   public static void main(String[] args) throws FileNotFoundException{
      Scanner stdin = new Scanner(new File("input1"));
      
      Cal[] calories = new Cal[1];
      int i = 0;
      
      int maxCal = Integer.MIN_VALUE;
      
      while (stdin.hasNext()) {
         if (i == calories.length) {
            calories = addLength(calories);
         }
         
         String next = stdin.nextLine();
         
         if (!next.equals("")) {
            if (calories[i] == null) {
               calories[i] = new Cal(Integer.parseInt(next));
            } else {
               calories[i].add(Integer.parseInt(next));
            }
         } else {
            i++;
         }
      }
      
      for (int j = 0; j < calories.length; j++) {
         if (calories[j] == null) {
            break;
         } else if (calories[j].getCalorie() > maxCal) {
            maxCal = calories[j].getCalorie();
         }
      }
      
      System.out.print(maxCal);
      
      stdin.close();
   }
   
   public static Cal[] addLength(Cal[] calories) {
      Cal[] temp = new Cal[calories.length * 2];
      
      for (int i = 0; i < calories.length; i++) {
         temp[i] = calories[i];
      }
      
      return temp;
   }
}