import java.math.BigInteger;
import java.util.Scanner;

public class u11310 { // AC
	static BigInteger[] dp;
	
	static BigInteger x(long n) {
		return BigInteger.valueOf(n);
	}
	
	static void init(int n) {
		dp = new BigInteger[n + 2];
		dp[0] = BigInteger.ONE;
		dp[1] = BigInteger.ONE;
		dp[2] = x(5);
		for (int i = 3; i < n + 2; i++) {
			BigInteger row = x(1).multiply(dp[i - 1]);
			BigInteger square = x(4).multiply(dp[i - 2]);
			BigInteger rect = x(2).multiply(dp[i - 3]);
			dp[i] = row.add(square.add(rect));
		}
	}
	
	static int n;
	
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		init(2000);
		n = x.nextInt();
		while (x.hasNextInt()) {
			n = x.nextInt();
			System.out.println(dp[n]);
		}
	}	
}
