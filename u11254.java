import java.io.IOException;
import java.util.Scanner;

public class u11254 { // AC
	static int n, r;
	static double a;
	static boolean check(int n, int r) {
		a = (2.0 * n + r - Math.pow(r, 2)) / (2.0 * r);
		if (a < 0) return false;
		return (Math.floor(a) == a);
	}
	
	public static void main (String[] args) throws IOException {
		Scanner x = new Scanner(System.in);
		while (x.hasNextInt()) {
			n = x.nextInt();
			if (n < 0) break;
			
			long start = System.nanoTime();
			
			for (r = (int)Math.ceil(Math.sqrt(2 * n)); r > 0; r--) {
				if (check(n, r)) break;
			}
			
		//	System.out.println(a + " " + r);
			if (a == 0) {
				a++;
				r--;
			}
			System.out.println(n + " = " + (int)a + " + ... + " + (int)(a + r - 1));
			
		//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		}
	}
}
