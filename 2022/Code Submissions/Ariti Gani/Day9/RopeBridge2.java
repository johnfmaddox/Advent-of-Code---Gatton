package AoC2022.Day9;
//I made x and y coordinates for the head and tail knots and an array of 10 knots
//based on the direction and number of steps, I updated each knot's position
//then I used a method to determine if the tail's current position was a duplicate
//if it wasn't then I added one to the number of positions the tail visited
import java.util.Scanner;

import java.util.Arrays;

public class RopeBridge2 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      Knot[] knots = new Knot[10];
      for (int i = 0; i <= knots.length - 1; i++) {
         knots[i] = new Knot();
      }
      int positionsTailVisited = 1;
      String[] coordinatesVisited = new String[10000];
      coordinatesVisited[0] = "0,0";
      while (stdin.hasNextLine()) {
         String direction = stdin.next();
         int numOfSteps = stdin.nextInt();
         if (direction.equals("R")) {
            for (int i = 1; i <= numOfSteps; i++) {
               knots[0].x++;
               for (int j = 1; j <= 9; j++) {
                  double distance = knots[j].getDistance(knots[j - 1]);
                  if (distance == 0 || distance == 1 || distance == Math.sqrt(2)) {
                     break;
                  } else if (distance % 2 == 0 || distance % 2 == 1) {
                     if (knots[j - 1].y > knots[j].y) {
                        knots[j].y++;
                     } else if (knots[j - 1].x > knots[j].x) {
                        knots[j].x++;
                     } else if (knots[j - 1].x < knots[j].x) {
                        knots[j].x--;
                     } else if (knots[j - 1].y < knots[j].y) {
                        knots[j].y--;
                     }
                  } else {
                     if (knots[j].x > knots[j - 1].x) {
                        knots[j].x--;
                     } else {
                        knots[j].x++;
                     }
                     if (knots[j].y > knots[j - 1].y) {
                        knots[j].y--;
                     } else {
                        knots[j].y++;
                     }
                  }
               }
               if (!(knots[9].found(coordinatesVisited, positionsTailVisited, knots[9].x + "," + knots[9].y))) {
                  coordinatesVisited[positionsTailVisited++] = knots[9].x + "," + knots[9].y;
               }
            }
         } else if (direction.equals("U")) {
            for (int i = 1; i <= numOfSteps; i++) {
               knots[0].y++;
               for (int j = 1; j <= 9; j++) {
                  double distance = knots[j].getDistance(knots[j - 1]);
                  if (distance == 0 || distance == 1 || distance == Math.sqrt(2)) {
                     break;
                  } else if (distance % 2 == 0 || distance % 2 == 1) {
                     if (knots[j - 1].y > knots[j].y) {
                        knots[j].y++;
                     } else if (knots[j - 1].x > knots[j].x) {
                        knots[j].x++;
                     } else if (knots[j - 1].x < knots[j].x) {
                        knots[j].x--;
                     } else if (knots[j - 1].y < knots[j].y) {
                        knots[j].y--;
                     }
                  } else {
                     if (knots[j].x > knots[j - 1].x) {
                        knots[j].x--;
                     } else {
                        knots[j].x++;
                     }
                     if (knots[j].y > knots[j - 1].y) {
                        knots[j].y--;
                     } else {
                        knots[j].y++;
                     }
                  }
               }
               if (!(knots[9].found(coordinatesVisited, positionsTailVisited, knots[9].x + "," + knots[9].y))) {
                  coordinatesVisited[positionsTailVisited++] = knots[9].x + "," + knots[9].y;
               }
            }
         } else if (direction.equals("L")) {
            for (int i = 1; i <= numOfSteps; i++) {
               knots[0].x--;
               for (int j = 1; j <= 9; j++) {
                  double distance = knots[j].getDistance(knots[j - 1]);
                  if (distance == 0 || distance == 1 || distance == Math.sqrt(2)) {
                     break;
                  } else if (distance % 2 == 0 || distance % 2 == 1) {
                     if (knots[j - 1].y > knots[j].y) {
                        knots[j].y++;
                     } else if (knots[j - 1].x > knots[j].x) {
                        knots[j].x++;
                     } else if (knots[j - 1].x < knots[j].x) {
                        knots[j].x--;
                     } else if (knots[j - 1].y < knots[j].y) {
                        knots[j].y--;
                     }
                  } else {
                     if (knots[j].x > knots[j - 1].x) {
                        knots[j].x--;
                     } else {
                        knots[j].x++;
                     }
                     if (knots[j].y > knots[j - 1].y) {
                        knots[j].y--;
                     } else {
                        knots[j].y++;
                     }
                  }
               }
               if (!(knots[9].found(coordinatesVisited, positionsTailVisited, knots[9].x + "," + knots[9].y))) {
                  coordinatesVisited[positionsTailVisited++] = knots[9].x + "," + knots[9].y;
               }
            }
         } else {
            for (int i = 1; i <= numOfSteps; i++) {
               knots[0].y--;
               for (int j = 1; j <= 9; j++) {
                  double distance = knots[j].getDistance(knots[j - 1]);
                  if (distance == 0 || distance == 1 || distance == Math.sqrt(2)) {
                     break;
                  } else if (distance % 2 == 0 || distance % 2 == 1) {
                     if (knots[j - 1].y > knots[j].y) {
                        knots[j].y++;
                     } else if (knots[j - 1].x > knots[j].x) {
                        knots[j].x++;
                     } else if (knots[j - 1].x < knots[j].x) {
                        knots[j].x--;
                     } else if (knots[j - 1].y < knots[j].y) {
                        knots[j].y--;
                     }
                  } else {
                     if (knots[j].x > knots[j - 1].x) {
                        knots[j].x--;
                     } else {
                        knots[j].x++;
                     }
                     if (knots[j].y > knots[j - 1].y) {
                        knots[j].y--;
                     } else {
                        knots[j].y++;
                     }
                  }
               }
               if (!(knots[9].found(coordinatesVisited, positionsTailVisited, knots[9].x + "," + knots[9].y))) {
                  coordinatesVisited[positionsTailVisited++] = knots[9].x + "," + knots[9].y;
               }
            }
         }
      }
      System.out.println(positionsTailVisited);
   }
}

class Knot {
   public int x;
   public int y;

   public Knot() {
      this.x = 0;
      this.y = 0;
   }

   public double getDistance(Knot another) {
      return (Math.sqrt(Math.pow(this.x - another.x, 2) + Math.pow(this.y - another.y, 2)));
   }

   public boolean found(String[] coordinates, int length, String xy) {
      for (int i = 0; i <= length - 1; i++) {
         if (coordinates[i].equals(xy)) {
            return true;
         }
      }
      return false;
   }

   public String toString() {
      return this.x + "," + this.y;
   }
}