import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class u10036 { // AC XIII
	static int[] list;
	static boolean[][] dp;
	
	static int n, k, t;
	
	static void solve() {
		dp = new boolean[n][k]; // dp[i][j] is can reach element i with j mod k
		dp[0][list[0]] = true;
		for (int i = 1; i < n; i++) {
			int term = list[i];
			TreeSet<Integer> update = new TreeSet<Integer>();
			for (int j = 0; j < k; j++) {
				if (dp[i - 1][j]) {
					update.add((j + term + k * 69) % k);
					update.add((j - term + k * 69) % k);
				}
			}
			for (int x : update) dp[i][x] = true;
		}
	}
	
	static void print(boolean[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
	
	public static void main (String[] args) throws IOException {
		BufferedReader rr = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(rr.readLine()); 
		t = Integer.parseInt(st.nextToken());
		
		for (int sk = 0; sk < t; sk++) {
			st = new StringTokenizer(rr.readLine()); 
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			list = new int[n];
			
			st = new StringTokenizer(rr.readLine()); 
			for (int i = 0; i < n; i++) {
				list[i] = Integer.parseInt(st.nextToken());
				while (list[i] < 0) list[i] += k * 10;
				list[i] %= k;
			}
			
			long start = System.nanoTime();
		//	System.out.println(Arrays.toString(list));
			
			solve();
		//	print(dp);
			
			boolean res = dp[n - 1][0];
			if (res) System.out.println("Divisible");
			else System.out.println("Not divisible");
		//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		}

		rr.close();
	}
}
