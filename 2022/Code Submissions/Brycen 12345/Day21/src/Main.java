import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day21/Data.txt";
        File input = new File(fileName);
        HashMap<String, Monkey> monkeyMap = new HashMap<>();
        try{
            Scanner in = new Scanner(input);
            while(in.hasNextLine()) {
                String line = in.nextLine();
                String[] arr = line.split(" ");
                String name = arr[0].substring(0,4);
                if(arr.length == 2) {
                    monkeyMap.put(name, new Monkey(name, Long.parseLong(arr[1])));
                } else  {
                    monkeyMap.put(name, new Monkey(name, arr[1], arr[2], arr[3]));
                }
                //System.out.println(name + Arrays.toString(arr));
            }
            long ans = monkeyMap.get("root").calculations(monkeyMap);
            System.out.println(ans);
        }
        catch(Exception ex) {
            System.out.println("error");
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