import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day6/Data.txt";
        File input = new File(fileName);
        try {
            Scanner in = new Scanner(input);
            String line = in.nextLine();
            String check = "";
            int start = 0;
            int end = 14;
            for(int i = 0; i < line.length(); i++) {
                check = line.substring(start, end);
                if(hasUnique(check)) {
                    System.out.println(end);
                    break;
                }
                start = start + 1;
                end = end + 1;
                check = "";
            }
        } catch(Exception ex){
            System.out.println("error" + ex.getMessage());
        }
    }
    public static boolean hasUnique(String str) {
        HashSet<Character> ch = new HashSet<>();
        for(int c  = 0; c< str.length();c++) {
            ch.add(str.charAt(c));
        }
        return ch.size() == str.length();
    }
}