package Day3;

public class Rucksack {
	String inven;
	
	public Rucksack(String inven) {
		this.inven = inven;
	}
	
	public String getInven() {
		return this.inven;
	}
	
	public int getPrio() {
		int split = this.inven.length() / 2;
		
		char[] inner = new char[split], outer = new char[split];
		
		for (int i = 0; i < split; i++) {
			inner[i] = this.inven.charAt(i);
			outer[i] = this.inven.charAt(split + i);
		}
		
		for (int i = 0; i < outer.length; i++) {
			for (int j = 0; j < inner.length; j++) {
				if (inner[j] == outer[i]) {
					switch (inner[j]) {
						case 'a':
							return 1;
						case 'b':
							return 2;
						case 'c':
							return 3;
						case 'd':
							return 4;
						case 'e':
							return 5;
						case 'f':
							return 6;
						case 'g':
							return 7;
						case 'h':
							return 8;
						case 'i':
							return 9;
						case 'j':
							return 10;
						case 'k':
							return 11;
						case 'l':
							return 12;
						case 'm':
							return 13;
						case 'n':
							return 14;
						case 'o':
							return 15;
						case 'p':
							return 16;
						case 'q':
							return 17;
						case 'r':
							return 18;
						case 's':
							return 19;
						case 't':
							return 20;
						case 'u':
							return 21;
						case 'v':
							return 22;
						case 'w':
							return 23;
						case 'x':
							return 24;
						case 'y':
							return 25;
						case 'z':
							return 26;
						case 'A':
							return 27;
						case 'B':
							return 28;
						case 'C':
							return 29;
						case 'D':
							return 30;
						case 'E':
							return 31;
						case 'F':
							return 32;
						case 'G':
							return 33;
						case 'H':
							return 34;
						case 'I':
							return 35;
						case 'J':
							return 36;
						case 'K':
							return 37;
						case 'L':
							return 38;
						case 'M':
							return 39;
						case 'N':
							return 40;
						case 'O':
							return 41;
						case 'P':
							return 42;
						case 'Q':
							return 43;
						case 'R':
							return 44;
						case 'S':
							return 45;
						case 'T':
							return 46;
						case 'U':
							return 47;
						case 'V':
							return 48;
						case 'W':
							return 49;
						case 'X':
							return 50;
						case 'Y':
							return 51;
						case 'Z':
							return 52;
					}
				}
			}
		}
		
		return 0;
	}
	
	public static int getBadge(Rucksack ruck1, Rucksack ruck2, Rucksack ruck3) {
		char[] set1 = new char[ruck1.getInven().length()], 
				set2 = new char[ruck2.getInven().length()], set3 = new char[ruck3.getInven().length()];
		
		for (int i = 0; i < ruck1.getInven().length(); i++) {
			set1[i] = ruck1.getInven().charAt(i);
		}
		
		for (int i = 0; i < ruck2.getInven().length(); i++) {
			set2[i] = ruck2.getInven().charAt(i);
		}
		
		for (int i = 0; i < ruck3.getInven().length(); i++) {
			set3[i] = ruck3.getInven().charAt(i);
		}
		
		for (int i = 0; i < set1.length; i++) {
			for (int j = 0; j < set2.length; j++) {
				for (int k = 0; k < set3.length; k++) {
					if (set3[k] == set2[j] && set2[j] == set1[i]) {
						switch (set2[j]) {
							case 'a':
								return 1;
							case 'b':
								return 2;
							case 'c':
								return 3;
							case 'd':
								return 4;
							case 'e':
								return 5;
							case 'f':
								return 6;
							case 'g':
								return 7;
							case 'h':
								return 8;
							case 'i':
								return 9;
							case 'j':
								return 10;
							case 'k':
								return 11;
							case 'l':
								return 12;
							case 'm':
								return 13;
							case 'n':
								return 14;
							case 'o':
								return 15;
							case 'p':
								return 16;
							case 'q':
								return 17;
							case 'r':
								return 18;
							case 's':
								return 19;
							case 't':
								return 20;
							case 'u':
								return 21;
							case 'v':
								return 22;
							case 'w':
								return 23;
							case 'x':
								return 24;
							case 'y':
								return 25;
							case 'z':
								return 26;
							case 'A':
								return 27;
							case 'B':
								return 28;
							case 'C':
								return 29;
							case 'D':
								return 30;
							case 'E':
								return 31;
							case 'F':
								return 32;
							case 'G':
								return 33;
							case 'H':
								return 34;
							case 'I':
								return 35;
							case 'J':
								return 36;
							case 'K':
								return 37;
							case 'L':
								return 38;
							case 'M':
								return 39;
							case 'N':
								return 40;
							case 'O':
								return 41;
							case 'P':
								return 42;
							case 'Q':
								return 43;
							case 'R':
								return 44;
							case 'S':
								return 45;
							case 'T':
								return 46;
							case 'U':
								return 47;
							case 'V':
								return 48;
							case 'W':
								return 49;
							case 'X':
								return 50;
							case 'Y':
								return 51;
							case 'Z':
								return 52;
						}
					}
				}
			}
		}
		
		return 0;
	}
}