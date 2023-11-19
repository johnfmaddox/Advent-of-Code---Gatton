package Day2;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class RockPaperScissors {
   public static final int x = 1, y = 2, z = 3;
   public static final int w = 6, d = 3, l = 0;
   public static void main(String[] args) throws FileNotFoundException{
      Scanner stdin = new Scanner(new File("input2"));
      
      String oppo, you;
      int total = 0;
      
      while (stdin.hasNext()) {
         oppo = stdin.next();
         you = stdin.next();
         
         total += outcome(oppo, you);
      }
      
      System.out.println(total);
      
      stdin.close();
   }
   
   public static int outcome(String oppo, String you) {
      if (oppo.equals("A") && you.equals("X")) {
         return d + x;
      } else if (oppo.equals("A") && you.equals("Y")) {
         return w + y;
      } else if (oppo.equals("A") && you.equals("Z")) {
         return l + z;
      } else if (oppo.equals("B") && you.equals("X")) {
         return l + x;
      } else if (oppo.equals("B") && you.equals("Y")) {
         return d + y;
      } else if (oppo.equals("B") && you.equals("Z")) {
         return w + z;
      } else if (oppo.equals("C") && you.equals("X")) {
         return w + x;
      } else if (oppo.equals("C") && you.equals("Y")) {
         return l + y;
      } else {
         return d + z;
      }
   }
}