import java.math.BigInteger;
import java.util.Scanner;

public class u10079 { // AC IX
	static BigInteger choose2(int n) {
		BigInteger res = BigInteger.valueOf(n).multiply(BigInteger.valueOf(n - 1)).divide(BigInteger.valueOf(2));
		return res;
	}
	
	static int n;
	
	static BigInteger solve(int n) {
		return choose2(n + 1).add(BigInteger.ONE);
	}
	
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		while (x.hasNextInt()) {
			n = x.nextInt();
			if (n < 0) break;
			System.out.println(solve(n));
		}
	}
}
