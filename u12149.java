import java.io.IOException;
import java.util.Scanner;

public class u12149 { // AC III
	static int n;
	
	public static void main (String[] args) throws IOException {
		Scanner x = new Scanner(System.in);
		while (x.hasNextLine()) {
			n = x.nextInt();
			if (n == 0) break;
			
			long start = System.nanoTime();
			
			long res = 0;
			for (int i = n; i > 0; i--) res += i * i;
			System.out.println(res);
			
		//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		}
	}
}
