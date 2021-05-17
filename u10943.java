import java.util.Scanner;

public class u10943 { // AC XV
	static int[][] dp;
	
	static void init(int size) {
		dp = new int[size + 1][size + 1];
		for (int i = 0; i <= size; i++) dp[i][0] = dp[i][i] = 1;
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j < i; j++) dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 1000000;
		}
	}
	
	static int n, k;
	
	public static void main(String[] args) {
		init(1000);
		
		Scanner x = new Scanner(System.in);
		while (x.hasNextInt()) {
			n = x.nextInt();
			k = x.nextInt();
			if (n == 0 && k == 0) break;
			System.out.println(dp[n + k - 1][k - 1]);
		}
	}
}
