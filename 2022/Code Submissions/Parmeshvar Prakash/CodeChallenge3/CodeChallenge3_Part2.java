package CodeChallenge3;
import java.util.*;

/*
As you finish identifying the misplaced items, the Elves come to you with another issue.

For safety, the Elves are divided into groups of three. Every Elf carries a badge that identifies their 
group. For efficiency, within each group of three Elves, the badge is the only item type carried by all 
three Elves. That is, if a group's badge is item type B, then all three Elves will have item type B 
somewhere in their rucksack, and at most two of the Elves will be carrying any other item type.

The problem is that someone forgot to put this year's updated authenticity sticker on the badges. 
All of the badges need to be pulled out of the rucksacks so the new authenticity stickers can be attached.

Additionally, nobody wrote down which item type corresponds to each group's badges. The only way to tell 
which item type is the right one is by finding the one item type that is common between all three Elves 
in each group.

Every set of three lines in your list corresponds to a single group, but each group can have a different 
badge item type. 

So, in the above example, the first group's rucksacks are the first three lines:
    vJrwpWtwJgWrhcsFMMfFFhFp
    jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
    PmmdzqPrVvPwwTWBwg

And the second group's rucksacks are the next three lines:
    wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
    ttgJtRGJQctTZtZT
    CrZsJsPPZsGzwwsLwLmpwMDw

In the first group, the only item type that appears in all three rucksacks is lowercase r; 
this must be their badges. In the second group, their badge item type must be Z.

Priorities for these items must still be found to organize the sticker attachment efforts: 
here, they are 18 (r) for the first group and 52 (Z) for the second group. The sum of these is 70.
*/

public class CodeChallenge3_Part2 {
    public static void main(String[] args) {
        // create scanner
        Scanner stdin = new Scanner(System.in);

        // String input array
        ArrayList<ArrayList<String>> groupsOfThree = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        int count = 0;

        // ask for input and add to inpArray
        while (stdin.hasNextLine()) {
            // check if count is equal to 3, and then add temp to groupsOfThree
            if (count == 3) {
                count = 0;
                groupsOfThree.add(temp);
                temp = new ArrayList<>();
            }

            // increase count
            count++;

            // get input line
            String inputLine = stdin.nextLine();

            // add to temp
            temp.add(inputLine);
        }

        // find the common character and add the priority of the letter to totalPriority
        int totalPriority = 0;

        for (ArrayList<String> arr : groupsOfThree) {
            totalPriority += priorityOfLetter(commonLetter(arr));
        }

        // print out total priority
        System.out.printf("The total priority is: %d%n", totalPriority);

        // close stdin
        stdin.close();
    }

    /**
     * Find the common letter between three strings
     */
    private static char commonLetter(ArrayList<String> arr) {
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (char i : letters.toCharArray()) {
            if (arr.get(0).contains(i + "") && arr.get(1).contains(i + "") && arr.get(2).contains(i + ""))
                return i;
        }

        return ' ';
    }

    /**
     * Find the priority of a letter
     * 
     * a-z have priority 1-26
     * A-Z have priority 27-52
     */
    private static int priorityOfLetter(char character) {
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        if (lowercaseLetters.indexOf(character) != -1) {
            return (lowercaseLetters.indexOf(character) + 1);
        } else {
            return (uppercaseLetters.indexOf(character) + 27);
        }
    }
}
