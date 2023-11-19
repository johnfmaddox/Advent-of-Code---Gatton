package CodeChallenge5;
import java.util.*;

/*
--- Day 5: Supply Stacks ---
The expedition can depart as soon as the final supplies have been unloaded from the ships. 
Supplies are stored in stacks of marked crates, but because the needed supplies are buried 
under many other crates, the crates need to be rearranged.

The ship has a giant cargo crane capable of moving crates between stacks. To ensure none of the 
crates get crushed or fall over, the crane operator will rearrange them in a series of carefully-planned 
steps. After the crates are rearranged, the desired crates will be at the top of each stack.

The Elves don't want to interrupt the crane operator during this delicate procedure, but they forgot 
to ask her which crate will end up where, and they want to be ready to unload them as soon as possible 
so they can embark.

They do, however, have a drawing of the starting stacks of crates and the rearrangement procedure 
(your puzzle input).

    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2

In this example, there are three stacks of crates. Stack 1 contains two crates: 
crate Z is on the bottom, and crate N is on top. Stack 2 contains three crates; 
from bottom to top, they are crates M, C, and D. Finally, stack 3 contains a single crate, P.

Then, the rearrangement procedure is given. In each step of the procedure, a quantity of crates is 
moved from one stack to a different stack. In the first step of the above rearrangement procedure, 
one crate is moved from stack 2 to stack 1, resulting in this configuration:

[D]        
[N] [C]    
[Z] [M] [P]
 1   2   3 

In the second step, three crates are moved from stack 1 to stack 3. Crates are moved one at a time, 
so the first crate to be moved (D) ends up below the second and third crates:

        [Z]
        [N]
    [C] [D]
    [M] [P]
 1   2   3
Then, both crates are moved from stack 2 to stack 1. Again, because crates are moved one at a time, 
crate C ends up below crate M:

        [Z]
        [N]
[M]     [D]
[C]     [P]
 1   2   3
Finally, one crate is moved from stack 1 to stack 2:

        [Z]
        [N]
        [D]
[C] [M] [P]
 1   2   3

The Elves just need to know which crate will end up on top of each stack; in this example, the top
crates are C in stack 1, M in stack 2, and Z in stack 3, so you should combine these together and 
give the Elves the message CMZ.

After the rearrangement procedure completes, what crate ends up on top of each stack?

INPUT:
    [W]         [J]     [J]        
    [V]     [F] [F] [S] [S]        
    [S] [M] [R] [W] [M] [C]        
    [M] [G] [W] [S] [F] [G]     [C]
[W] [P] [S] [M] [H] [N] [F]     [L]
[R] [H] [T] [D] [L] [D] [D] [B] [W]
[T] [C] [L] [H] [Q] [J] [B] [T] [N]
[G] [G] [C] [J] [P] [P] [Z] [R] [H]
 1   2   3   4   5   6   7   8   9 
*/

public class CodeChallenge5_Part1 {
    public static void main(String[] args) {
        // Going to work with ArrayLists to get rid of the size-related problems
        // First Create Arrays, ordered from bottom to top
        String[] col1 = {"G", "T", "R", "W"};
        String[] col2 = {"G", "C", "H", "P", "M", "S", "V", "W"};
        String[] col3 = {"C", "L", "T", "S", "G", "M"};
        String[] col4 = {"J", "H", "D", "M", "W", "R", "F"};
        String[] col5 = {"P", "Q", "L", "H", "S", "W", "F", "J"};
        String[] col6 = {"P", "J", "D", "N", "F", "M", "S"};
        String[] col7 = {"Z", "B", "D", "F", "G", "C", "S", "J"};
        String[] col8 = {"R", "T", "B"};
        String[] col9 = {"H", "N", "W", "L", "C"};
        
        // convert all arrays to ArrayLists
        ArrayList<String> col1_AL = new ArrayList<String>(Arrays.asList(col1));
        ArrayList<String> col2_AL = new ArrayList<String>(Arrays.asList(col2));
        ArrayList<String> col3_AL = new ArrayList<String>(Arrays.asList(col3));
        ArrayList<String> col4_AL = new ArrayList<String>(Arrays.asList(col4));
        ArrayList<String> col5_AL = new ArrayList<String>(Arrays.asList(col5));
        ArrayList<String> col6_AL = new ArrayList<String>(Arrays.asList(col6));
        ArrayList<String> col7_AL = new ArrayList<String>(Arrays.asList(col7));
        ArrayList<String> col8_AL = new ArrayList<String>(Arrays.asList(col8));
        ArrayList<String> col9_AL = new ArrayList<String>(Arrays.asList(col9));

        // create an ArrayList for the entire grid
        ArrayList<ArrayList<String>> grid = new ArrayList<>();
        grid.add(col1_AL);
        grid.add(col2_AL);
        grid.add(col3_AL);
        grid.add(col4_AL);
        grid.add(col5_AL);
        grid.add(col6_AL);
        grid.add(col7_AL);
        grid.add(col8_AL);
        grid.add(col9_AL);

        /*
        EXAMPLE:
            move 1 from 2 to 1
            move 3 from 1 to 3
            move 2 from 2 to 1
            move 1 from 1 to 2
        
        INSTRUCTION FORMAT:
            move {number of crates} from {initial column} to {new column}
        */

        // input and while loop
        Scanner stdin = new Scanner(System.in);

        while (stdin.hasNextLine()) {
            String instruction_i = stdin.nextLine();
            
            // format instructions
            int[] instruction_format = formatInstructions(instruction_i);

            // implement instructions and change ArrayList
            implementInstruction(grid, instruction_format);
        }

        // print the topmost element of each column and show the message
        for (ArrayList<String> col : grid) {
            System.out.print(col.get(col.size() - 1));
        }

        // close Scanner
        stdin.close();
    }

    public static int[] formatInstructions(String instruction) {
        // create an integer array with the integers {#crates to move, init col, new col}
        int[] inst = new int[3];
        String[] instruction_split = instruction.split(" ");

        int index = 0;
        for (String i : instruction_split) {
            if (!i.equals("move") && !i.equals("from") && !i.equals("to")) {
                inst[index] = Integer.parseInt(i);
                index++;
            }
        }

        // return the instructions
        return inst;
    }

    public static void implementInstruction(ArrayList<ArrayList<String>> grid, int[] instructions) {
        // arrays ordered from bottom to top
        int numberOfCrates = instructions[0];
        int initialColumn = instructions[1];
        int finalColumn = instructions[2];

        // index of column = column - 1
        ArrayList<String> initCOL = grid.get(initialColumn - 1);
        ArrayList<String> newCOL = grid.get(finalColumn - 1);

        // take section of initial column
        try {
            List<String> initCOLSection = initCOL.subList(initCOL.size() - numberOfCrates, initCOL.size());
            List<String> newInitCOL = initCOL.subList(0, initCOL.size() - numberOfCrates);

            // add section to final column
            newCOL.addAll(newInitCOL);

            // replace each column
            grid.set(initialColumn, new ArrayList<>(initCOLSection));
            grid.set(finalColumn, new ArrayList<>(newCOL));
        } catch (IndexOutOfBoundsException ioobe) {

        }
    }
}