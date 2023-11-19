import java.io.File;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        final String fileName = "Day4/Data.txt";
        File input = new File(fileName);
        try {
            Scanner in = new Scanner(input);
            int[] arr = new int[4];
            int[] left = new int[2];
            int[] right = new int[2];
            int i = 0;
            int k = 0;
            int t = 0;
            int ans = 0;
            int index = 0;
            int smallR = 0;
            int bigL = 0;
            while(in.hasNextLine()) {
                String line = in.nextLine();
                String[] arrSplit = line.split(",");
                String num = arrSplit[i];
                String num2 = arrSplit[i + 1];
                String[] arrSplit2 = num.split("-");
                for(int j = 0; j < arrSplit2.length; j++) {
                    arr[j] = Integer.parseInt(arrSplit2[j]);
                    index = j + 1;
                }
                arrSplit2 = num2.split("-");

                for(int j = 0;  j < arrSplit2.length; j++) {
                    arr[index] = Integer.parseInt(arrSplit2[j]);
                    index++;
                }

                for (int j = 0; j < index; j = j+2){
                    left[t] = arr[j];
                    t++;
                }

                for (int j = 1; j < index; j = j+2){
                    right[k] = arr[j];
                    k++;
                }
                if(left[0] >= left[1]) {
                    bigL = left[0];
                    smallR = right[1];
                } else {
                    bigL = left[1];
                    smallR = right[0];
                }
                if(smallR >= bigL) {
                    ans++;
                }
                k = 0;
                t = 0;
            }
            System.out.println(ans);
        } catch(Exception ex){
            System.out.println("error" + ex.getMessage());
        }
    }
}