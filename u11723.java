import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class u11723 { // AC III
	static int n, m;
	
	public static void main (String[] args) throws IOException {
		BufferedReader rr = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		int sk = 0;
		while (true) {
			st = new StringTokenizer(rr.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			if (n == 0 && m == 0) break; // insert condition here
			
			long start = System.nanoTime();
			
			int res = (n / m);
			if (n % m == 0) res--; // equal is fine
			if (res > 26) System.out.println("Case " + (sk + 1) + ": impossible");
			else System.out.println("Case " + (sk + 1) + ": " + res);
			sk++;
			
		//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		}

		rr.close();
	}
}
