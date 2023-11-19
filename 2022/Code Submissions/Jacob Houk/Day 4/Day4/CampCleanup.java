package Day4;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CampCleanup {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("input4"));
		
		int total = 0;
		
		while (input.hasNextLine()) {
			String tRanges = input.nextLine();
			int cInd = 0;
			
			for (int i = 0; i < tRanges.length(); i++) {
				if (tRanges.charAt(i) == ',') {
					cInd = i;
					break;
				}
			}
			
			Range r1 = new Range(tRanges.substring(0, cInd));
			Range r2 = new Range(tRanges.substring(cInd + 1));
			
			if (r1.inside(r2)) {
				total++;
			} else if (r2.inside(r1)) {
				total++;
			}
		}
		
		System.out.println(total);
	}
}