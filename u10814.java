import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class u10814 { // AC XV
	static BigInteger gcd(BigInteger a, BigInteger b) {
		if (a.compareTo(b) < 0) {
			BigInteger temp = new BigInteger(a.toString());
			a = new BigInteger(b.toString());
			b = new BigInteger(temp.toString());
		}
		if (b.equals(BigInteger.ZERO)) return new BigInteger(a.toString());
		return gcd(a.remainder(b), new BigInteger(b.toString()));
	}
	
	static int t;
	static BigInteger n, d;
	
	public static void main (String[] args) throws IOException {
		BufferedReader rr = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(rr.readLine()); 
		t = Integer.parseInt(st.nextToken());
		
		for (int sk = 0; sk < t; sk++) {
			st = new StringTokenizer(rr.readLine()); 
			n = new BigInteger(st.nextToken());
			st.nextToken();
			d = new BigInteger(st.nextToken());
			
			long start = System.nanoTime();
			
			BigInteger g = gcd(n, d);
			n = n.divide(g);
			d = d.divide(g);
			System.out.println(n + " / " + d);
			
		//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		}

		rr.close();
	}
}
