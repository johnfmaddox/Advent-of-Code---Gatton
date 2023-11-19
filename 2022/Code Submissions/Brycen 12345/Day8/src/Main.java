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
            int cnt = 0;
            while(in.hasNextLine()) {
                List<Integer> line = new ArrayList();
                String[] arr = in.nextLine().split("");
                for(int i = 0; i < arr.length; i++) {
                    line.add(Integer.parseInt(arr[i]));
                }
                forest.add(line);
            }
            for(int row = 0; row < forest.size(); row++) {
                for(int column = 0; column < forest.get(row).size(); column++) {
                    if(visible(forest, row, column)) {
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        } catch(Exception ex){
            System.out.println("error" + ex.getMessage());
        }
    }
    public static boolean visible(List<List<Integer>> forest, int startR, int startC) {
        boolean left = true;
        boolean right = true;
        boolean up = true;
        boolean down = true;
        if(startR == 0 || startC == 0 || startR == forest.size() - 1 || startC == forest.get(startR).size() - 1){
            return true;
        }
        for(int R = startR - 1; R >= 0; R--) {
            if(forest.get(R).get(startC) >= forest.get(startR).get(startC)) {
                left = false;
            }
        }
        for(int R = startR + 1; R < forest.size(); R++) {
            if(forest.get(R).get(startC) >= forest.get(startR).get(startC)) {
                right = false;
            }
        }
        for(int C = startC + 1; C < forest.get(0).size(); C++) {
            if(forest.get(startR).get(C) >= forest.get(startR).get(startC)) {
                up = false;
            }
        }
        for(int C = startC - 1; C >= 0; C--) {
            if(forest.get(startR).get(C) >= forest.get(startR).get(startC)) {
                down = false;
            }
        }
        if(left || right || up || down) {
            return true;
        } else {
            return false;
        }
    }
}