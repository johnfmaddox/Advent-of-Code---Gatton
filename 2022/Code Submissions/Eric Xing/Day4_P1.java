import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day4_P1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(",");
		
		long ans = 0;
		
		while(!line[0].equals("done")) {
			String[] a_s = line[0].split("-");
			String[] b_s = line[1].split("-");
			
			int[] a = {Integer.parseInt(a_s[0]), Integer.parseInt(a_s[1])};
			int[] b = {Integer.parseInt(b_s[0]), Integer.parseInt(b_s[1])};
			
			if(Math.max(a[0],b[0]) <= Math.min(a[1],b[1])) {
				ans++;
			}
			
			line = br.readLine().split(",");
		}
		
		System.out.println(ans);		
		br.close();

	}

}
