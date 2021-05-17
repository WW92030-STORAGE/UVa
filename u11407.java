import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class u11407 { // AC
	static int[] dp;
	
	static void init(int n) {
		dp = new int[n];
		dp[0] = 0;
		for (int i = 1; i < n; i++) {
			int max = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) max = Math.min(max, 1 + dp[i - j * j]);
			dp[i] = max;
		}
	}
	
static int n;
	
	public static void main (String[] args) throws IOException {
		long start = System.nanoTime();
		init(100000);
	//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		BufferedReader rr = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(rr.readLine()); 
		n = Integer.parseInt(st.nextToken());
		
		for (int sk = 0; sk < n; sk++) {
			st = new StringTokenizer(rr.readLine()); 
			int x = Integer.parseInt(st.nextToken());
			System.out.println(dp[x]);
		}

		rr.close();
	}
}
