import java.math.BigInteger;
import java.util.Scanner;

public class u11401 { // AC II 
	// F(n) = (n - 3) + (n - 5) + ... all positive terms
	// to see why it is as follows
	// n is the longest side
	// n - k 2nd longest
	// and finally from k + 1 to n - k - 1 is the shortest
	// F(n) + F(n - 1) = C(n - 2) (2)
	
	static long[] dp;
	static long[] psum;
	
	static void init(int n) {
		dp = new long[n + 2];
		dp[0] = dp[1] = dp[2] = dp[3] = 0;
		dp[4] = 1;
		for (int i = 5; i < n + 2; i++) dp[i] = choose2(i - 2) - dp[i - 1];
		
		psum = new long[n + 3];
		psum[0] = 0;
		for (int i = 1; i < psum.length; i++) {
			psum[i] = psum[i - 1] + dp[i - 1];
		}
	}
	
	static long choose2(int n) {
		BigInteger res = BigInteger.valueOf(n).multiply(BigInteger.valueOf(n - 1)).divide(BigInteger.valueOf(2));
		return res.longValue();
	}
	
	static int n;
	
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		long start = System.nanoTime();
		init(1000001);
	//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		while (x.hasNextInt()) {
			n = x.nextInt();
			if (n < 3) break;
			System.out.println(psum[n + 1]);
		}
	}
}
