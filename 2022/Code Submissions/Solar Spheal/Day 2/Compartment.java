

import java.util.Scanner;

public class Compartment {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      String a = "";
      String b = "";
      int sum = 0;
      int lastsum = 0;
      while(stdin.hasNextLine()) {
         String compartment = stdin.nextLine();
         
         for (int i = 0; i < compartment.length() / 2; i++) {
             a += compartment.charAt(i);
            
         }
         
         for (int i = 0; i < compartment.length() / 2; i++) {
            int f = compartment.length() / 2 + i;
            b += compartment.charAt(f);
         }
         
         for (int i = 0; i <= a.length() - 1; i++) {
            lastsum = sum;
            for (int f = 0; f <= a.length() - 1; f++) {
               if (a.charAt(i) == b.charAt(f)) {
                  sum += value(a.charAt(i));
                  break;
               }
            }
            if (sum > lastsum) {
               break;
            }
         }
         
         a = "";
         b = "";
      }
      System.out.println(sum);
   }
   
   public static int value(char letter) {
      switch(letter) {
         case 'a':
            return 1;
         case 'b':
            return 2;
         case 'c':
            return 3;
         case 'd':
            return 4;
         case 'e':
            return 5;
         case 'f':
            return 6;
         case 'g':
            return 7;
         case 'h':
            return 8;
         case 'i':
            return 9;
         case 'j':
            return 10;
         case 'k':
            return 11;
         case 'l':
            return 12;
         case 'm':
            return 13;
         case 'n':
            return 14;
         case 'o':
            return 15;
         case 'p':
            return 16;
         case 'q':
            return 17;
         case 'r':
            return 18;
         case 's':
            return 19;
         case 't':
            return 20;
         case 'u':
            return 21;
         case 'v':
            return 22;
         case 'w':
            return 23;
         case 'x':
            return 24;
         case 'y':
            return 25;
         case 'z':
            return 26;
         case 'A':
            return 27;
         case 'B':
            return 28;
         case 'C':
            return 29;
         case 'D':
            return 30;
         case 'E':
            return 31;
         case 'F':
            return 32;
         case 'G':
            return 33;
         case 'H':
            return 34;
         case 'I':
            return 35;
         case 'J':
            return 36;
         case 'K':
            return 37;
         case 'L':
            return 38;
         case 'M':
            return 39;
         case 'N': 
            return 40;
         case 'O':
            return 41;
         case 'P':
            return 42;
         case 'Q':
            return 43;
         case 'R':
            return 44;
         case 'S':
            return 45;
         case 'T':
            return 46;
         case 'U':
            return 47;
         case 'V':
            return 48;
         case 'W':
            return 49;
         case 'X':
            return 50;
         case 'Y':
            return 51;
      } 
      return 52;
      }
      
   }
