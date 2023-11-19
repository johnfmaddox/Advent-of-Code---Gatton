package CodeChallenge4;
import java.util.*;

/*
--- Day 4: Camp Cleanup ---

Space needs to be cleared before the last supplies can be unloaded from the ships, and so several Elves 
have been assigned the job of cleaning up sections of the camp. Every section has a unique ID number, and 
each Elf is assigned a range of section IDs.

However, as some of the Elves compare their section assignments with each other, they've noticed that many 
of the assignments overlap. To try to quickly find overlaps and reduce duplicated effort, the Elves pair up 
and make a big list of the section assignments for each pair (your puzzle input).

For example, consider the following list of section assignment pairs:

2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8

For the first few pairs, this list means:

Within the first pair of Elves, the first Elf was assigned sections 2-4 (sections 2, 3, and 4), 
while the second Elf was assigned sections 6-8 (sections 6, 7, 8).

The Elves in the second pair were each assigned two sections.

The Elves in the third pair were each assigned three sections: one got sections 5, 6, and 7, while the 
other also got 7, plus 8 and 9.

This example list uses single-digit section IDs to make it easier to draw; your actual list might contain 
larger numbers. Visually, these pairs of section assignments look like this:

.234.....  2-4
.....678.  6-8

.23......  2-3
...45....  4-5

....567..  5-7
......789  7-9

.2345678.  2-8
..34567..  3-7

.....6...  6-6
...456...  4-6

.23456...  2-6
...45678.  4-8

Some of the pairs have noticed that one of their assignments fully contains the other. For example, 
2-8 fully contains 3-7, and 6-6 is fully contained by 4-6. In pairs where one assignment fully contains 
the other, one Elf in the pair would be exclusively cleaning sections their partner will already be cleaning, 
so these seem like the most in need of reconsideration. In this example, there are 2 such pairs.
*/

public class CodeChallenge4_Part1 {
    public static void main(String[] args) {
        // create Scanner
        Scanner stdin = new Scanner(System.in);

        // variable to keep track of the number of ranges containing the other
        int numberContaining = 0;

        // get input and perform operations
        while (stdin.hasNext()) {
            // get the input
            String twoRanges = stdin.nextLine();

            // split by comma into two ranges
            String[] rangeArray = twoRanges.split(",");

            // get the ranges
            String range1 = rangeArray[0];
            String range2 = rangeArray[1];

            // get whether one range contains or not and add 1 to numberContaining
            if (contains(range1, range2))
                numberContaining++;
        }

        // Display the number of ranges containing the other
        System.out.printf("Number of ranges containing the other: %d", numberContaining);

        // close Scanner
        stdin.close();
    }

    public static boolean contains(String range1, String range2) {
        /*
         * range 1: a-b
         * range 2: c-d
         * 
         * a => c and b <= d
         * c => a and d <= b
         */

        // split by dash
        String[] range1_split = range1.split("-");
        String[] range2_split = range2.split("-");

        // convert to integers and compare
        // range1_split = {a, b}
        // range2_split = {c, d}
        int a = Integer.parseInt(range1_split[0]);
        int b = Integer.parseInt(range1_split[1]);
        int c = Integer.parseInt(range2_split[0]);
        int d = Integer.parseInt(range2_split[1]);
        
        // return the condition above
        return ((a >= c && b <= d) || (c >= a && d <= b));
    }
}
