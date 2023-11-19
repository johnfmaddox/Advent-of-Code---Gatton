import java.util.*;

public class Monkey {
    private String name;
    private List<Long> items = new ArrayList<Long>();
    private String ifT;
    private String ifF;
    private String operation;
    private int Test;
    private long cnt;

    public Monkey(String name, String operation, int test, String ifT, String ifF, List item) {
        this.name = name;
        this.operation = operation;
        this.Test = test;
        this.ifT = ifT;
        this.ifF = ifF;
        this.items = item;
    }

    public long opp(long old) {
        String[] arr = this.operation.split(" ");
        long ans = 0;
        if (arr[3].equals("+")) {
            int add = Integer.parseInt(arr[4]);
            ans = old + add;
        } else if (arr[3].equals("*") && !(arr[4].equals("old"))) {
            int mult = Integer.parseInt(arr[4]);
            ans = mult * old;
        } else {
            ans = old * old;
        }
        return ans;
    }

    public String testing(long worry) {
        if(worry % this.Test == 0) {
            return ifT;
        } else {
            return ifF;
        }
    }
    public void addItem(long worry) {
        this.items.add(worry);
    }
    public void remove() {
        this.items.remove(0);
    }
    public long getItem() {
        return this.items.get(0);
    }
    public String getName() {
        return this.name;
    }
    public void addCnt() {
        this.cnt = cnt + 1;
    }
    public long getCnt() {
        return this.cnt;
    }
    public int len(){
        return this.items.size();
    }
    public void getItems() {
        for (long t : items) {
            System.out.println(t);
        }
    }
    public int getTest() {
        return this.Test;
    }
}
