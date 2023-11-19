package ChristmasCode.Day13;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.*;


public class Day13 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      int total = 0;
      int cnt = 1;
      

      while (true) {

         packs left = new packs();
         String line = stdin.nextLine();
         int i = inside(left, line, 0);

         packs right = new packs();
         line = stdin.nextLine();
         int j = inside(right, line, 0);
         
         
         int comp = (compareTo(left, right));
         System.out.println(comp);
         if (comp == 1 || (comp == 0 && left.getChildren().size() < right.getChildren().size())) {
            total += cnt;
         }
         cnt++;
        
         if (!stdin.hasNextLine()) {
            break;
         }
          String fill = stdin.nextLine();
      }
      System.out.print(total);
      stdin.close();
   }

   public static int inside(packs v, String line, int index) {

      int i = index + 1;

      if (i < line.length()) {
         
         if (line.charAt(i) == ',') {
            i++;
         }
         String num = "" + line.charAt(i);

         if (line.charAt(i) == ']') {
            
            return i;
         } else if (line.charAt(i) == '[') {
            packs p = new packs();
            v.addKid(p);
            i = inside(p, line, i);
            i++;
            num = "";
            
            if (line.charAt(i) == ']') {
               return i;
            } 
            
         }
         i++;

         while (true) {
            while (line.charAt(i) != ',') {
               if (line.charAt(i) == ']') {
                  if (!num.equals("")) {
                     if (num.charAt(0) == ',') {
                        String temp = "";
                        for (int k = 1; k < num.length(); k++) {
                           temp = temp + num.charAt(k);
                        }
                        num = temp;
                     }
                     packs p = new packs(Integer.parseInt(num));
                     v.addKid(p);
                  }
                  return i;
               } else if (line.charAt(i) == '[') {
                  packs p = new packs();
                  v.addKid(p);
                  i = inside(p, line, i);
                  num = "";
                  i++;
               }
               if (line.charAt(i) == ',') {
                  i++;
               }
               if (line.charAt(i) == '[') {
                  packs p = new packs();
                  v.addKid(p);
                  i = inside(p, line, i);
                  num = "";
                  i++;
               }
               num = num + line.charAt(i);
               if (num.equals("]")) {
                  return i;
               }
               i++;

            }
            
            if (num.charAt(0) == ',') {
                        String temp = "";
                        for (int k = 1; k < num.length(); k++) {
                           temp = temp + num.charAt(k);
                        }
                        num = temp;
                     }
            packs p = new packs(Integer.parseInt(num));
            v.addKid(p);
            i++;
            num = "";

            if (line.charAt(i) == '[') {
               packs loo = new packs();
               v.addKid(loo);
               i = inside(loo, line, i);
               num = "";
               i++;
               if (line.charAt(i) == ',') {
                  i++;
               }
            }
         }

      }
      return 0;
   }

   public static int compareTo(packs left, packs right) {

      boolean isLeft = false;
     
      int comp = 0;
      if (left.getChildren() != null && right.getChildren() != null) {
         int min;
         if (left.getChildren().size() < right.getChildren().size()) {
            isLeft = true;
            min = left.getChildren().size();
         } else {
            min = right.getChildren().size();
         }

         for (int i = 0; i < min; i++) {
            comp = compareTo(left.getChildren().get(i), right.getChildren().get(i));
            if (comp != 0) {
               
               return comp;
            } 
         }
       
      } else if (left.getChildren() == null && right.getChildren() != null && right.getChildren().size() > 0) {
         comp = compareTo(left, right.getChildren().get(0));
         if (comp != 0) {
            
            return comp;
         } else {
            return 1;
         }
      } else if (left.getChildren() != null && right.getChildren() == null && left.getChildren().size() > 0) {
         comp = compareTo(left.getChildren().get(0), right);
         if (comp != 0) {
           
            return comp;
         } else {
            return -1;
         }
      } else if ((left.getChildren() == null || left.getChildren().size() == 0) && (right.getChildren() == null || right.getChildren().size() == 0)) {
        if (left.getVal() == 0 && right.getVal() == 0) {
           if (left.getHasValue() && right.getHasValue()) {
              return 0;
           } else if (!left.getHasValue() && right.getHasValue()) {
              return 1;
           } else if (left.getHasValue() && !right.getHasValue()) {
              return -1;
           }
              
           }
        
         if (left.getVal() < right.getVal()) {
            comp = 1;
           
            return comp;
         } else if (left.getVal() > right.getVal()) {
            comp = -1;
            
            return comp;
         } else {
            comp = 0;
           
            return comp;
         }
      }
      
      if (comp == 0 && left.getChildren().size() < right.getChildren().size()) {
         return 1;
      } else if (comp == 0 && left.getChildren().size() > right.getChildren().size()) {
         return -1;
      } else {
      return 0;
      }
   }

}
