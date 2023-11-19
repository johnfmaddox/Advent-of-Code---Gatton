import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


//A Rock 1
//B Paper 2
//C Scissors 3
//X Lose 0
//Y Draw 3
//Z Win 6
public class RockPaperScissors {
	public static int matchScore(String opp, String you) {
		int score = 0;
		if(you.equals("X")) {
			if(opp.equals("A")) {
				score+=3;
			}else if(opp.equals("B")) {
				score+=1;
			}else if(opp.equals("C")) {
				score+=2;
			}
		}else if(you.equals("Y")) {
			score += 3;
			if(opp.equals("A")) {
				score+=1;
			}else if(opp.equals("B")) {
				score+=2;
			}else if(opp.equals("C")) {
				score+=3;
			}
		}else if(you.equals("Z")) {
			score+=6;
			if(opp.equals("A")) {
				score+=2;
			}else if(opp.equals("B")) {
				score+=3;
			}else if(opp.equals("C")) {
				score+=1;
			}
		}
		return score;
	}
	public static void main(String[] args) throws FileNotFoundException{
		Scanner stdin = new Scanner(new File("input"));
		int totalScore = 0;
		while(stdin.hasNextLine()) {
			String opp = stdin.next();
			String you = stdin.next();
			totalScore+=matchScore(opp, you);
		}
		System.out.println(totalScore);
	}
}
