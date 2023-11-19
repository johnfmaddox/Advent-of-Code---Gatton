import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day18Part2/Data.txt";
        File input = new File(fileName);
        try{
            Scanner in = new Scanner(input);
            HashSet<Cube> lava = new HashSet<>();
            HashSet<Cube> air = new HashSet<>();
            //List<Cube> test = new ArrayList<>();
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            int minZ = Integer.MAX_VALUE;
            while(in.hasNextLine()) {
                String line = in.nextLine();
                String[] arr = line.split(",");
                int x = Integer.parseInt(arr[0]);
                int y = Integer.parseInt(arr[1]);
                int z = Integer.parseInt(arr[2]);
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                minZ = Math.min(minZ, z);
                Cube c = new Cube(x, y, z);
                lava.add(c);
                //test.add(c);
            }
            Cube min = new Cube(minX, minY, minZ);
            Cube start = null;
            if(!lava.contains(min)) {
                start = min;
            } else {
                for(Cube c : min.allAdjacent()) {
                    if(!lava.contains(c)){
                        start = c;
                        break;
                    }
                }
            }
            Queue<Cube> queue = new LinkedList<>();
            queue.add(start);
            while(!queue.isEmpty()) {
                Cube curr = queue.poll();
                air.add(curr);
                for(Cube adj : curr.allAdjacent()) {
                    if(lava.contains(adj) || air.contains(adj) || queue.contains(adj)) {
                        continue;
                    }
                    if(outOfBounds(adj, lava)) {
                        continue;
                    }
                    queue.add(adj);
                }
            }
            int ans = 0;
            for(Cube airCube : air) {
                for(Cube adj : airCube.allAdjacent()) {
                    if(lava.contains(adj)) {
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
        catch(Exception ex) {
            System.out.println("error");
        }
    }
    public static boolean outOfBounds(Cube c, HashSet<Cube> all) {
        List<Double> dis = new ArrayList<>();
        for(Cube test : all) {
            dis.add(c.dis(test));
        }
        Collections.sort(dis);
        //System.out.println(dis.get(0));
        //System.out.println(dis);
        if(dis.get(0) > 8){
            return true;
        }
        return false;
    }
}
class Cube{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cube)) return false;
        Cube cube = (Cube) o;
        return x == cube.x && y == cube.y && z == cube.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "Cube{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

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
    public ArrayList<Cube> allAdjacent() {
        ArrayList<Cube> adjacent = new ArrayList<>();
        int x = this.x;
        int y = this.y;
        int z = this.z;
        adjacent.add(new Cube(x + 1, y, z));
        adjacent.add(new Cube(x - 1, y, z));
        adjacent.add(new Cube(x, y + 1, z));
        adjacent.add(new Cube(x, y - 1, z));
        adjacent.add(new Cube(x, y, z + 1));
        adjacent.add(new Cube(x, y, z - 1));
        return adjacent;
    }

    public double dis(Cube other) {
        return Math.sqrt((this.x - other.x)*(this.x - other.x) + (this.y - other.y)*(this.y - other.y) + (this.z - other.z)*(this.z - other.z));
    }
}