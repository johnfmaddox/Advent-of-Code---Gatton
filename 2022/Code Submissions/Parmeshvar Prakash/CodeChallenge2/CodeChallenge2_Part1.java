package CodeChallenge2;
import java.util.*;

/*
--- Day 2: Rock Paper Scissors ---

The Elves begin to set up camp on the beach. To decide whose tent gets to be closest to the snack storage, a giant Rock Paper Scissors tournament is already in progress.
Rock Paper Scissors is a game between two players. Each game contains many rounds; in each round, the players each simultaneously choose one of Rock, Paper, or Scissors using a 
hand shape. Then, a winner for that round is selected: Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock. If both players choose the same shape, the round 
instead ends in a draw.

Appreciative of your help yesterday, one Elf gives you an encrypted strategy guide (your puzzle input) that they say will be sure to help you win. "The first column is what your 
opponent is going to play: A for Rock, B for Paper, and C for Scissors. The second column--" Suddenly, the Elf is called away to help with someone's tent.

The second column, you reason, must be what you should play in response: X for Rock, Y for Paper, and Z for Scissors. Winning every time would be suspicious, so the responses must 
have been carefully chosen.

The winner of the whole tournament is the player with the highest score. Your total score is the sum of your scores for each round. The score for a single round is the score for 
the shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors) plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won).

Since you can't be sure if the Elf is trying to help you or trick you, you should calculate the score you would get if you were to follow the strategy guide.
*/

public class CodeChallenge2_Part1 {
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
            String yourChoice = arrayOfChoice[1];

            // add score given by method to totalScore
            totalScore += getYourScore(opponentsChoice, yourChoice);
        }

        // print totalScore
        System.out.printf("The total score: %d", totalScore);
        
        // close stdin
        stdin.close();
    }

    /**
     * The score is calculated using the following method
     *      - There is a score for the shape you selected
     *          # 1 for Rock (X) (A - opponent)
     *          # 2 for Paper (Y) (B - opponent)
     *          # 3 for Scissors (Z) (C - opponent)
     *      - There is a score for the outcome of the round
     *          # 0 for loss
     *          # 3 for draw
     *          # 6 for win
     * 
     * @param opponentsChoice
     * @param yourChoice
     * @return
     */
    public static int getYourScore(String opponentsChoice, String yourChoice) {
        int score = 0;

        if (opponentsChoice.equals("A")) {
            if (yourChoice.equals("X")) {
                score += (1 + 3); // rock + draw
            } else if (yourChoice.equals("Y")) {
                score += (2 + 6); // paper + win 
            } else {
                score += (3 + 0); // scissors + loss
            }
        } else if (opponentsChoice.equals("B")) {
            if (yourChoice.equals("X")) {
                score += (1 + 0); // rock + loss
            } else if (yourChoice.equals("Y")) {
                score += (2 + 3); // paper + draw 
            } else {
                score += (3 + 6); // scissors + win
            }
        } else {
            if (yourChoice.equals("X")) {
                score += (1 + 6); // rock + win
            } else if (yourChoice.equals("Y")) {
                score += (2 + 0); // paper + loss 
            } else {
                score += (3 + 3); // scissors + draw
            }
        }

        return score;
    }
}
