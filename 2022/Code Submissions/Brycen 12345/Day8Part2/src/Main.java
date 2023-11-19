import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        final String fileName = "Day8/Data.txt";
        File input = new File(fileName);
        try {
            Scanner in = new Scanner(input);
            List<List<Integer>> forest = new ArrayList();
            int highest = Integer.MIN_VALUE;
            int score = 0;
            while(in.hasNextLine()) {
                List<Integer> line = new ArrayList();
                String[] arr = in.nextLine().split("");
                for (int i = 0; i < arr.length; i++) {
                    line.add(Integer.parseInt(arr[i]));
                }
                forest.add(line);
            }
            for (int row = 0; row < forest.size(); row++) {
                for (int column = 0; column < forest.get(row).size(); column++) {
                    score = score(forest, row, column);
                    if(score > highest) {
                        highest = score;
                    }
                }
            }
            System.out.println(highest);
        } catch(Exception ex){
            System.out.println("error" + ex.getMessage());
        }
    }
    public static int score(List<List<Integer>> forest, int startR, int startC) {
        int left = 0;
        int right = 0;
        int up = 0;
        int down = 0;
        int total = 0;

        for (int R = startR - 1; R >= 0; R--) {
            left++;
            if (forest.get(R).get(startC) >= forest.get(startR).get(startC)) {
                break;
            }
        }
        for (int R = startR + 1; R < forest.size(); R++) {
            right++;
            if (forest.get(R).get(startC) >= forest.get(startR).get(startC)) {
                break;
            }
        }
        for (int C = startC + 1; C < forest.get(0).size(); C++) {
            up++;
            if (forest.get(startR).get(C) >= forest.get(startR).get(startC)) {
                break;
            }
        }
        for (int C = startC - 1; C >= 0; C--) {
            down++;
            if (forest.get(startR).get(C) >= forest.get(startR).get(startC)) {
                break;
            }
        }
        total = left * right * up * down;
        return total;
    }
}