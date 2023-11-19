package ChristmasCode.Day4;

import java.util.Scanner;

public class Day4_2 {
   public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
      
      int total = 0;
      while (stdin.hasNextLine()) {
         String input = stdin.nextLine();
         String first1 = "";
         String Second1 = "";
         String first2 = "";
         String Second2 = "";
         
         int i = 0;

        
           char ch = input.charAt(i);
            while (input.charAt(i)!= '-') {
            first1 = first1 + input.charAt(i) ;
            i++;
            }
            i++;
            while (input.charAt(i) !=',') {
            Second1 = Second1 + input.charAt(i);
            i++;
            }
            i++;
            while (input.charAt(i)!= '-') {
            first2 = first2 + input.charAt(i);
            i++;
            }
       
            i++;
            while (i < input.length()) {
            Second2 = Second2 + input.charAt(i);
            i++;
          
            }
           
            
            int f1 = Integer.parseInt(first1);
            int s1 = Integer.parseInt(Second1);
            int f2 = Integer.parseInt(first2);
            int s2 = Integer.parseInt(Second2);
         
         if (((f1 >= f2 && f1 <= s2 )|| (s1 >= f2 && s1 <= s2))|| ((f2 >= f1 && f2 <= s1 )|| (s2 >= f1 && s2 <= s1))) {
            total++;
         }
         
      }
      System.out.print(total);
   }
}
