import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day21/Data.txt";
        File input = new File(fileName);
        HashMap<String, Monkey> monkeyMap = new HashMap<>();
        try{
            Scanner in = new Scanner(input);
            String rootLeft = "";
            String rootRight = "";
            while(in.hasNextLine()) {
                String line = in.nextLine();
                String[] arr = line.split(" ");
                String name = arr[0].substring(0,4);
                if(name.equals("root")) {
                    rootLeft = arr[1];
                    rootRight = arr[3];
                }
                if(arr.length == 2) {
                    monkeyMap.put(name, new Monkey(name, Long.parseLong(arr[1])));
                } else  {
                    monkeyMap.put(name, new Monkey(name, arr[1], arr[2], arr[3]));
                }
                //System.out.println(name + Arrays.toString(arr));
            }
            String known = "";
            String unknown = "";
            if(contains(monkeyMap.get(rootLeft), "humn", monkeyMap)) {
                known = rootRight;
                unknown = rootLeft;
            } else {
                known = rootLeft;
                unknown = rootRight;
            }

            long calculated = monkeyMap.get(known).calculations(monkeyMap);
            Monkey curr = monkeyMap.get(unknown);
            while(!curr.name.equals("humn")) {
                Monkey left = monkeyMap.get(curr.left);
                Monkey right = monkeyMap.get(curr.right);
                if (contains(left, "humn", monkeyMap)) {
                    switch (curr.operator) {
                        case "+":
                            calculated -= right.calculations(monkeyMap);
                            break;
                        case "-":
                            calculated += right.calculations(monkeyMap);
                            break;
                        case "*":
                            calculated /= right.calculations(monkeyMap);
                            break;
                        case "/":
                            calculated *= right.calculations(monkeyMap);
                    }
                    curr = left;
                } else {
                    switch (curr.operator) {
                        case "+":
                            calculated -= left.calculations(monkeyMap);
                            break;
                        case "-":
                            calculated = left.calculations(monkeyMap) - calculated;
                            break;
                        case "*":
                            calculated /= left.calculations(monkeyMap);
                            break;
                        case "/":
                            calculated *= left.calculations(monkeyMap);
                    }
                    curr = right;
                }
            }
            System.out.println(calculated);
        }
        catch(Exception ex) {
            System.out.println("error " + ex.getMessage());
        }
    }



    public static boolean contains(Monkey kong, String tar, HashMap<String, Monkey> monkeyMap) {
        if(kong.name.equals(tar)) {
            return true;
        }
        if(kong.left == null && kong.right == null) {
            return false;
        } else {
            return contains(monkeyMap.get(kong.left), tar, monkeyMap) || contains(monkeyMap.get(kong.right), tar, monkeyMap);
        }
    }
}

class Monkey{
    String name;
    String left;
    String right;
    long value;
    String operator;

    public Monkey(String name, long value){
        this.name = name;
        this.value = value;
        this.operator = "shout";
    }

    public Monkey(String name, String left, String op, String right) {
        this.name = name;
        this.left = left;
        this.right = right;
        this.operator = op;
    }

    public long calculations(HashMap<String, Monkey> monkeyMap) {
        if(operator.equals("shout")) {
            return value;
        }
        long LHS = monkeyMap.get(left).calculations(monkeyMap);
        long RHS = monkeyMap.get(right).calculations(monkeyMap);
        switch (operator) {
            case "+":
                return LHS + RHS;
            case "-":
                return LHS - RHS;
            case "*":
                return LHS * RHS;
            case "/":
                return LHS / RHS;
            default:
                return -1;
        }
    }
}