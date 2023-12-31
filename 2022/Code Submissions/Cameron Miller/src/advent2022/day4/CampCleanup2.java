package advent2022.day4;
import java.util.Scanner;

public class CampCleanup2 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);

        String line = "";
        int total = 0;
        while(true){
            line = stdin.nextLine();
            if (line.equals("done"))
                break;

            int low1 = 0, high1 = 0, low2 = 0, high2 = 0;

            String temp = "";
            int i = 0;
            System.out.println(line);
            while(line.charAt(i) != '-'){
                temp += line.charAt(i);
                i++;
            }

            low1 = Integer.valueOf(temp);
            temp = "";
            i++;

            while(line.charAt(i) != ','){
                temp += line.charAt(i);
                i++;
            }

            high1 = Integer.valueOf(temp);
             temp = "";
             i++;

             while(line.charAt(i) != '-'){
                temp += line.charAt(i);
                i++;
            }

            low2 = Integer.valueOf(temp);
            temp = "";
            i++;

            while (i < line.length()){
                temp += line.charAt(i);
                i++;
            }
            high2 = Integer.valueOf(temp);

            if ((low1 <= low2 && high1 >= low2)
            || (low2 <= low1 && high2 >= low1))
                    total++;

        }

        System.out.println(total);
        stdin.close();
    }
}