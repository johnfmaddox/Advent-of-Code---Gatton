package Day3;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Ruck {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("input3"));
		
		Rucksack[] ruck = new Rucksack[300];
		int cnt = 0, total = 0;
		
		while(input.hasNext()) {
			ruck[cnt++] = new Rucksack(input.nextLine());
		}
		
		for (int i = 0; i < cnt; i++) {
			total += ruck[i].getPrio();
		}
		
		System.out.println(total);
		
		input.close();
	}
}
