import javax.sql.PooledConnection;
import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day14/Data.txt";
        File input = new File(fileName);
        try{
            Scanner in = new Scanner(input);
            HashSet<Point> objects = new HashSet<>();
            Point Right = new Point(1, 0);
            Point Left = new Point(-1, 0);
            Point Up = new Point(0, -1);
            Point Down = new Point(0, 1);
            Point DownLeft = new Point(-1,1);
            Point DownRight = new Point(1,1);
            HashMap<String, Point> directions = new HashMap<>();
            directions.put("Right", Right);
            directions.put("Left", Left);
            directions.put("Up", Up);
            directions.put("Down", Down);
            directions.put("DownLeft" , DownLeft);
            directions.put("DownRight" , DownRight);
            while(in.hasNextLine()) {
                String line = in.nextLine();
                String[] arr = line.split(" -> ");
                for(int i = 0; i < arr.length - 1; i++) {
                    String[] PointOne = arr[i].split(",");
                    String[] PointTwo = arr[i + 1].split(",");
                    int x1 = Integer.parseInt(PointOne[0]);
                    int y1 = Integer.parseInt(PointOne[1]);
                    int x2 = Integer.parseInt(PointTwo[0]);
                    int y2 = Integer.parseInt(PointTwo[1]);
                    //System.out.println(x1 + "," + y1 + " " + x2 + "," + y2);
                    if(x1 > x2) {
                        x1 = x1 - x2;
                        x2 = x1 + x2;
                        x1 = x2 - x1;
                    }
                    if(y1 > y2) {
                        y1 = y1 - y2;
                        y2 = y1 + y2;
                        y1 = y2 - y1;
                    }
                    //add horizontals and verticals
                    if(y1 == y2) {
                        for(int j = x1; j <= x2; j++) {
                            objects.add(new Point(j,y1));
                        }
                    } else if(x1 == x2) {
                        for(int j = y1; j <= y2; j++) {
                            objects.add(new Point(x1,j));
                        }
                    }
                    //System.out.println(x1 + "," + y1 + " " + x2 + "," + y2);
                }
            }
            //once something goes below the lowest y value it is in the void
            int lowest = Integer.MIN_VALUE;
            for(Point p : objects) {
                if(p.getY() > lowest) {
                    lowest = p.getY();
                }
            }
            //System.out.println(lowest);
            long grains = 0;

            Point sand = new Point(500,0);
            do{
                Point D = sand.add(directions.get("Down"));
                Point DL = sand.add(directions.get("DownLeft"));
                Point DR = sand.add(directions.get("DownRight"));
                if(!objects.contains(D)) {
                    sand = D;
                } else if(!objects.contains(DL)) {
                    sand = DL;
                } else if(!objects.contains(DR)) {
                    sand = DR;
                } else {
                    objects.add(sand);
                    sand = new Point(500,0);
                    grains++;
                }
            } while(sand.getY() < lowest);

            System.out.println(grains);
        }
        catch(Exception ex) {
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
