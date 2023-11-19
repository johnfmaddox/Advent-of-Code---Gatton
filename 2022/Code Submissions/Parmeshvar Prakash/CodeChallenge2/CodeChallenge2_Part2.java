package CodeChallenge2;
import java.util.*;

/*
The Elf finishes helping with the tent and sneaks back over to you. "Anyway, the second column says how the round needs to end: X means you need to lose, 
Y means you need to end the round in a draw, and Z means you need to win. Good luck!"

The total score is still calculated in the same way, but now you need to figure out what shape to choose so the round ends as indicated. The example above now goes like this:
    - In the first round, your opponent will choose Rock (A), and you need the round to end in a draw (Y), so you also choose Rock. This gives you a score of 1 + 3 = 4.
    - In the second round, your opponent will choose Paper (B), and you choose Rock so you lose (X) with a score of 1 + 0 = 1.
    - In the third round, you will defeat your opponent's Scissors with Rock for a score of 1 + 6 = 7.
    - Now that you're correctly decrypting the ultra top secret strategy guide, you would get a total score of 12.

Following the Elf's instructions for the second column, what would your total score be if everything goes exactly according to your strategy guide?
*/

public class CodeChallenge2_Part2 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        // create a variable for total score
        int totalScore = 0;

        // create a while loop that reads in input lines
        while (stdin.hasNextLine()) {
            /* 
            round n: OPPONENT_CHOICE YOUR_CHOICE
            
            OPPONENT_CHOICE:
                A - rock
                B - paper
                C - scissor
            
            YOUR_CHOICE:
                X - rock
                Y - paper
                Z - scissor
            */
            String roundLine = stdin.nextLine();

            // split string by space into an array
            String[] arrayOfChoice = roundLine.split(" ");

            // check combinations
            String opponentsChoice = arrayOfChoice[0];
            String type_LDW = arrayOfChoice[1]; // type: lose, win, draw

            // add score given by method to totalScore
            totalScore += getYourScore(opponentsChoice, type_LDW);
        }

        // print totalScore
        System.out.printf("The total score: %d", totalScore);

        // close stdin
        stdin.close();
    }

    /**
     * The score is calculated using the following method
     *      - There is a score for the shape you selected
     *          # 1 for Rock (A - opponent)
     *          # 2 for Paper (B - opponent)
     *          # 3 for Scissors (C - opponent)
     *      - Lose, Win, Draw
     *          # X for lose
     *          # Y for draw
     *          # Z for win
     *      - There is a score for the outcome of the round
     *          # 0 for loss
     *          # 3 for draw
     *          # 6 for win
     * 
     * @param opponentsChoice
     * @param yourChoice
     * @return
     */
    public static int getYourScore(String opponentsChoice, String type_LDW) {
        int score = 0;

        if (opponentsChoice.equals("A")) {
            if (type_LDW.equals("X")) {
                score += (3 + 0); // scissors + loss
            } else if (type_LDW.equals("Y")) {
                score += (1 + 3); // rock + draw
            } else {
                score += (2 + 6); // paper + win
            }
        } else if (opponentsChoice.equals("B")) {
            if (type_LDW.equals("X")) {
                score += (1 + 0); // rock + loss
            } else if (type_LDW.equals("Y")) {
                score += (2 + 3); // paper + draw
            } else {
                score += (3 + 6); // scissors + win
            }
        } else {
            if (type_LDW.equals("X")) {
                score += (2 + 0); // paper + loss
            } else if (type_LDW.equals("Y")) {
                score += (3 + 3); // scissors + draw
            } else {
                score += (1 + 6); // rock + win
            }
        }

        return score;
    }
}
