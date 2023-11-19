package AoC2022.Day6;

//I made a String variable called buffer
//then I made a String variable to take sequences of 3 characters at a time from buffer
//if the sequence has no duplicate characters then that is the marker
import java.util.Scanner;

public class TuningTrouble1 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      String buffer = stdin.next();
      int marker = 0;
      for (int i = 0; i <= ((buffer.length() / 4) * 4) - 4; i++) {
         String seq = "";
         for (int j = i; j <= i + 3; j++) {
            seq += buffer.charAt(j);
         }
         if (unique(seq)) {
            marker = i + 4;
            break;
         } else {
            continue;
         }
      }
      System.out.print(marker);
   }

   public static boolean unique(String seq) {
      for (int i = 0; i <= seq.length() - 1; i++) {
         for (int j = 0; j <= seq.length() - 1; j++) {
            if (j == i) {
               continue;
            } else {
               if (seq.charAt(j) == seq.charAt(i)) {
                  return false;
               }
            }
         }
      }
      return true;
   }
}