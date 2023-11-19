import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day13/Data13.txt";
        File input = new File(fileName);
        try {
            Scanner in = new Scanner(input);
            String line = "";
            int ans = 0;
            int indices = 1;
            while (in.hasNext()) {
                line = in.nextLine();
                Packet one = new Packet(line);
                line = in.nextLine();
                Packet two = new Packet(line);
                line = in.nextLine();
                if(one.comp(two) > 0) {
                    ans += indices;
                }
                indices++;
            }
            System.out.println(ans);
        }
        catch(Exception ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
}