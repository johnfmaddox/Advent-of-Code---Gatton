package AoC2022.Day5;
//I created an object called Stack for each column of crates
//after creating all the arrays of stacks, I created methods to move them around
//the first element in each array is the top of each stack
import java.util.Scanner;

import java.util.StringTokenizer;

public class SupplyStacks2 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      String row = stdin.nextLine();
      Stack[] stacks = new Stack[(row.length() + 1) / 4];
      for (int i = 0; i <= stacks.length - 1; i++) {
         stacks[i] = new Stack();
      }
      while (row.charAt(1) != '1') {
         for (int i = 0; i <= row.length() - 1; i++) {
            if (row.charAt(i) == '[' || row.charAt(i) == ']' || row.charAt(i) == ' ') {
               continue;
            } else {
               stacks[i / 4].addCrate(row.charAt(i));
            }
         }
         row = stdin.nextLine();
      }
      stdin.nextLine();
      while (stdin.hasNextLine()) {
         StringTokenizer st = new StringTokenizer(stdin.nextLine());
         int cnt = 0;
         int num = 0;
         int fromStack = 0;
         int toStack = 0;
         while (st.hasMoreTokens()) {
            String token = st.nextToken();
            cnt++;
            if (cnt == 2) {
               num = convertString(token);
            } else if (cnt == 4) {
               fromStack = convertString(token);
            } else if (cnt == 6) {
               toStack = convertString(token);
            } else {
               continue;
            }
         }
         stacks[fromStack - 1].move(num, stacks[toStack - 1]);
      }
      for (int i = 0; i <= stacks.length - 1; i++) {
         System.out.print(stacks[i].crates[0]);
      }
   }

   public static int convertString(String num) {
      int digit = 1;
      int convertedString = 0;
      for (int i = num.length() - 1; i >= 0; i--) {
         convertedString += ((num.charAt(i) - '0') * digit);
         digit *= 10;
      }
      return convertedString;
   }
}

class Stack {
   char[] crates;
   int crateNum;

   Stack() {
      this.crates = new char[100];
      this.crateNum = 0;
   }

   public void addCrate(char crate) {
      for (int i = 0; i <= crates.length - 1; i++) {
         if (crates[i] == '\u0000') {
            crates[i] = crate;
            crateNum++;
            return;
         } else {
            continue;
         }
      }
   }

   public void move(int num, Stack stack) {
      for (int i = stack.crateNum - 1; i >= 0; i--) {
         stack.crates[i + num] = stack.crates[i];
      }
      for (int i = num - 1; i >= 0; i--) {
         stack.crates[i] = this.crates[i];
      }
      for (int i = num; i <= this.crateNum; i++) {
         this.crates[i - num] = this.crates[i];
      }
      stack.crateNum += num;
      this.crateNum -= num;
   }
}