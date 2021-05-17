import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class u00616 { // AC I
	static boolean test(long n, long p) {
		for (long i = 0; i < p; i++) {
			if (n % p != 1) return false;
			n = (n - 1) * (p - 1) / p;
		}
		return n % p == 0;
	}
	
	public static void main (String[] args) throws IOException {
		BufferedReader rr = new BufferedReader(new InputStreamReader(System.in)); 
		
		while (true) {
			long n = Long.parseLong(rr.readLine());
			if (n == -1) break;
			long start = System.nanoTime();
			
			boolean found = false;
			for (long i = (long)Math.ceil(Math.sqrt(n)); i > 0; i--) {
				if (test(n, i)) {
					found = true;
					System.out.println(n + " coconuts, " + i + " people and 1 monkey");
					break;
				}
			}
			
			if (!found) System.out.println(n + " coconuts, no solution");
			
		//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		}
		
		rr.close();
	}
}
