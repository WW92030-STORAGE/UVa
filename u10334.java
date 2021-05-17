import java.math.BigInteger;
import java.util.Scanner;

public class u10334 { // AC X
	static BigInteger[] dp;
	
	static void init(int n) {
		dp = new BigInteger[n + 2];
		for (int i = 0; i < 2; i++) dp[i] = BigInteger.valueOf(i);
		for (int i = 2; i < n + 2; i++) dp[i] = dp[i - 2].add(dp[i - 1]);
	}
	
	static int n;
	
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		init(2000);
		while (x.hasNextInt()) {
			n = x.nextInt();
			System.out.println(dp[n + 2]);
		}
	}
}
