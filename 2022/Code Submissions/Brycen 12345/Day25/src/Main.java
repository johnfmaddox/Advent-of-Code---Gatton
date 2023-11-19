import sun.text.normalizer.UCharacter;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day25/Data.txt";
        File input = new File(fileName);
        char[] SNAFU = {'=', '-', '0', '1', '2'};
        try{
            Scanner in = new Scanner(input);
            long sum = 0;
            while(in.hasNextLine()) {
                String line = in.nextLine();
                int base = 0;
                long num = 0;
                for(int i = line.length() - 1; i >= 0; i--) {
                    double power = Math.pow(5,base);
                    if(line.charAt(i) == '-') {
                        sum += -1 * power;
                        //num += -1 * power;
                    } else if (line.charAt(i) == '=') {
                        sum += -2 * power;
                        //num += -2 * power;
                    } else {
                        int digit = line.charAt(i) - '0';
                        sum += digit * power;
                        //num += digit * power;
                    }
                    base++;
                }
                //System.out.println(num);
            }
            //System.out.println(sum);
            String ans = "";
            while(sum > 0) {
                int place = (int)((sum + 2) % 5);
                sum = ((sum + 2) / 5);
                char digit = SNAFU[place];
                ans = digit + ans;
            }
            System.out.println(ans);
        }
        catch(Exception ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
}