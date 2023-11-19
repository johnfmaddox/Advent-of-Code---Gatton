package CodeChallenge3;
import java.util.*;

/*
--- Day 3: Rucksack Reorganization ---

One Elf has the important job of loading all of the rucksacks with supplies for the jungle journey. 
Unfortunately, that Elf didn't quite follow the packing instructions, and so a few items now need to 
be rearranged.

Each rucksack has two large compartments. All items of a given type are meant to go into exactly one of 
the two compartments. The Elf that did the packing failed to follow this rule for exactly one item type 
per rucksack.

The Elves have made a list of all of the items currently in each rucksack (your puzzle input), but they 
need your help finding the errors. Every item type is identified by a single lowercase or uppercase letter 
(that is, a and A refer to different types of items).

The list of items for each rucksack is given as characters all on a single line. A given rucksack always 
has the same number of items in each of its two compartments, so the first half of the characters represent 
items in the first compartment, while the second half of the characters represent items in the second 
compartment.

INPUT:
    vJrwpWtwJgWrhcsFMMfFFhFp
    jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
    PmmdzqPrVvPwwTWBwg
    wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
    ttgJtRGJQctTZtZT
    CrZsJsPPZsGzwwsLwLmpwMDw

LOGIC:
    - The first rucksack contains the items vJrwpWtwJgWrhcsFMMfFFhFp, which means its first compartment 
      contains the items vJrwpWtwJgWr, while the second compartment contains the items hcsFMMfFFhFp. 
      The only item type that appears in both compartments is lowercase p.
    - The second rucksack's compartments contain jqHRNqRjqzjGDLGL and rsFMfFZSrLrFZsSL. The only item 
      type that appears in both compartments is uppercase L.
    - The third rucksack's compartments contain PmmdzqPrV and vPwwTWBwg; the only common item type is 
      uppercase P.
    - The fourth rucksack's compartments only share item type v.
    - The fifth rucksack's compartments only share item type t.
    - The sixth rucksack's compartments only share item type s.

    To help prioritize item rearrangement, every item type can be converted to a priority:

    Lowercase item types a through z have priorities 1 through 26.
    Uppercase item types A through Z have priorities 27 through 52.
    In the above example, the priority of the item type that appears in both compartments of each 
    rucksack is 16 (p), 38 (L), 42 (P), 22 (v), 20 (t), and 19 (s); the sum of these is 157.
*/

public class CodeChallenge3_Part1 {
    public static void main(String[] args) {
        // create Scanner
        Scanner stdin = new Scanner(System.in);

        // ask for input while there is input
        int sumOfPriorityOfTheItemType = 0;

        while (stdin.hasNextLine()) {
            // get each line
            String line = stdin.nextLine();

            // each line has an even number of characters: split line in half
            String firstHalf = line.substring(0, line.length() / 2);
            String secondHalf = line.substring(line.length() / 2, line.length());

            // get the one common character
            char commonCharacter = ' ';

            for (char fh_ch : firstHalf.toCharArray()) {
                for (int i = 0; i < secondHalf.length(); i++) {
                    if (fh_ch == secondHalf.charAt(i)) {
                        commonCharacter = fh_ch;
                        break;
                    }
                }
            }
            
            sumOfPriorityOfTheItemType += convertToPriority(commonCharacter);
        }

        // return the sum of the priorities
        System.out.printf("The sum of the priorities are: %d%n", sumOfPriorityOfTheItemType);

        // close stdin
        stdin.close();
    }

    /**
     * Convert letter to an established priority
     * 
     * a-z = 1-26
     * A-Z = 27-52
     */
    public static int convertToPriority(char character) {
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        if (lowercaseLetters.indexOf(character) != -1) {
            return (lowercaseLetters.indexOf(character) + 1);
        } else {
            return (uppercaseLetters.indexOf(character) + 27);
        }
    }
}
