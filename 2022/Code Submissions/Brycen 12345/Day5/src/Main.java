import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        final String fileName = "Day5/Data.txt";
        File input = new File(fileName);
        try {
            Scanner in = new Scanner(input);
            String line = "";
            for(int i = 0; i < 9; i++) {
                line = in.nextLine();
            }
            ArrayList<String> one = new ArrayList<String>(9);
            one.add("F");
            one.add("H");
            one.add("B");
            one.add("V");
            one.add("R");
            one.add("Q");
            one.add("D");
            one.add("P");
            //System.out.println(one);
            ArrayList<String> two = new ArrayList<String>(9);
            two.add("L");
            two.add("D");
            two.add("Z");
            two.add("Q");
            two.add("W");
            two.add("V");
            //System.out.println(two);
            ArrayList<String> three = new ArrayList<String>(9);
            three.add("H");
            three.add("L");
            three.add("Z");
            three.add("Q");
            three.add("G");
            three.add("R");
            three.add("P");
            three.add("C");
            //System.out.println(three);
            ArrayList<String> four = new ArrayList<String>(9);
            four.add("R");
            four.add("D");
            four.add("H");
            four.add("F");
            four.add("J");
            four.add("V");
            four.add("B");
            //System.out.println(four);
            ArrayList<String> five = new ArrayList<String>(9);
            five.add("Z");
            five.add("W");
            five.add("L");
            five.add("C");
            //System.out.println(five);
            ArrayList<String> six = new ArrayList<String>(9);
            six.add("J");
            six.add("R");
            six.add("P");
            six.add("N");
            six.add("T");
            six.add("G");
            six.add("V");
            six.add("M");
            //System.out.println(six);
            ArrayList<String> seven = new ArrayList<String>(9);
            seven.add("J");
            seven.add("R");
            seven.add("L");
            seven.add("V");
            seven.add("M");
            seven.add("B");
            seven.add("S");
            //System.out.println(seven);
            ArrayList<String> eight = new ArrayList<String>(9);
            eight.add("D");
            eight.add("P");
            eight.add("J");
            //System.out.println(eight);
            ArrayList<String> nine = new ArrayList<String>(9);
            nine.add("D");
            nine.add("C");
            nine.add("N");
            nine.add("W");
            nine.add("V");
            //System.out.println(nine);
            int numToMove = 0;
            int from = 0;
            int to = 0;
            String word1 = "";
            String word2 = "";
            String word3 = "";

            HashMap<Integer, ArrayList<String>> numbers = new HashMap<>();
            numbers.put(1, one);
            numbers.put(2, two);
            numbers.put(3, three);
            numbers.put(4, four);
            numbers.put(5, five);
            numbers.put(6, six);
            numbers.put(7, seven);
            numbers.put(8, eight);
            numbers.put(9, nine);
            ArrayList<String> add = new ArrayList<>();
            while(in.hasNextLine()) {
                word1 = in.next();
                numToMove = Integer.parseInt(in.next());
                word2 = in.next();
                from = Integer.parseInt(in.next());
                word3 = in.next();
                to = Integer.parseInt(in.next());

                String top = "";
                int size = 0;
                int index = 0;
                for(int i = 0; i < numToMove; i++) {
                    add = numbers.get(from);
                    size = add.size();
                    top = add.get(size - 1);
                    numbers.get(to).add(top);
                    index = numbers.get(from).size() - 1;
                    numbers.get(from).remove(index);
                }
            }
            String ans = "";
            for(int i = 1; i <= 9; i++) {
                ArrayList<String> temp = numbers.get(i);
                ans += temp.get(temp.size() - 1) + " ";
            }
            System.out.println(ans);
        } catch(Exception ex){
            System.out.println("error" + ex.getMessage());
        }
    }
}