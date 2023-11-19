import java.io.File;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        final String fileName = "Day3/Data.txt";
        File input = new File(fileName);
        try {
            Scanner stdin = new Scanner(input);
            String res = "";
            int in = 0;
            String[] matches = new String[500];
            while(stdin.hasNextLine()) {
                String one = stdin.nextLine();
                String two = stdin.nextLine();
                String three = stdin.nextLine();

                char ans = match(one, two, three);
                res += ans;
                matches[in] = res;
                in++;
                res = "";
            }
            int sum = 0;
            for(int i = 0; i < in; i++) {
                sum += val(matches[i]);
            }
            System.out.println(sum);
        } catch(Exception ex){
            System.out.println("error" + ex.getMessage());
        }
    }
    public static char match(String one, String two, String three) {
        int length = one.length();
        int length2 = two.length();
        int length3 = three.length();
        char res = ' ';
        char ans = ' ';
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length2; j++) {
                if(one.charAt(i) == two.charAt(j)) {
                    res = one.charAt(i);
                }
                for(int k = 0; k < length3; k++) {
                    if(three.charAt(k) == res) {
                        ans = res;
                    }
                }
            }
        }
        return ans;
    }

    public static int val(String str) {
        char ch = str.charAt(0);
        int val;
        if(ch >= 97 && ch <= 122) {
            val = ch - 96;
        } else {
            val = ch - 38;
        }
        return val;
    }
}