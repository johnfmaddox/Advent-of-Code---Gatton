import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day18/Data.txt";
        File input = new File(fileName);
        try{
            Scanner in = new Scanner(input);
            List<Cube> cubes = new ArrayList<>();
            while(in.hasNextLine()) {
                String line = in.nextLine();
                String[] arr = line.split(",");
                int x = Integer.parseInt(arr[0]);
                int y = Integer.parseInt(arr[1]);
                int z = Integer.parseInt(arr[2]);
                Cube c = new Cube(x, y, z);
                cubes.add(c);
            }
            int covered = 0;
            for(Cube temp : cubes) {
                for(int i = 0; i < cubes.size();i++) {
                    if(temp.adjacent(cubes.get(i))) {
                        covered++;
                    }
                }
            }
            int total = 6 * cubes.size();
            int ans = total - covered;
            System.out.println(ans);
        }
        catch(Exception ex) {
            System.out.println("error");
        }
    }
}
class Cube{
    int x;
    int y;
    int z;
    public Cube(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean adjacent(Cube other){
        if(this.x == other.x && this.y == other.y && this.z == other.z) {
            return false;
        }
        if(this.x == other.x && this.y == other.y && Math.abs(this.z - other.z) == 1) {
            return true;
        }
        if(this.x == other.x && this.z == other.z && Math.abs(this.y - other.y) == 1) {
            return true;
        }
        if(this.y == other.y && this.z == other.z && Math.abs(this.x - other.x) == 1) {
            return true;
        }
        return false;
    }
}