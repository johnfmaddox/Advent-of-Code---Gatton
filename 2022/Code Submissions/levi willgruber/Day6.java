package ChristmasCode.Day6;

import java.util.Scanner;

public class Day6 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      
      
      String input = stdin.next();
      
      int result = 0;
      boolean done = false;
      int cnt = 0;
      while (!done) {
         
        char ch1 = input.charAt(cnt);
        char ch2 = input.charAt(cnt + 1);
        char ch3 = input.charAt(cnt + 2);
        char ch4 = input.charAt(cnt + 3);
        
        
        if (ch1 != ch2 && ch1 != ch3 && ch1 != ch4 && ch2 != ch3 && ch2 != ch4 && ch3 != ch4) {
         result = cnt +4;  
         done = true;
        }
        cnt++;
      }
      System.out.print(result);
   }
}
