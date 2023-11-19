package CS290.AOC;

import java.util.Scanner;

/** PART1 **/
public class Day6 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      String text = stdin.next();
      // variables which will section each four values to evaluate
      int start = 0;
      int end = start + 4;
      // evaluate until start to end values are unique
      while (true) {
         int[] sectionCount = countLetters(start, end, text);
         if (isUnique(sectionCount)) {
            System.out.println(end);
            break;
         } else {
            start++;
            end = start + 4;
         }
      }
   }
   // count method will return an array with the count of each letter
   public static int[] countLetters(int start, int end, String text) {
      // create array of size four which corresponds to each count
      // index variable will increment at the beginning of each outer loop
      int[] countArray = new int[4];
      int countArrayIndex = 0;
      // nested loop between start and end to count each letter's count
      for (int i = start; i < end; i++) {
         char iLetter = text.charAt(i);
         for (int j = start; j < end; j++) {
            // if both equal, 
            // increment the count @ countArray[countArrayIndex]++
            char jLetter = text.charAt(j);
            if (iLetter == jLetter) {
               countArray[countArrayIndex]++;
            }
         }
         countArrayIndex++;
      }
      return countArray;
   }
   // method will check if any value is greater than 1, if yes, then false
   public static boolean isUnique(int[] array) {
      boolean isUnique = true;
      for (int i = 0; i < array.length; i++) {
         // if array @ i > 1, isUnique = false
         if (array[i] > 1) {
            isUnique = false;
            break;
         }
      }
      return isUnique;
   }
}

/** PART 2 **/

public class Day6 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      String text = stdin.next();
      // variables which will section each four values to evaluate
      int start = 0;
      int end = start + 14;
      // evaluate until start to end values are unique
      while (true) {
         int[] sectionCount = countLetters(start, end, text);
         if (isUnique(sectionCount)) {
            System.out.println(end);
            break;
         } else {
            start++;
            end = start + 14;
         }
      }
   }
   // count method will return an array with the count of each letter
   public static int[] countLetters(int start, int end, String text) {
      // create array of size four which corresponds to each count
      // index variable will increment at the beginning of each outer loop
      int[] countArray = new int[14];
      int countArrayIndex = 0;
      // nested loop between start and end to count each letter's count
      for (int i = start; i < end; i++) {
         char iLetter = text.charAt(i);
         for (int j = start; j < end; j++) {
            // if both equal, 
            // increment the count @ countArray[countArrayIndex]++
            char jLetter = text.charAt(j);
            if (iLetter == jLetter) {
               countArray[countArrayIndex]++;
            }
         }
         countArrayIndex++;
      }
      return countArray;
   }
   // method will check if any value is greater than 1, if yes, then false
   public static boolean isUnique(int[] array) {
      boolean isUnique = true;
      for (int i = 0; i < array.length; i++) {
         // if array @ i > 1, isUnique = false
         if (array[i] > 1) {
            isUnique = false;
            break;
         }
      }
      return isUnique;
   }
}