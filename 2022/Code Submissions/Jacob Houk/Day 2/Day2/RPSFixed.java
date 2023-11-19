package Day2;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class RPSFixed {
   public static final int a = 1, b = 2, c = 3;
   public static final int w = 6, d = 3, l = 0;
   public static void main(String[] args) throws FileNotFoundException{
      Scanner stdin = new Scanner(new File("input2"));
      
      String oppo, result;
      int total = 0;
      
      while (stdin.hasNext()) {
         oppo = stdin.next();
         result = stdin.next();
         
         total += outcome(oppo, result);
      }
      
      System.out.println(total);
      
      stdin.close();
   }
   
   public static int outcome(String oppo, String result) {
      if (oppo.equals("A") && result.equals("X")) {
         return l + c;
      } else if (oppo.equals("A") && result.equals("Y")) {
         return d + a;
      } else if (oppo.equals("A") && result.equals("Z")) {
         return w + b;
      } else if (oppo.equals("B") && result.equals("X")) {
         return l + a;
      } else if (oppo.equals("B") && result.equals("Y")) {
         return d + b;
      } else if (oppo.equals("B") && result.equals("Z")) {
         return w + c;
      } else if (oppo.equals("C") && result.equals("X")) {
         return l + b;
      } else if (oppo.equals("C") && result.equals("Y")) {
         return d + c;
      } else {
         return w + a;
      }
   }
}