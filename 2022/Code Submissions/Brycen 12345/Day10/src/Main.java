import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day10/Data.txt";
        File input = new File(fileName);
        try{
            Scanner in = new Scanner(input);
            int cycle = 0;
            int X = 1;
            HashMap<Integer, Integer> screen = new HashMap<>();
            screen.put(0 ,1);
            while(in.hasNextLine()) {
                String line = in.nextLine();
                if(line.equals("noop")) {
                    cycle++;
                    screen.put(cycle, X);
                } else {
                    cycle++;
                    screen.put(cycle, X);
                    String[] arr = line.split(" ");
                    int num = Integer.parseInt(arr[1]);
                    cycle++;
                    screen.put(cycle, X);
                    X += num;
                }
            }
            int start = 20;
            int sum = 0;
            int run = 0;
            if(screen.size() == 20) {
                run = 1;
            } else {
                run = screen.size() / 40;
            }
            for(int i = 0; i < run; i++) {
                int value = screen.get(start);
                int res = value * start;
                sum += res;
                //System.out.println(start + " "  + value);
                start += 40;
            }
            System.out.println(sum);
        }
        catch(Exception ex) {
            System.out.println("error");
        }
    }
}