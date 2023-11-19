import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day1/Data.txt";
        File input = new File(fileName);
        try {
            Scanner in = new Scanner(input);
            int high = Integer.MIN_VALUE;
            while(in.hasNextLine()) {
                int next;
                String line = in.nextLine();
                int sum = 0;
                do {
                    next = Integer.parseInt(line);
                    sum += next;
                    line = in.nextLine();

                } while (!line.equals(""));
                if (sum > high) {
                    high = sum;
                }
            }
            System.out.println(high);
        } catch(Exception ex){
            System.out.println("error" + ex.getMessage());
        }
    }
}