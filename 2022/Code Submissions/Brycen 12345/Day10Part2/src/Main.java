import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day10Part2/Data.txt";
        File input = new File(fileName);
        try{
            Scanner in = new Scanner(input);
            int cycle = 0;
            int X = 1;
            HashMap<Integer, Integer> screen = new HashMap<>();
            screen.put(0 ,1);
            while(in.hasNextLine()) {
                String line = in.nextLine();
                if (line.equals("noop")) {
                    print(cycle , X);
                    cycle++;
                } else {
                    print(cycle , X);
                    cycle++;
                    String[] arr = line.split(" ");
                    int num = Integer.parseInt(arr[1]);
                    print(cycle , X);
                    cycle++;
                    X += num;
                }
            }

        }
        catch(Exception ex) {
            System.out.println("error");
        }
    }
    public static void print(int cycle, int X) {
        if(Math.abs(X - (cycle%40)) <= 1) {
            System.out.print("#" + " ");
        } else {
            System.out.print("." + " ");
        }
        if(cycle == 39 || cycle == 79 || cycle == 119 || cycle == 159|| cycle == 199 || cycle == 239) {
            System.out.println();
        }
    }
}