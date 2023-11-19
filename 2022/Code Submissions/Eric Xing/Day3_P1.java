import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Day3_P1 {
	
	private static boolean in(char ch, char[] arr) {
		for(char cur : arr) {
			if(ch == cur) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long ans = 0;
		String line = br.readLine();
		while(!line.equals("end")) {
			char[] f, s, t;
			f = line.toCharArray();
			s = br.readLine().toCharArray();
			t = br.readLine().toCharArray();
			
			for(char cur : f) {
				if(in(cur, s) && in(cur, t)) {
					ans += (cur >= 'a' ? cur - 'a' + 1 : cur - 'A' + 27);
					break;
				}
			}
			line = br.readLine();
		}
		
		System.out.println(ans);
		
		br.close();

	}

}
