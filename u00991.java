import java.util.Scanner;

public class u00991 { // AC XII
	static int[][] dp;
	
	static void init(int size) {
		dp = new int[size + 1][size + 1];
		for (int i = 0; i <= size; i++) dp[i][0] = dp[i][i] = 1;
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j < i; j++) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
		}
	}
	
	static int cat(int n) {
		return dp[2 * n][n] / (n + 1);
	}
	
	public static void main(String[] args) {
		init(100);
		Scanner x = new Scanner(System.in);
		boolean xx = true;
		while (x.hasNextLine()) {
			if (xx) xx = false;
			else System.out.println();
			System.out.println(cat(x.nextInt()));
			try {
				x.nextLine();
			}
			catch (Exception e) {
				break;
			}
		}
	}
}
