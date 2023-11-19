import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day1/Data.txt";
        File input = new File(fileName);
        try {
            Scanner in = new Scanner(input);
            ArrayList<Integer> sums = new ArrayList<>();
            while(in.hasNextLine()) {
                int next;
                String line = in.nextLine();
                int sum = 0;
                do {
                    next = Integer.parseInt(line);
                    sum += next;
                    line = in.nextLine();

                } while (!line.equals(""));
                sums.add(sum);
            }
            Collections.sort(sums, Collections.reverseOrder());
            int ans = 0;
            for (int i = 0; i < 3; i++) {
                ans += sums.get(i);
            }
            System.out.println(ans);

        } catch(Exception ex){
            System.out.println("error" + ex.getMessage());
        }
    }
}