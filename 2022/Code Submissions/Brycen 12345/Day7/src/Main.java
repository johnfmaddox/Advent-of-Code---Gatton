import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day7/Data.txt";
        File input = new File(fileName);
        Directory root = new Directory("/", null);
        Directory current = null;
        ArrayList<Directory> all = new ArrayList<Directory>();

        try{
            Scanner in = new Scanner(input);
            while(in.hasNextLine()) {
                String line = in.nextLine();
                String name = "";
                if (line.equals("$ cd /")) {
                    current = root;
                    all.add(current);
                } else if (line.equals("$ cd ..")) {
                    current = current.getParent();
                } else if (line.equals("$ ls")) {
                    System.out.print("");
                } else if (line.charAt(0) == 'd' && line.charAt(1) == 'i' && line.charAt(2) == 'r') {
                    for (int i = 4; i < line.length(); i++) {
                        name += line.charAt(i);
                    }
                    current.addChild(name, current);
                } else if ((line.charAt(0) == '$' && line.charAt(2) == 'c') && (line.charAt(5) != '/' && line.charAt(5) != '.')) {
                    for (int i = 5; i < line.length(); i++) {
                        name += line.charAt(i);
                    }
                    current = current.getCurr(name);
                    all.add(current);
                } else {
                    String arr[] = line.split(" ");
                    long size = Integer.parseInt(arr[0]);
                    name = arr[1];
                    current.addFile(name, size);

                }
            }
        }
        catch(Exception ex) {
            System.out.println("error " + ex.getMessage());
        }
        long count = 0;
        for(Directory dir : all) {
            long size = dir.size();
            //System.out.println(dir.getDirName() + " " + size);
            if(size < 100000) {
                count += dir.size();
            }
        }
        System.out.println(count);
    }
}