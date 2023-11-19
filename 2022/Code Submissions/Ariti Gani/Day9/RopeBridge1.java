package AoC2022.Day9;

import java.util.Scanner;
//I made x and y coordinates for the head and tail knots
//based on the direction and number of steps, I updated the head and tail positions
//then I used a method to determine if the tail's current position was a duplicate
//if it wasn't then I added one to the number of positions the tail visited
public class RopeBridge1 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      int tailX = 0;
      int headX = 0;
      int tailY = 0;
      int headY = 0;
      int positionsTailVisited = 1;
      String[] coordinatesVisited = new String[100000];
      coordinatesVisited[0] = "0,0";
      while (stdin.hasNextLine()) {
         String direction = stdin.next();
         int numOfSteps = stdin.nextInt();
         if (direction.equals("R")) {
            for (int i = 1; i <= numOfSteps; i++) {
               headX++;
               double distance = getDistance(headX, headY, tailX, tailY);
               if (distance == 0 || distance == 1 || distance == Math.sqrt(2)) {
                  if (!(found(coordinatesVisited, tailX + "," + tailY, positionsTailVisited))) {
                     coordinatesVisited[positionsTailVisited++] = tailX + "," + tailY;
                  }
               } else if (distance % 2 == 0 || distance % 2 == 1) {
                  tailX++;
                  if (!(found(coordinatesVisited, tailX + "," + tailY, positionsTailVisited))) {
                     coordinatesVisited[positionsTailVisited++] = tailX + "," + tailY;
                  }
               } else {
                  tailX++;
                  if (tailY > headY) {
                     tailY--;
                  } else {
                     tailY++;
                  }
                  if (!(found(coordinatesVisited, tailX + "," + tailY, positionsTailVisited))) {
                     coordinatesVisited[positionsTailVisited++] = tailX + "," + tailY;
                  }
               }
            }
         } else if (direction.equals("U")) {
            for (int i = 1; i <= numOfSteps; i++) {
               headY++;
               double distance = getDistance(headX, headY, tailX, tailY);
               if (distance == 0 || distance == 1 || distance == Math.sqrt(2)) {
                  if (!(found(coordinatesVisited, tailX + "," + tailY, positionsTailVisited))) {
                     coordinatesVisited[positionsTailVisited++] = tailX + "," + tailY;
                  }
               } else if (distance % 2 == 0 || distance % 2 == 1) {
                  tailY++;
                  if (!(found(coordinatesVisited, tailX + "," + tailY, positionsTailVisited))) {
                     coordinatesVisited[positionsTailVisited++] = tailX + "," + tailY;
                  }
               } else {
                  tailY++;
                  if (tailX > headX) {
                     tailX--;
                  } else {
                     tailX++;
                  }
                  if (!(found(coordinatesVisited, tailX + "," + tailY, positionsTailVisited))) {
                     coordinatesVisited[positionsTailVisited++] = tailX + "," + tailY;
                  }
               }
            }
         } else if (direction.equals("L")) {
            for (int i = 1; i <= numOfSteps; i++) {
               headX--;
               double distance = getDistance(headX, headY, tailX, tailY);
               if (distance == 0 || distance == 1 || distance == Math.sqrt(2)) {
                  if (!(found(coordinatesVisited, tailX + "," + tailY, positionsTailVisited))) {
                     coordinatesVisited[positionsTailVisited++] = tailX + "," + tailY;
                  }
               } else if (distance % 2 == 0 || distance % 2 == 1) {
                  tailX--;
                  if (!(found(coordinatesVisited, tailX + "," + tailY, positionsTailVisited))) {
                     coordinatesVisited[positionsTailVisited++] = tailX + "," + tailY;
                  }
               } else {
                  tailX--;
                  if (tailY > headY) {
                     tailY--;
                  } else {
                     tailY++;
                  }
                  if (!(found(coordinatesVisited, tailX + "," + tailY, positionsTailVisited))) {
                     coordinatesVisited[positionsTailVisited++] = tailX + "," + tailY;
                  }
               }
            }
         } else {
            for (int i = 1; i <= numOfSteps; i++) {
               headY--;
               double distance = getDistance(headX, headY, tailX, tailY);
               if (distance == 0 || distance == 1 || distance == Math.sqrt(2)) {
                  if (!(found(coordinatesVisited, tailX + "," + tailY, positionsTailVisited))) {
                     coordinatesVisited[positionsTailVisited++] = tailX + "," + tailY;
                  }
               } else if (distance % 2 == 0 || distance % 2 == 1) {
                  tailY--;
                  if (!(found(coordinatesVisited, tailX + "," + tailY, positionsTailVisited))) {
                     coordinatesVisited[positionsTailVisited++] = tailX + "," + tailY;
                  }
               } else {
                  tailY--;
                  if (tailX > headX) {
                     tailX--;
                  } else {
                     tailX++;
                  }
                  if (!(found(coordinatesVisited, tailX + "," + tailY, positionsTailVisited))) {
                     coordinatesVisited[positionsTailVisited++] = tailX + "," + tailY;
                  }
               }
            }
         }
      }
      System.out.print(positionsTailVisited);
   }

   public static double getDistance(int x1, int y1, int x2, int y2) {
      return (Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
   }

   public static boolean found(String[] coordinates, String xy, int length) {
      for (int i = 0; i <= length - 1; i++) {
         if (coordinates[i].equals(xy)) {
            return true;
         }
      }
      return false;
   }

}