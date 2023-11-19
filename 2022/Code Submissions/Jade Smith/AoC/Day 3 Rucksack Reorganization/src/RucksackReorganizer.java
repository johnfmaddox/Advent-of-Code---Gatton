import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class RucksackReorganizer {
	public static int reorganize(String rucksack) {
		int length = rucksack.length();
		String half1 = rucksack.substring(0, (length/2));
		String half2 = rucksack.substring((length/2));
		int[] priorities1 = new int[length/2];
		for(int i = 0; i<half1.length(); i++) {
			if(Character.isLowerCase(half1.charAt(i))) {
				priorities1[i] = (half1.charAt(i)-'a')+1;
			}else {
				priorities1[i] = (half1.charAt(i)-'A')+27; 
			}
		}
		Arrays.sort(priorities1);
		for(int i = 0; i<half2.length(); i++) {
			int thisPriority=0;
			if(Character.isLowerCase(half2.charAt(i))) {
				thisPriority = (half2.charAt(i)-'a')+1;
			}else {
				thisPriority= (half2.charAt(i)-'A')+27;
			}
			if(Arrays.binarySearch(priorities1, thisPriority)>=0) {
				return thisPriority;
			}
		}
		return -1;
	}
	public static int findBadge(String[] rucksacks) {
		int length1 = rucksacks[0].length();
		int[] firstPriorities = new int[length1];
		for(int i = 0; i<length1; i++) {
			if(Character.isLowerCase(rucksacks[0].charAt(i))) {
				firstPriorities[i]= (rucksacks[0].charAt(i)-'a')+1;
			}else {
				firstPriorities[i] = (rucksacks[0].charAt(i)-'A')+27; 
			}
		}
		Arrays.sort(firstPriorities);
		List<Integer> secondPriorities = new ArrayList<Integer>();
		int length2=rucksacks[1].length();
		for(int i =0; i<length2; i++) {
			int thisPriority=0;
			if(Character.isLowerCase(rucksacks[1].charAt(i))) {
				thisPriority=(rucksacks[1].charAt(i)-'a')+1;
			}else {
				thisPriority=(rucksacks[1].charAt(i)-'A')+27;
			}
			if(Arrays.binarySearch(firstPriorities, thisPriority)>=0) {
				secondPriorities.add(thisPriority);
			}
		}
		Collections.sort(secondPriorities);
		int length3=rucksacks[2].length();
		for(int i=0; i<length3; i++) {
			int thisPriority=0;
			if(Character.isLowerCase(rucksacks[2].charAt(i))) {
				thisPriority=(rucksacks[2].charAt(i)-'a')+1;
			}else {
				thisPriority =(rucksacks[2].charAt(i)-'A')+27;
			}
			if(Collections.binarySearch(secondPriorities, thisPriority)>=0) {
				return thisPriority;
			}
		}
		return -1;
	}
	/*
	public static void main(String[] args) throws FileNotFoundException {
		Scanner stdin = new Scanner(new File("input"));
		int total = 0;
		while(stdin.hasNextLine()) {
			total += reorganize(stdin.next());
		}
		System.out.println(total);
	}
	*/
	public static void main(String[] args) throws FileNotFoundException {
		Scanner stdin = new Scanner(new File("input"));
		int total = 0;
		while(stdin.hasNextLine()) {
			String[] rucksacks = new String[3];
			for(int i = 0; i<3; i++) {
				rucksacks[i] = stdin.next();
			}
			total += findBadge(rucksacks);
		}
		System.out.println(total);
	}
}
