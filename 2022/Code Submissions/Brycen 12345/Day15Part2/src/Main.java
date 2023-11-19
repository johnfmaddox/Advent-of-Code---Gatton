import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day15Part2/Data.txt";
        File input = new File(fileName);
        try {
            Scanner in = new Scanner(input);
            HashMap<Point, Point> pairs = new HashMap<>();
            HashSet<Point> both = new HashSet<>();
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] parts = line.split(":");
                String sensorOne = parts[0];
                String[] sensor = sensorOne.split(", ");
                String beaconOne = parts[1];
                String[] beacon = beaconOne.split(", ");
                //x values
                String[] sensorVal = sensor[0].split(" ");
                String[] sensorXval = sensorVal[2].split("=");
                long sensorX = Long.parseLong(sensorXval[1]);
                //System.out.println(sensorX);
                String[] beaconVal = beacon[0].split(" ");
                String[] beaconXval = beaconVal[5].split("=");
                long beaconX = Long.parseLong(beaconXval[1]);
                //System.out.println(beaconX);
                //y values
                String[] sensorYval = sensor[1].split("=");
                long sensorY = Long.parseLong(sensorYval[1]);
                //System.out.println(sensorY);
                String[] beaconYval = beacon[1].split("=");
                long beaconY = Long.parseLong(beaconYval[1]);
                Point Sensor = new Point(sensorX, sensorY);
                Point Beacon = new Point(beaconX, beaconY);
                both.add(Sensor);
                both.add(Beacon);
                pairs.put(Sensor, Beacon);
            }
            long ans;
            for(Map.Entry<Point, Point> curr : pairs.entrySet()) {
                Point sensor = curr.getKey();
                Point beacon = curr.getValue();
                long dis = mDis(sensor, beacon);
                Point start = new Point(sensor.getX(), (sensor.getY() - dis) - 1);
                ans = perimeter(start, dis, both, pairs);
                if(ans != -1) {
                    System.out.println(ans);
                    break;
                }
            }
            System.out.println();

        }
        catch(Exception ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
    public static long mDis (Point one, Point two) {
        return Math.abs(one.getX() - two.getX()) + Math.abs(one.getY() - two.getY());
    }
    public static long perimeter(Point start, long dis, HashSet<Point> both, HashMap<Point, Point> pairs) {
        Point UpL = new Point(-1, -1);
        Point UpR = new Point(1, -1);
        Point DownLeft = new Point(-1, 1);
        Point DownRight = new Point(1, 1);
        HashMap<String, Point> directions = new HashMap<>();
        directions.put("UpR", UpL);
        directions.put("UpL", UpR);
        directions.put("DL", DownLeft);
        directions.put("DR", DownRight);
        long ans = 0;
        long length = dis + 1;
        for(int j = 0; j < length; j++) {
            start = start.add(directions.get("DR"));
            if(!impossible(start, both, pairs)) {
                ans = (start.getX() * 4000000) + start.getY();
                return ans;
            }
        }
        for(int j = 0; j < length; j++) {
            start = start.add(directions.get("DL"));
            if(!impossible(start, both, pairs)) {
                ans = (start.getX() * 4000000) + start.getY();
                return ans;
            }
        }
        for(int j = 0; j < length; j++) {
            start = start.add(directions.get("UpL"));
            if(!impossible(start, both, pairs)) {
                ans = (start.getX() * 4000000) + start.getY();
                return ans;
            }
        }
        for(int j = 0; j < length; j++) {
            start = start.add(directions.get("UpR"));
            if(!impossible(start, both, pairs)) {
                ans = (start.getX() * 4000000) + start.getY();
                return ans;
            }
        }
        return -1;

    }
    public static boolean impossible(Point check, HashSet<Point> all, HashMap<Point, Point> ap) {
        if(check.getY() < 0 || check.getY() > 4000000 || check.getX() < 0 || check.getX() > 4000000) {
            return true;
        }
        if(all.contains(check)){
            return true;
        }
        for(Map.Entry<Point,Point> temp : ap.entrySet()) {
            Point sensor = temp.getKey();
            Point beacon = temp.getValue();
            long disOne = mDis(sensor, beacon);
            long disTwo = mDis(sensor, check);
            if(disTwo <= disOne) {
                return true;
            }
        }
        return false;
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

    private long x;
    private long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return this.x;
    }

    public long getY() {
        return this.y;
    }

    public Point add(Point other) {
        long X = this.x + other.x;
        long Y = this.y + other.y;
        Point ans = new Point(X , Y);
        return ans;
    }

}