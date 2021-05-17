import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class u10784 { // AC XIV
	static long diagonals(long n) {
		return n * (n - 3) / 2;
	}
	
	static long n;
	
	public static void main (String[] args) throws IOException {
		BufferedReader rr = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		int sk = 0;
		while (true) {
			st = new StringTokenizer(rr.readLine()); 
			n = Long.parseLong(st.nextToken());
			if (n == 0) break;
			
			long start = System.nanoTime();
			
			long min = 3;
			long max = Integer.MAX_VALUE;
			long mid = (min + max) / 2;
			boolean exact = false;
			while (min + 50 < max) {
				mid = (min + max) / 2;
			//	System.out.println(min + " " + max + " " + mid);
				long d = diagonals(mid);
				if (d < n) min = mid;
				if (d > n) max = mid;
				if (d == n) {
					exact = true;
					break;
				}
			}
			if (exact) System.out.println("Case " + (sk + 1) + ": " + mid);
			else {
				for (long i = Math.max(3, min - 100); i <= max + 100; i++) {
					if (diagonals(i) >= n) {
						System.out.println("Case " + (sk + 1) + ": " + i);
						break;
					}
				}
				
			}
			
			sk++;
			
		//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		}

		rr.close();
	} 
}
