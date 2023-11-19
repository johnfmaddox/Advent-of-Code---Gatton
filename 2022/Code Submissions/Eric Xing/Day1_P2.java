import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Day1_P2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long cur = 0;
		String line;
		ArrayList<Long> totals = new ArrayList<Long>();
		
		while((line = br.readLine()) != null) {
			if(line.equals("")) {
				totals.add(cur);
				cur = 0;
			} else {
				cur += Long.parseLong(line);
			}
		}
		totals.add(cur);
		
		Collections.sort(totals, Collections.reverseOrder());
		
		System.out.println(totals.get(0) + totals.get(1) + totals.get(2));
		
		br.close();

	}

}
