import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class CalorieCounter {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner stdin = new Scanner(new File("input"));
		List<Elf> elves = new ArrayList<Elf>();
		int cnt = 0;
		Elf currentElf = new Elf();
		do{
			String currentLine = stdin.nextLine();
			if(cnt==0 || currentLine.equals("")) {
				if(cnt>0) {
					elves.add(currentElf);
				}
				currentElf = new Elf();
				cnt++;
			}
			if(!currentLine.equals("")) {
				currentElf.addCalorie(Integer.valueOf(currentLine));
			}
		}while(stdin.hasNextLine());
		elves.add(currentElf);
		int[] top3 = new int[3];
		top3[0] =0;
		top3[1] =0;
		top3[2] =0;
		for(int i = 0; i < elves.size(); i++) {
			int currTotal = elves.get(i).total();
			if(currTotal>top3[2]) {
				if(currTotal>top3[1]) {
					if(currTotal>top3[0]) {
						top3[2] = top3[1];
						top3[1] = top3[0];
						top3[0] = currTotal;
					}else {
						top3[2] = top3[1];
						top3[1] = currTotal;
					}
				}else {
					top3[2] = currTotal;
				}
			}
		}
		System.out.println(top3[2]+top3[1]+top3[0]);
	}
}
class Elf{
	private List<Integer> calories;
	
	Elf(){
		calories = new ArrayList<>();
	}
	void addCalorie(int calorie) {
		calories.add(calorie);
	}
	int total() {
		int total = 0;
		for(int i = 0; i<calories.size(); i++) {
			total += calories.get(i);
		}
		return total;
	}
}


