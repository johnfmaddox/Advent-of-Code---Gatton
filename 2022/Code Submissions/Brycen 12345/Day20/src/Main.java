import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day20/Data.txt";
        File input = new File(fileName);
        ArrayList<Data> original = new ArrayList<>();
        ArrayList<Data> working = new ArrayList<>();
        try{
            Scanner in = new Scanner(input);
            int index  = 0;
            int zeroPos = 0;
            while(in.hasNextLine()) {
                int num = Integer.parseInt(in.nextLine());
                Data data = new Data(num, index);
                original.add(data);
                working.add(data);
                if(num == 0) {
                    zeroPos = index;
                }
                index++;
            }
            Data zero = new Data(0, zeroPos);
            for(Data temp : original) {
                int pos = working.indexOf(temp);
                int val = temp.getValue() + pos;
                working.remove(pos);
                int to = move(val, working.size());
                working.add(to, temp);
            }
            int start = working.indexOf(zero);
            int ans = 0;
            int at1000 = working.get(move(start + 1000, working.size())).getValue();
            int at2000 = working.get(move(start + 2000, working.size())).getValue();
            int at3000 = working.get(move(start + 3000, working.size())).getValue();
            ans = at1000 + at2000 + at3000;
            System.out.println(ans);

        }
        catch(Exception ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

    public static int move(int value , int size) {
        int mod = value % size;
        if(mod < 0) {
            mod = mod + size;
        }
        if(mod == 0) {
            mod = size;
        } else if (mod == size) {
            mod = 0;
        }
        return mod;
    }
}

class Data{
    int value;
    int index;

    public Data(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;
        Data data = (Data) o;
        return getValue() == data.getValue() && getIndex() == data.getIndex();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getIndex());
    }
}