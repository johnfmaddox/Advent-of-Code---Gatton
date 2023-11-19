package Day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day15 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner stdin = new Scanner(new File("C:\\Users\\leviw\\Day15\\input"));

        ArrayList<Cord> cords = new ArrayList<Cord>();
        ArrayList<Cord> becs = new ArrayList<Cord>();
        while (stdin.hasNextLine()) {
            String input = stdin.next();
            input = stdin.next();
            input = stdin.next();
            String scannerX = "";
            for (int i = 2; i < input.length() - 1; i++) {
                scannerX = scannerX + input.charAt(i);
            }
            input = stdin.next();
            String scannerY = "";
            for (int i = 2; i < input.length() - 1; i++) {
                scannerY = scannerY + input.charAt(i);
            }
            input = stdin.next();
            input = stdin.next();
            input = stdin.next();
            input = stdin.next();

            input = stdin.next();
            String beaconX = "";
            for (int i = 2; i < input.length() - 1; i++) {
                beaconX = beaconX + input.charAt(i);
            }
            input = stdin.next();
            String beaconY = "";
            for (int i = 2; i < input.length(); i++) {
                beaconY = beaconY + input.charAt(i);
            }

            Cord scan = new Cord(Integer.parseInt(scannerX), Integer.parseInt(scannerY),
                    new Cord(Integer.parseInt(beaconX), Integer.parseInt(beaconY)));

            cords.add(scan);
            becs.add(scan.getBec());

        }

        ArrayList<Cord> taken = new ArrayList<Cord>();
        int total = 0;
        for (int i = 0; i < cords.size(); i++) {
            Cord scn = cords.get(i);

            Cord bec = scn.getBec();
            if (bec.getY() == 2000000 && !has(taken, bec)) {
                taken.add(bec);
                // System.out.print(i + "Beacon");
                // System.out.println(" " + bec.getX() + "," + bec.getY());
            }

            int becDistance = scn.getMan(scn.getBec());

            Cord test = new Cord(scn.getX(), 2000000);
            int dis = scn.getMan(test);
            if (dis <= becDistance && !has(taken, test)) {
                taken.add(test);
                // System.out.print(i + "second");
                // System.out.println(" " + test.getX() + "," + test.getY());
                total++;

            } else if (dis > becDistance) {
                continue;
            }

            for (int j = 1; true; j++) {
                test = new Cord(scn.getX() - j, 2000000);
                dis = scn.getMan(test);

                if (dis <= becDistance) {
                    if (has(taken, test)) {
                        continue;
                    }
                    taken.add(test);
                    // System.out.print(i + "thrid");
                    // System.out.println(" " + test.getX() + "," + test.getY());
                    total++;
                } else {
                    break;
                }
            }

            for (int j = 1; true; j++) {
                test = new Cord(scn.getX() + j, 2000000);
                dis = scn.getMan(test);

                if (dis <= becDistance) {
                    if (has(taken, test)) {
                        continue;
                    }
                    total++;
                    taken.add(test);
                    // System.out.print(i + "fourth");
                    // System.out.println(" " + test.getX() + "," + test.getY());
                } else {
                    break;
                }
            }
            // System.out.println();
        }

        System.out.print(total);
    }

    public static boolean has(ArrayList<Cord> cords, Cord c) {

        for (int i = 0; i < cords.size(); i++) {
            if (c.getX() == cords.get(i).getX() && c.getY() == cords.get(i).getY()) {
                return true;
            }
        }
        return false;
    }
}
