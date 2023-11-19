import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        List<String> moves = new ArrayList<String>();
        final String fileName = "Day9/Data.txt";
        File input = new File(fileName);
        try{
            Scanner in = new Scanner(input);
            while(in.hasNextLine()) {
                String line = in.nextLine();
                moves.add(line);
            }
        }
        catch(Exception ex) {
            System.out.println("error");
        }
        HashSet<Point> tailPositions = new HashSet<Point>();
        Point Right = new Point(1, 0);
        Point Left = new Point(-1, 0);
        Point Up = new Point(0, 1);
        Point Down = new Point(0, -1);
        Point Head = new Point(0, 0);
        Point Tail = new Point(0, 0);
        Point Start = new Point(0, 0);
        HashMap<String, Point> directions = new HashMap<>();
        directions.put("R", Right);
        directions.put("L", Left);
        directions.put("U", Up);
        directions.put("D", Down);
        directions.put("S", Start);
        moves.add("S 1");

        for(String str : moves) {
            String[] arr = str.split(" ");
            String dir = arr[0];
            int dis = Integer.parseInt(arr[1]);
            Point move = directions.get(dir);
            for(int i = 0; i < dis; i++) {
                Head = Head.add(move);
                Tail = follow(Head, Tail);
                tailPositions.add(Tail);
                //System.out.println(Tail.getX() + " " + Tail.getY());
            }
        }

        System.out.println(tailPositions.size());
    }

    public static Point follow(Point Head, Point Tail) {
        Point dif = Head.sub(Tail);
        int difX = dif.getX();
        int difY = dif.getY();
        Point move = new Point(0,0);
        if(difX == 0 && difY == 0) {
            return Tail;
        }
        if(Math.abs(difX) > 1) {
            move = new Point(Integer.signum(difX), Integer.signum(difY));
            Tail = Tail.add(move);
            return Tail;
        } else if(Math.abs(difY) > 1) {
            move = new Point(Integer.signum(difX), Integer.signum(difY));
            Tail = Tail.add(move);
            return Tail;
        } else {
            return Tail;
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