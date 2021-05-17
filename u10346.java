import java.util.Scanner;

public class u10346 { // AC X
	static int solve(int n, int k) {
		int count = 0;
		int inv = n;
		while (inv >= k) {
			inv -= k;
			inv++;
			count += k;
		}
		count += inv;
		return count;
	}
	
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		while (x.hasNextInt()) System.out.println(solve(x.nextInt(), x.nextInt()));
	}
}
