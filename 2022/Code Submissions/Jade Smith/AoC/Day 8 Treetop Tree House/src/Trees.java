import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
public class Trees {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner stdin = new Scanner(new File("input"));
		ArrayList<ArrayList<Integer>> heights = new ArrayList<ArrayList<Integer>>();
		while(stdin.hasNextLine()) {
			String currentLine = stdin.nextLine();
			ArrayList<Integer> row = new ArrayList<Integer>();
			for(int i = 0; i < currentLine.length(); i++) {
				row.add(Integer.parseInt(currentLine.substring(i, i+1)));
			}
			heights.add(row);
		}
		
		//int numVisible = 0;
		int highest = 0;
		for(int x = 0; x<heights.size(); x++) {
			for(int y = 0; y<heights.get(x).size(); y++) {
				/*
				boolean visibleLeft = true;
				boolean visibleRight = true;
				boolean visibleUp = true;
				boolean visibleDown = true;
				int currentHeight = heights.get(x).get(y);
				//left
				for(int k = x-1; k>=0; k--) {
					System.out.println("a");
					if(heights.get(k).get(y)>=currentHeight) {
						System.out.println(heights.get(k).get(y)-currentHeight);
						visibleLeft=false;
						break;
					} 
				}
				//right
				for (int k = x+1; k<heights.size(); k++) {
					if(heights.get(k).get(y)>=currentHeight) {
						visibleRight = false;
						break;
					}
				}
				//up
				for(int k = y-1; k>=0; k--) {
					if(heights.get(x).get(k)>=currentHeight) {
						visibleUp=false;
						break;
					}
				}
				//down
				for(int k = y+1; k<heights.get(x).size(); k++) {
					if(heights.get(x).get(k)>=currentHeight) {
						visibleDown = false;
						break;
					}
				}
				if(visibleUp || visibleDown || visibleRight || visibleLeft) {
					numVisible++;
				}
				*/
				int leftView = 0;
				int rightView = 0;
				int upView = 0;
				int downView = 0;
				int currentHeight = heights.get(x).get(y);
				//left
				for(int k = x-1; k>=0; k--) {
					int treeHeight = heights.get(k).get(y);
					leftView++;
					if(treeHeight>=currentHeight) {
						break;
					}
				}
				//right
				for(int k = x+1; k<heights.size(); k++) {
					int treeHeight = heights.get(k).get(y);
					rightView++;
					if(treeHeight>=currentHeight) {
						break;
					}
				}
				//up
				for(int k = y-1; k>=0; k--) {
					int treeHeight = heights.get(x).get(k);
					upView++;
					if(treeHeight>=currentHeight) {
						break;
					}
				}
				//down
				for(int k = y+1; k<heights.get(x).size(); k++) {
					int treeHeight = heights.get(x).get(k);
					downView++;
					if(treeHeight>=currentHeight) {
						break;
					}
				}
				int scenicScore = leftView*rightView*upView*downView;
				if(scenicScore>highest) {
					highest=scenicScore;
				}
			}
		}
		System.out.println(highest);
	}
}
