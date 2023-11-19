import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdventOfCode {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long max = 0;
		long cur = 0;
		String line;
		while((line = br.readLine()) != null) {
			if(line.equals("")) {
				max = cur > max ? cur : max;
				cur = 0;
			} else {
				cur += Long.parseLong(line);
			}
		}
		
		System.out.println(max);
		
		br.close();

	}

}
