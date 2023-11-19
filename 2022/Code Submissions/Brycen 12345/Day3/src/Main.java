import java.io.File;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        final String fileName = "Day3/Data.txt";
        File input = new File(fileName);
        try {
            Scanner stdin = new Scanner(input);
            Bag[] bags = new Bag[500];
            String contents = "";
            int in = 0;
            String[] matches = new String[500];
            while(stdin.hasNextLine()) {
                contents = stdin.nextLine();
                bags[in] = new Bag(contents);
                String ans = match(bags[in].getOne(), bags[in].getTwo());
                matches[in] = ans;
                in++;
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
    public static String match(String one, String two) {
        int length = one.length();
        int length2 = two.length();
        String res = "";
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length2; j++) {
                if(one.charAt(i) == two.charAt(j)) {
                    res += one.charAt(i);
                    break;
                }
            }
        }
        return res;
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
class Bag {
    String sackOne;
    String sackTwo;

    public Bag(String con) {
        String one = "";
        String two = "";
        int length = con.length() / 2;
        for(int i = 0; i < length; i++) {
            one += con.charAt(i);
        }
        this.sackOne = one;
        for(int i = length; i < con.length(); i++) {
            two += con.charAt(i);
        }
        this.sackTwo = two;
    }
    public String getOne() {
        return this.sackOne;
    }
    public String getTwo() {
        return this.sackTwo;
    }
}