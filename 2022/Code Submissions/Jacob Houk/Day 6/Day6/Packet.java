package Day6;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Packet {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("input6"));
		
		int idx = 0;
		
		String str = input.nextLine();
		
		for (int i = 3; i < str.length(); i++) {
			char ch1 = str.charAt(i - 3);
			char ch2 = str.charAt(i - 2);
			char ch3 = str.charAt(i - 1);
			char ch4 = str.charAt(i);
			
			if (ch1 != ch2 && ch1 != ch3 && ch1 != ch4) {
				if (ch2 != ch3 && ch2 != ch4) {
					if (ch3 != ch4) {
						idx = i + 1;
						break;
					} else {
						continue;
					}
				} else {
					continue;
				}
			} else {
				continue;
			}
		}
		
		System.out.println(idx);
	}
}
