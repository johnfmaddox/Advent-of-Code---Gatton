package Day14;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Day14_2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner stdin = new Scanner(new File("C:\\Users\\leviw\\Desktop\\AdventOfCode\\Day14\\input"));
        ArrayList<Cord> cords = new ArrayList<Cord>();
        int leastY = 0;
        int leastX = Integer.MAX_VALUE;
        int mostX = 0;

        while (stdin.hasNextLine()) {
            String line = stdin.nextLine();

            String[] instruction = line.split(" -> ");
            String[] s = instruction[0].split(",");
            Cord start = new Cord(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            cords.add(start);

            for (int i = 1; i < instruction.length; i++) {

                String[] e = instruction[i].split(",");
                Cord end = new Cord(Integer.parseInt(e[0]), Integer.parseInt(e[1]));
                cords.add(end);
                int x1 = start.getX();
                int x2 = end.getX();
                leastX = Math.min(leastX, x1);
                mostX = Math.max(mostX, x1);
                leastX = Math.min(leastX, x2);
                mostX = Math.max(mostX, x2);
                int y1 = start.getY();
                if (y1 > leastY) {
                    leastY = y1;
                }
                int y2 = end.getY();
                if (y2 > leastY) {
                    leastY = y2;
                }

                if (x1 == x2) {
                    for (int j = 1; j < Math.abs(y1 - y2); j++) {
                        Cord mid = new Cord(x1, Math.min(y1, y2) + j);
                        cords.add(mid);
                    }
                } else {
                    for (int j = 1; j < Math.abs(x1 - x2); j++) {
                        Cord mid = new Cord(Math.min(x1, x2) + j, y1);
                        cords.add(mid);
                    }

                }
                start = end;
            }
        }
        leastY += 1;
        System.out.println(leastY);

        int cnt = 0;
        boolean stop = false;
        while (!stop) {
            Cord sand = new Cord(500, 0);
            while (true) {
                Cord test = new Cord(sand.getX(), sand.getY() + 1);

                if (!has(cords, test)) {

                    sand = test;
                    if (test.getY() == leastY) {
                        cnt++;
                        cords.add(test);
                        break;
                    }
                    continue;
                }
                test = new Cord(sand.getX() - 1, sand.getY() + 1);

                if (!has(cords, test)) {
                    sand = test;
                    if (test.getY() == leastY) {
                        cnt++;
                        cords.add(test);
                        break;
                    }
                    continue;
                }
                test = new Cord(sand.getX() + 1, sand.getY() + 1);

                if (!has(cords, test)) {
                    sand = test;
                    if (test.getY() == leastY) {
                        cnt++;
                        cords.add(test);
                        break;
                    }
                    continue;

                }
                if (test.getY() == 0) {
                    cnt++;
                    stop = true;
                    break;
                } else {
                    cords.add(sand);
                    cnt++;
                    break;
                }
            }
            if (sand.getX() == 500 && sand.getY() == 0) {
                stop = true;
            }
        }
        System.out.println(cnt);
        System.out.println(cords.size());

    }

    public static boolean has(ArrayList<Cord> cords, Cord c) {
        int x = c.getX();
        int y = c.getY();

        for (int i = 0; i < cords.size(); i++) {
            Cord test = cords.get(i);
            if (test.getX() == x && test.getY() == y) {
                return true;
            }
        }
        return false;
    }
}
