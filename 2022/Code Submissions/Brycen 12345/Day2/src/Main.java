import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day2/Data.txt";
        File input = new File(fileName);
        try {
            Scanner in = new Scanner(input);
            int score = 0;
            while(in.hasNextLine()) {
                String match = in.nextLine();
                char opp = ' ';
                char me = ' ';
                opp = match.charAt(0);
                me = match.charAt(2);

                if (opp == 'A' && me == 'X') {
                    score += 3;
                    score += 1;
                }
                if (opp == 'B' && me == 'Y') {
                    score += 2;
                    score += 3;
                }
                if (opp == 'C' && me == 'Z') {
                    score += 3;
                    score += 3;
                }
                if (opp == 'A' && me == 'Y') {
                    score += 6;
                    score += 2;
                }
                if (opp == 'A' && me == 'Z') {
                    score += 3;
                    score += 0;
                }
                if (opp == 'B' && me == 'X') {
                    score += 0;
                    score += 1;
                }
                if (opp == 'B' && me == 'Z') {
                    score += 6;
                    score += 3;
                }
                if (opp == 'C' && me == 'X') {
                    score += 6;
                    score += 1;
                }
                if (opp == 'C' && me == 'Y') {
                    score += 0;
                    score += 2;
                }
            }
            System.out.println(score);
        } catch(Exception ex){
            System.out.println("error" + ex.getMessage());
        }
    }
}