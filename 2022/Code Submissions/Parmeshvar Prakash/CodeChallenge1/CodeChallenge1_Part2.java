package CodeChallenge1;
/*
By the time you calculate the answer to the Elves' question, they've already realized that the Elf 
carrying the most Calories of food might eventually run out of snacks. To avoid this unacceptable 
situation, the Elves would instead like to know the total Calories carried by the top three Elves 
carrying the most Calories. That way, even if one of those Elves runs out of snacks, they still 
have two backups. In the example above, the top three Elves are the fourth Elf (with 24000 Calories), 
then the third Elf (with 11000 Calories), then the fifth Elf (with 10000 Calories). 
The sum of the Calories carried by these three elves is 45000.

Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?
*/
import java.util.*;

public class CodeChallenge1_Part2 {
    public static void main(String[] args) {
        // create a new Scanner
        Scanner stdin = new Scanner(System.in);

        // ArrayList to keep track of the total calories per elf
        ArrayList<Integer> numberOfCaloriesPerElf = new ArrayList<>();

        // Temporary variable for the sum of the fruit calories per elf
        int tempCalories = 0;

        /* While loop that goes through each line and calculates total amount of calories per elf and
        compares it with maxFruitCalories */
        while (stdin.hasNextLine()) {
            String input = stdin.nextLine();

            /* Check if input is an empty line; if it is then tempCalories should be reset after adding
               the total calories for that elf into the ArrayList */
            if (input.equals("")) {
                // add tempCalories to the ArrayList
                numberOfCaloriesPerElf.add(tempCalories);

                // reset tempCalories to 0
                tempCalories = 0;
                continue;
            }

            /* If the input is not an empty line, then add the values given to tempCalories */
            tempCalories += Integer.parseInt(input);
        }

        /* FIND THE TOP 3 GREATEST NUMBER OF CALORIES IN numberOfCaloriesPerElf and find the sum of them */
        // Find the maximum
        int maximum = 0;

        for (int i = 0; i < numberOfCaloriesPerElf.size(); i++) {
            int item = numberOfCaloriesPerElf.get(i);

            if (item > maximum) {
                maximum = item;
            }
        }

        // Find the second greatest number that is NOT the maximum
        int secondMaximum = 0;
        
        for (int i = 0; i < numberOfCaloriesPerElf.size(); i++) {
            int item = numberOfCaloriesPerElf.get(i);

            if (item > secondMaximum && item != maximum) {
                secondMaximum = item;
            }
        }

        // Find the third greatest number that is NOT the maximum or second maximum
        int thirdMaximum = 0;
        
        for (int i = 0; i < numberOfCaloriesPerElf.size(); i++) {
            int item = numberOfCaloriesPerElf.get(i);

            if (item > secondMaximum && item != maximum && item != secondMaximum) {
                thirdMaximum = item;
            }
        }

        // Print the sum of the calories
        System.out.printf("First: %d%nSecond: %d%nThird: %d", maximum, secondMaximum, thirdMaximum);

        // close stdin to remove warnings
        stdin.close();
    }
}
