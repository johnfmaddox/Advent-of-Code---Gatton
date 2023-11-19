package ChristmasCode.Day9;

import java.util.Scanner;
import java.util.ArrayList;

public class Day9 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      int cnt = 1;

      Knot head = new Knot();
      Knot tail = new Knot();
      ArrayList<Integer> vertical = new ArrayList<Integer>();
      ArrayList<Integer> horizontal = new ArrayList<Integer>();

      vertical.add(0);
      horizontal.add(0);
      while (stdin.hasNextLine()) {

         boolean vert = false;
         boolean horz = false;
         String dir = stdin.next();
         int length = stdin.nextInt();

         switch (dir) {
            case "U":
               vert = true;
               break;
            case "D":
               vert = true;
               length *= -1;
               break;
            case "R":
               horz = true;
               break;
            case "L":
               horz = true;
               length *= -1;
               break;

         }

         if (horz) {
            head.moveX(length);
         }
         if (vert) {
            head.moveY(length);
         }
         int xDiff = head.getX() - tail.getX();
         int yDiff = head.getY() - tail.getY();
         boolean there = false;
         
         if ((Math.abs(xDiff) > 0 && Math.abs(yDiff) > 1) || (Math.abs(yDiff) > 0 && Math.abs(xDiff) > 1)) {
         while ((Math.abs(xDiff) > 0 && Math.abs(yDiff) > 0 ) 
         || (Math.abs(xDiff) == 1 && Math.abs(yDiff) == 1)) {

                        tail.shiftX(xDiff);
                        tail.shiftY(yDiff);
                           //System.out.println(tail.getX() + " " + tail.getY() + " first" + " " + head.getX() + " " + head.getY());
                        there = unique(tail.getX(), tail.getY(), vertical, horizontal);
                        if (there) {
                           // System.out.println("NEW: "+ tail.getX() + " " + tail.getY() + " first" + " " + head.getX() + " " + head.getY());
                           horizontal.add(tail.getX());
                           vertical.add(tail.getY());
                           cnt++;
                        } //else {
                           //for (int i = 0; i < vertical.size(); i++) {
                             //    System.out.print(vertical.get(i) + ":" + horizontal.get(i) + " ");
                             // }
                             // System.out.println();
                        //}
                        xDiff = head.getX() - tail.getX();
                        yDiff = head.getY() - tail.getY();
                     }
         }
                      
                           while (Math.abs(xDiff) > 1) {
                              tail.shiftX(xDiff);
                              //System.out.println(tail.getX() + " " + tail.getY() + " second" + " " + head.getX() + " " + head.getY());
                              there = unique(tail.getX(), tail.getY(), vertical, horizontal);
                              if (there) {
                                 //System.out.println("NEW: " + tail.getX() + " " + tail.getY() + " second" + " " + head.getX() + " " + head.getY());
                                 horizontal.add(tail.getX());
                                 vertical.add(tail.getY());
                                 cnt++;
                              } //else {
                                 //for (int i = 0; i < vertical.size(); i++) {
                                 //System.out.print(vertical.get(i) + ":" + horizontal.get(i) + " ");
                              //}
                              //System.out.println();
                              //}
                              
                             xDiff = head.getX() - tail.getX();
                              yDiff = head.getY() - tail.getY();
                           }
                        while (Math.abs(yDiff) > 1){
                           
                              tail.shiftY(yDiff);
                                 //System.out.println(tail.getX() + " " + tail.getY() + " third" + " " + head.getX() + " " + head.getY());
                              there = unique(tail.getX(), tail.getY(), vertical, horizontal);
                              if (there) {
                                 //System.out.println("NEW: " + tail.getX() + " " + tail.getY() + " third" + " " + head.getX() + " " + head.getY());
                                 horizontal.add(tail.getX());
                                 vertical.add(tail.getY());
                                 cnt++;
                              } //else {
                                 //for (int i = 0; i < vertical.size(); i++) {
                                 //System.out.print(vertical.get(i) + ":" + horizontal.get(i) + " ");
                             // }
                              //System.out.println();
                              //}
                           xDiff = head.getX() - tail.getX();
                              yDiff = head.getY() - tail.getY();
                        }

        
      }
      System.out.print(cnt);

   }

   public static boolean unique(int x, int y, ArrayList<Integer> vert, ArrayList<Integer> horz) {

      for (int i = 0; i < vert.size(); i++) {

         if (x == horz.get(i) && y == vert.get(i)) {
            return false;
         }
      }
      return true;
   }
}
