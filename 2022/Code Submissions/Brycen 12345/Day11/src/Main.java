import java.io.File;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day11Part2/Data.txt";
        File input = new File(fileName);
        try {
            Scanner in = new Scanner(input);
            List<Long> cnts = new ArrayList<Long>();
            List<Monkey> monkeys = new ArrayList<Monkey>();
            String line = "";
            String name = "";
            String op = "";
            int test = 0;
            String whereT = "";
            String whereF = "";
            while (in.hasNext()) {
                line = in.nextLine();
                name = "";
                op = "";
                test = 0;
                whereT = "";
                whereF = "";
                List<Long> items = new ArrayList<Long>();
                do {
                    String[] arr = line.split(" ");
                    if (arr[0].equals("Monkey")) {
                        name = arr[1];
                    } else if (arr[2].equals("Operation:")) {
                        for (int i = 3; i < arr.length; i++) {
                            op += arr[i] + " ";
                        }
                    } else if (arr[2].equals("Test:")) {
                        test = Integer.parseInt(arr[arr.length - 1]);
                    } else if (arr[4].equals("If") && arr[5].equals("true:")) {
                        whereT = arr[arr.length - 1] + ":";
                    } else if (arr[4].equals("If") && arr[5].equals("false:")) {
                        whereF = arr[arr.length - 1] + ":";
                    } else {
                        String[] arr3 = new String[arr.length - 4];
                        int start = 4;
                        for (int i = 0; i < arr3.length; i++) {
                            arr3[i] = arr[start];
                            start++;
                        }
                        for (String temp : arr3) {
                            String[] arr2 = temp.split(",");
                            long item = Long.parseLong(arr2[0]);
                            items.add(item);
                        }
                    }
                    line = in.nextLine();
                } while (!line.equals(""));
                Monkey m = new Monkey(name, op, test, whereT, whereF, items);
                monkeys.add(m);
                //m.getItems();
                //System.out.println(name + " " + op + test + " " + whereT + " " + whereF);
            }
            List<Integer> tests = new ArrayList<Integer>();
            for (Monkey donkey : monkeys) {
                tests.add(donkey.getTest());
            }
            for (int j = 0; j < 20; j++) {
                for (Monkey kong : monkeys) {
                    int loop = kong.len();
                    for (int i = 0; i < loop; i++) {
                        if (kong.len() == 0) {
                            continue;
                        }
                        while (kong.len() > 0) {
                            long worry = kong.getItem();
                            kong.addCnt();
                            kong.remove();
                            String tar = "";
                            worry = kong.opp(worry);
                            worry = worry / 3;
                            tar = kong.testing(worry);
                            Monkey target = getTar(tar, monkeys);
                            target.addItem(worry);
                        }
                    }
                }
            }
            for (Monkey king : monkeys) {
                //king.getItems();
                long cnt = king.getCnt();
                //System.out.println(king.getName() + cnt);
                cnts.add(cnt);

            }
            Collections.sort(cnts, Collections.reverseOrder());
            long ans = 1;
            for (int i = 0; i < 2; i++) {
                //System.out.println(cnts.get(i));
                ans *= cnts.get(i);
            }
            System.out.println(ans);
        }
        catch(Exception ex) {
            System.out.println("error");
        }
    }
    public static Monkey getTar(String name, List<Monkey> all) {
        for (Monkey temp : all) {
            if (temp.getName().equals(name)) {
                return temp;
            }
        }
        return null;
    }
}