import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class u11450_TOPDOWN { // AC II
	// buy one from each row and maximize the cost within budget
	static TreeMap<Integer, ArrayList<Integer>> list = new TreeMap<Integer, ArrayList<Integer>>();
	
	static void push(int k, int v) {
		if (!list.containsKey(k)) list.put(k, new ArrayList<Integer>());
		list.get(k).add(v);
	}
	
	static void sort() {
		for (int i : list.keySet()) Collections.sort(list.get(i));
	}
	
	static int t, m, n, x;
	
	static int[][] dp;
	
	static int solve(int x, int y) { // x moneys left and y objects bought
		if (x < 0) return Integer.MIN_VALUE; // cant afford
		if (y == n) return m - x; // net balance after everything
		if (dp[x][y] != -1) return dp[x][y]; // gotta go fast
		
		int res = -1;
		ArrayList<Integer> prices = list.get(y);
		for (int test : prices) res = Math.max(res, solve(x - test, y + 1));
		dp[x][y] = res;
		return res;
	}
	
	public static void main (String[] args) throws IOException {
		BufferedReader rr = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(rr.readLine()); 
		t = Integer.parseInt(st.nextToken());
		
		for (int sk = 0; sk < t; sk++) {
			list.clear();
			st = new StringTokenizer(rr.readLine()); 
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			long start = System.nanoTime();
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(rr.readLine()); 
				x = Integer.parseInt(st.nextToken());
				for (int k = 0; k < x; k++) push(i, Integer.parseInt(st.nextToken()));
			}
			
			sort();
			
		//	System.out.println(list);
			
			dp = new int[m + 2][n + 2];
			for (int[] row : dp) Arrays.fill(row, -1);
			
			int res = solve(m, 0);
			if (res >= 0) System.out.println(res);
			else System.out.println("no solution");
			
		//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		}

		rr.close();
	}
}
