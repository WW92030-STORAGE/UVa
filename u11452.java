import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class u11452 { // AC V
	static int period(String s) {
		for (int i = (int)Math.ceil((double)s.length() / 3.0); 2 * i <= s.length(); i++) {
			String one = s.substring(0, i);
			String two = s.substring(i, 2 * i);
			if (one.equals(two)) return i;
		}
		return 0;
	}
	
	static int n;
	static String s;
	static int length = 8;
	
	public static void main (String[] args) throws IOException {
		BufferedReader rr = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(rr.readLine()); 
		n = Integer.parseInt(st.nextToken());
		
		long start = System.nanoTime();
		
		for (int sk = 0; sk < n; sk++) {
			s = rr.readLine();
			int p = period(s);
			String res = "";
			for (int i = s.length(); i < s.length() + length; i++) {
				res = res + "" + s.charAt(i % p);
			}
			res = res + "...";
			System.out.println(res);
		}
		
	//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		rr.close();
	}
}
