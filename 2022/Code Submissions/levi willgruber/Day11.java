package ChristmasCode.Day11;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class Day11 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      long[] divs = new long[8];
      ArrayList<Monkey> monkeys = new ArrayList<Monkey>();

      for (int j = 0; j < 8; j++) {
         String input = stdin.next();
         input = stdin.next();
         monkeys.add(new Monkey());
         input = stdin.next();
         input = stdin.next();
         input = stdin.next();
         /*@showBuiltIn java.util.ArrayList */
         ArrayList<Long> items = monkeys.get(j).getItems();

         while (true) {
            String num = "";
            if (input.charAt(input.length() - 1) == ',') {
               for (int i = 0; i < input.length() - 1; i++) {
                  num += input.charAt(i) ;
                  
               }
               items.add(Long.parseLong(num));
            } else {
               items.add(Long.parseLong(input));
               break;
            }
            input = stdin.next();
         }
         input = stdin.next();
         input = stdin.next();
         input = stdin.next();
         input = stdin.next();
         input = stdin.next();
         if (input.equals("*")) {
            monkeys.get(j).setOp("*");
         } else {
            monkeys.get(j).setOp("+");
         }
         input = stdin.next();

         monkeys.get(j).setOpValue(input);

         input = stdin.next();
         input = stdin.next();
         input = stdin.next();
         input = stdin.next();
         monkeys.get(j).setTestValue(Integer.parseInt(input));
         divs[j] = Integer.parseInt(input);

         input = stdin.next();
         input = stdin.next();
         input = stdin.next();
         input = stdin.next();
         input = stdin.next();
         input = stdin.next();
         monkeys.get(j).setTrueMonkey(Integer.parseInt(input));

         input = stdin.next();
         input = stdin.next();
         input = stdin.next();
         input = stdin.next();
         input = stdin.next();
         input = stdin.next();
         monkeys.get(j).setFalseMonkey(Integer.parseInt(input));
      }
      
     
   
     
      

      for (int i = 0; i < 20; i++) {
         
         for (int j = 0; j < 8; j++) {
            
            ArrayList<Long> items = monkeys.get(j).getItems();

            int length = items.size();
            
           // System.out.println(length + " " + i );
            for (int k = 0; k < length; k++) {
               
               monkeys.get(j).addInspect();
               long res = getRes(0, monkeys.get(j));
               
                
               
               items.set(0, res);

               int div = monkeys.get(j).getTestValue();
               

               if (items.get(0) % div == 0) {
                  Monkey m = monkeys.get(monkeys.get(j).getTrueMonkey());
                  
                     m.getItems().add(items.get(0));
                     items.remove(0);
                  
               } else {
                  Monkey m = monkeys.get(monkeys.get(j).getFalseMonkey());
                     m.getItems().add(items.get(0));
                  items.remove(0);
               }
               
            }

         }

      }
      long max1 = 0;
      long max2 = 0;
      for (int i = 0; i < monkeys.size(); i ++) {
         System.out.println(i + "th monkey: " + monkeys.get(i).getInspect());
         
         if (monkeys.get(i).getInspect() > max1) {
            max2 = max1;
            max1 = monkeys.get(i).getInspect();
            continue;
         }
         if (monkeys.get(i).getInspect() > max2) {
             max2 = monkeys.get(i).getInspect();
         }
      }
      long monkybizz = max1 * max2;
      System.out.println("Max1: " + max1 + ", Max2: " + max2);
      System.out.println("Monkybizz: " + monkybizz);
   }

   public static long getRes(int index, Monkey m) {
      ArrayList<Long> items = m.getItems();
      long item = m.items.get(index);
      if (m.getSquare()) {
         return (item * item) / 3;
      } else if (m.getOp().equals("*")) {
         return item * m.getOpValue() / 3;
      } else {
         return (item + m.getOpValue()) / 3;
      }
   }
}
