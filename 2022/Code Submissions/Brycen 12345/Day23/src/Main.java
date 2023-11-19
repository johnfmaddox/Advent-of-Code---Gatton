import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day23/Data.txt";
        File input = new File(fileName);
        try {
            Scanner in = new Scanner(input);
            Point test = new Point(0,0);
            HashSet<Point> ans = new HashSet<>();
            ans = test.getAll();
            for(Point p : ans) {
                System.out.println(p.getX() + " " + p.getY());
            }
            while(in.hasNextLine()) {

            }
        } catch(Exception ex){
            System.out.println("error" + ex.getMessage());
        }
    }
}
class Point {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return getX() == point.getX() && getY() == point.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    private int x;
    private int y;
    private final static int N = 0;
    private final static int S = 1;
    private final static int W = 2;
    private final static int E = 3;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public HashSet<Point> getAll() {
        HashSet<Point> all = new HashSet<>();
        all.addAll(getNorth());
        all.addAll(getSouth());
        all.addAll(getWest());
        all.addAll(getEast());
        return all;
    }
    public HashSet<Point> getNorth() {
        HashSet<Point> north = new HashSet<>();
        north.add(new Point(x, y - 1));
        north.add(new Point(x - 1, y - 1));
        north.add(new Point(x + 1, y - 1));
        return north;
    }
    public HashSet<Point> getSouth() {
        HashSet<Point> south = new HashSet<>();
        south.add(new Point(x, y + 1));
        south.add(new Point(x - 1, y + 1));
        south.add(new Point(x + 1, y + 1));
        return south;
    }
    public HashSet<Point> getWest() {
        HashSet<Point> west = new HashSet<>();
        west.add(new Point(x - 1, y));
        west.add(new Point(x - 1, y - 1));
        west.add(new Point(x - 1, y + 1));
        return west;
    }
    public HashSet<Point> getEast() {
        HashSet<Point> east = new HashSet<>();
        east.add(new Point(x + 1, y));
        east.add(new Point(x + 1, y - 1));
        east.add(new Point(x + 1, y + 1));
        return east;
    }


        public Point add(Point other) {
        int X = this.x + other.x;
        int Y = this.y + other.y;
        Point ans = new Point(X , Y);
        return ans;
    }

    public Point sub(Point other) {
        int X = this.x - other.x;
        int Y = this.y - other.y;
        Point ans = new Point(X , Y);
        return ans;
    }
}