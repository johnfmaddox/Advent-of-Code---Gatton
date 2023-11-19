package ChristmasCode.Day10;

import java.util.Scanner;

public class Day10 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      
      int cnt = 1;
      int value = 1;
      int total = 0;
      while (stdin.hasNextLine()) {
         
         String type = stdin.next();
         
         if (type.equals("noop")) {
            if (cnt == 20 || (cnt - 20) % 40 == 0) {
               total += cnt * value;
               System.out.println(cnt + " " + value + " noob");
            }
            cnt++; 
            
            continue;
         } else {
            if (cnt == 20 || (cnt - 20) % 40 == 0) {
               total += cnt * value;
               System.out.println(cnt + " " + value + " else");
            }
            cnt++;
            if (cnt == 20 || (cnt - 20) % 40 == 0) {
               total += cnt * value;
               System.out.println(cnt + " " + value + " else");
            }
              cnt++;
            type = stdin.next();
            int add = Integer.parseInt(type);
            value += add;
          
            
      }
      }
System.out.println(total);

   }
}
