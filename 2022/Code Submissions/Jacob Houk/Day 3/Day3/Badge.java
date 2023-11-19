package Day3;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Badge {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("input3"));
		
		Rucksack[] ruck1 = new Rucksack[100];
		Rucksack[] ruck2 = new Rucksack[100];
		Rucksack[] ruck3 = new Rucksack[100];
		int cnt1 = 0, cnt2 = 0, cnt3 = 0, total = 0, i = 0;
		
		while(input.hasNext()) {
			ruck1[cnt1++] = new Rucksack(input.nextLine());
			ruck2[cnt2++] = new Rucksack(input.nextLine());
			ruck3[cnt3++] = new Rucksack(input.nextLine());
			
			total += Rucksack.getBadge(ruck1[i], ruck2[i], ruck3[i++]);
		}
		
		System.out.println(total);
		
		input.close();
	}
}