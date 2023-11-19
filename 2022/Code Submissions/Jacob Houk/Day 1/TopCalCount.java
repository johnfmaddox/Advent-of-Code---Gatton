package Day1;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.String;

public class TopCalCount {
	public static void main(String[] args) throws FileNotFoundException {
	  Scanner stdin = new Scanner(new File("input1"));
      
      Cal[] calories = new Cal[1];
      int i = 0;
      
      int maxCal1 = Integer.MIN_VALUE;
      int maxCal2 = Integer.MIN_VALUE;
      int maxCal3 = Integer.MIN_VALUE;
      
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
         }
         
         if (calories[j].getCalorie() > maxCal1) {
            maxCal3 = maxCal2;
            maxCal2 = maxCal1;
            maxCal1 = calories[j].getCalorie();
         } else if (calories[j].getCalorie() > maxCal2) {
            maxCal3 = maxCal2;
            maxCal2 = calories[j].getCalorie();
         } else if (calories[j].getCalorie() > maxCal3) {
            maxCal3 = calories[j].getCalorie();
         } else {
            continue;
         }
      }
      
      System.out.print(maxCal1 + maxCal2 + maxCal3);
      
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