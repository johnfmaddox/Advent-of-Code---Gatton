package CodeChallenge4;
import java.util.*;

/*
It seems like there is still quite a bit of duplicate work planned. Instead, the Elves would like 
to know the number of pairs that overlap at all.

In the above example, the first two pairs (2-4,6-8 and 2-3,4-5) don't overlap, while the remaining 
four pairs (5-7,7-9, 2-8,3-7, 6-6,4-6, and 2-6,4-8) do overlap:

5-7,7-9 overlaps in a single section, 7.
2-8,3-7 overlaps all of the sections 3 through 7.
6-6,4-6 overlaps in a single section, 6.
2-6,4-8 overlaps in sections 4, 5, and 6.
So, in this example, the number of overlapping assignment pairs is 4.

In how many assignment pairs do the ranges overlap?
*/

public class CodeChallenge4_Part2 {
    public static void main(String[] args) {
        // create Scanner
        Scanner stdin = new Scanner(System.in);

        // variable to keep track of the number of ranges overlapping with the other
        int numberOverlapping = 0;

        // get input and perform operations
        while (stdin.hasNext()) {
            // get the input
            String twoRanges = stdin.nextLine();

            // split by comma into two ranges
            String[] rangeArray = twoRanges.split(",");

            // get the ranges
            String range1 = rangeArray[0];
            String range2 = rangeArray[1];

            // get whether one range contains or not and add 1 to numberOverlapping
            if (overlaps(range1, range2))
                numberOverlapping++;
        }

        // Display the number of ranges containing the other
        System.out.printf("Number of ranges overlapping with the other: %d", numberOverlapping);

        // close Scanner
        stdin.close();
    }

    public static boolean overlaps(String range1, String range2) {
        /*
         * range 1: a-b
         * range 2: c-d
         * 
         * "c" can be between "a" and "b"
         * "d" has to be greater than b
         * OR
         * "a" can be between "c" and "d"
         * "b" has to be greater than d
         */

        // split by dash
        String[] range1_split = range1.split("-");
        String[] range2_split = range2.split("-");

        // convert to integers and compare
        // range1_split = {a, b}
        // range2_split = {c, d}
        int min1 = Integer.parseInt(range1_split[0]);
        int max1 = Integer.parseInt(range1_split[1]);
        int min2 = Integer.parseInt(range2_split[0]);
        int max2 = Integer.parseInt(range2_split[1]);

        // return the condition above
        return (
            (min1 >= min2 && min1 <= max2) ||
            (min2 >= min1 && min2 <= max1)
        );
    }
}
