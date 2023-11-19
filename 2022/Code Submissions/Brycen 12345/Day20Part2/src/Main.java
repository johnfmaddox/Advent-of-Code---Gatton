import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

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
            long key = 811589153;
            while(in.hasNextLine()) {
                long num = Integer.parseInt(in.nextLine()) * key;
                Data data = new Data(num, index);
                original.add(data);
                working.add(data);
                if(num == 0) {
                    zeroPos = index;
                }
                index++;
            }
            for(int i = 0; i < 10; i++) {
                shuffle(original, working);
            }
            /*
            for(Data t : original) {
                System.out.print(t.value + " ");
            }
            System.out.println();
             */
            Data zero = new Data(0, zeroPos);
            //System.out.println(working.indexOf(zero));
            int start = working.indexOf(zero);
            long ans = 0;
            long at1000 = working.get((int) move(start + 1000, working.size())).getValue();
            long at2000 = working.get((int) move(start + 2000, working.size())).getValue();
            long at3000 = working.get((int) move(start + 3000, working.size())).getValue();
            ans = at1000 + at2000 + at3000;
            System.out.println(ans);

        }
        catch(Exception ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

    public static long move(long value , int size) {
        long mod = value % size;
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

    public static void shuffle(ArrayList<Data> original, ArrayList<Data> working) {
        for(Data temp : original) {
            int pos = working.indexOf(temp);
            long val = temp.getValue() + pos;
            working.remove(pos);
            int to = (int) move(val, working.size());
            working.add(to, temp);
        }
    }
}

class Data{
    long value;
    int index;

    public Data(long value, int index) {
        this.value = value;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public long getValue() {
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