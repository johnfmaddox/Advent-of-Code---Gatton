package ChristmasCode.Day9;

import java.util.Scanner;
import java.util.ArrayList;

public class Day9_2 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      int cnt = 1;

      ArrayList<Knot> kns = new ArrayList<Knot>();
      Knot nine = new Knot ();
      Knot eight = new Knot (nine);
      Knot seven = new Knot(eight);
      Knot six = new Knot (seven);
      Knot five = new Knot (six);
      Knot four = new Knot (five);
      Knot three = new Knot(four);
      Knot two = new Knot (three);
      Knot one = new Knot (two);
      Knot head = new Knot(one);
      
      kns.add(head);
      kns.add(one);
      kns.add(two);
      kns.add(three);
      kns.add(four);
      kns.add(five);
      kns.add(six);
      kns.add(seven);
      kns.add(eight);
      kns.add(nine);

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

         move(one, head, kns, vertical, horizontal);
        
         
      }
      System.out.print(vertical.size());

   }

   public static void move(Knot kn, Knot front, ArrayList<Knot> kns, ArrayList<Integer> vert, ArrayList<Integer> horz ) {
      int xDiff = front.getX() - kn.getX();
      int yDiff = front.getY() - kn.getY();
boolean there = false;

         if ((Math.abs(xDiff) > 0 && Math.abs(yDiff) > 1) || (Math.abs(yDiff) > 0 && Math.abs(xDiff) > 1)) {
            while ((Math.abs(xDiff) > 0 && Math.abs(yDiff) > 0)) {
   
               kn.shiftX(xDiff);
               kn.shiftY(yDiff);
               int index = kns.indexOf(kn) + 1;
               if (kn.getBehind() != null) {
                  move(kns.get(index), kn, kns, vert, horz);
               } else {
                  there = unique(kn.getX(), kn.getY(), vert, horz);
                  if (there) {
               
               horz.add(kn.getX());
               vert.add(kn.getY());
               
            }
               }
               
               //System.out.println(tail.getX() + " " + tail.getY() + " first" + " " + front.getX() + " " + head.getY());
   
               xDiff = front.getX() - kn.getX();
               yDiff = front.getY() - kn.getY();
               if (Math.abs(xDiff) == 1 && Math.abs(yDiff) == 1) {
                  break;
               }
            }
         }
   
         while (Math.abs(xDiff) > 1) {
            kn.shiftX(xDiff);
            //System.out.println(tail.getX() + " " + tail.getY() + " second" + " " + head.getX() + " " + head.getY())
   
            xDiff = front.getX() - kn.getX();
            yDiff = front.getY() - kn.getY();
            int index = kns.indexOf(kn) + 1;
               if (kn.getBehind() != null) {
                  move(kns.get(index), kn, kns, vert, horz);
               } else {
                  there = unique(kn.getX(), kn.getY(), vert, horz);
                  if (there) {
               
               horz.add(kn.getX());
               vert.add(kn.getY());
               
            }
               }
         }
         while (Math.abs(yDiff) > 1) {
   
            kn.shiftY(yDiff);
            //System.out.println(tail.getX() + " " + tail.getY() + " third" + " " + head.getX() + " " + head.getY());
            xDiff = front.getX() - kn.getX();
            yDiff = front.getY() - kn.getY();
            int index = kns.indexOf(kn) + 1;
               if (kn.getBehind() != null) {
                  move(kns.get(index), kn, kns, vert, horz);
               } else {
                  there = unique(kn.getX(), kn.getY(), vert, horz);
                  if (there) {
               
               horz.add(kn.getX());
               vert.add(kn.getY());
               
            }
               }
   
         }
        //System.out.println(kn.getX() + ":" + kn.getY());
      
   }

   public static boolean unique(int x, int y, ArrayList<Integer> vert, ArrayList<Integer> horz) {

      for (int i = 0; i < vert.size(); i++) {

         if (x == horz.get(i) && y == vert.get(i)) {
            return false;
         }
      }
     // for (int i = 0; i < vert.size(); i++) {

      //  System.out.print(horz.get(i) + ":" + vert.get(i) + " ");
        // }
        // System.out.println(x + ":" + y);
      
      return true;
   }
}
