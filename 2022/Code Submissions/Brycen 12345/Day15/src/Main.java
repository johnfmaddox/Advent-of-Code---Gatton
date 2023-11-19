import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day15/Data.txt";
        File input = new File(fileName);
        try {
            Scanner in = new Scanner(input);
            HashMap<Point, Point> pairs = new HashMap<>();
            HashSet<Point> both = new HashSet<>();
            Point Right = new Point(1, 0);
            Point Left = new Point(-1, 0);
            Point Up = new Point(0, -1);
            Point Down = new Point(0, 1);
            Point DownLeft = new Point(-1, 1);
            Point DownRight = new Point(1, 1);
            HashMap<String, Point> directions = new HashMap<>();
            directions.put("Right", Right);
            directions.put("Left", Left);
            directions.put("Up", Up);
            directions.put("Down", Down);
            directions.put("DownLeft", DownLeft);
            directions.put("DownRight", DownRight);
            long lowestX = Integer.MAX_VALUE;
            long highestX = Integer.MIN_VALUE;
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
                long lowestSB = Math.min(sensorX, beaconX);
                lowestX = Math.min(lowestX, lowestSB);
                long highestSB = Math.max(sensorX, beaconX);
                highestX = Math.max(highestX, highestSB);
                both.add(Sensor);
                both.add(Beacon);
                pairs.put(Sensor, Beacon);
            }
            int cnt = 0;
            for(long i = lowestX - 2000000; i <= highestX + 2000000; i++) {
                Point check = new Point(i, 2000000);
                if(!both.contains(check)) {
                    for(Map.Entry<Point,Point> temp : pairs.entrySet()) {
                        Point sensor = temp.getKey();
                        Point beacon = temp.getValue();
                        long disOne = mDis(sensor, beacon);
                        long disTwo = mDis(sensor, check);
                        if(disTwo <= disOne) {
                            cnt++;
                            break;
                        }
                    }
                }
            }
            System.out.println(cnt);

        }
        catch(Exception ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
    public static long mDis (Point one, Point two) {
        return Math.abs(one.getX() - two.getX()) + Math.abs(one.getY() - two.getY());
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

}