package Utilities.General;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class GetInputs {
    int day = 0;
    String file = "";
    Scanner stdin;

    public GetInputs(int day) throws FileNotFoundException {
        this.day = day;
        file =  "C:\\Users\\nkh15448\\IdeaProjects\\AdventOfCode\\src\\inputs" + "\\input" + day + ".txt";
        stdin = new Scanner(new File(file));
    }

    public boolean hasLines() throws FileNotFoundException {
        return stdin.hasNextLine();
    }
    public String nextLine(){
        return stdin.nextLine();
    }
    public int nextInt(){
        return stdin.nextInt();
    }
    public String next(){
        return stdin.next();
    }
    public long nextLong(){
        return stdin.nextLong();
    }
    public double nextDouble(){
        return stdin.nextDouble();
    }

    public String wholeFile(){
        String result = "";
        while(stdin.hasNextLine()){

            result += stdin.nextLine();
            if(!(stdin.hasNextLine())){
                result += "\n";
            }
        }
        return result;
    }
    public ArrayList<String> filetoArrayList(){
        ArrayList<String> result = new ArrayList<String>();
        while(stdin.hasNextLine()){
            result.add(stdin.nextLine());
        }
        return result;
    }
    public String[] filetoArray(){
        ArrayList<String> result = new ArrayList<String>();
        while(stdin.hasNextLine()){
            result.add(stdin.nextLine());
        }
        String[] retrn = new String[result.size()];
        for(int i = 0; i < result.size(); i++){
            retrn[i] = result.get(i);
        }
        return retrn;
    }


}
