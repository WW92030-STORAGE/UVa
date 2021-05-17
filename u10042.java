import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class u10042 {
	static TreeMap<Long, Long> factorize(long x) {
		TreeMap<Long, Long> res = new TreeMap<Long, Long>();
		long i = 2;
		long n = x;
		while (i <= x) {
			if (n % i == 0) {
				long count = 0;
				while (n % i == 0) {
					n /= i;
					count++;
				}
				res.put(i, count);
			}
			i++;
		}
		return res;
	}
	
	static long sum(long x) {
		String s = "" + x;
		long res = 0;
		for (int i = 0; i < s.length(); i++) res += (int)(s.charAt(i)) - (int)'0';
		return res;
	}
	
	static boolean check(int x) {
		TreeMap<Long, Long> map = factorize(x);
		if (map.size() == 1) return false;
		long psum = 0;
		for (long i : map.keySet()) psum += sum(i) * map.get(i);
		return sum(x) == psum;
	}
	
	static int n;
	
	public static void main (String[] args) throws IOException {
		BufferedReader rr = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(rr.readLine()); 
		n = Integer.parseInt(st.nextToken());
		
		long start = System.nanoTime();
		
		int x;
		for (int ii = 0; ii < n; ii++) {
			x = Integer.parseInt(rr.readLine());
			for (int i = x + 1; ; i++) {
				if (check(i)) {
					System.out.println(i);
					break;
				}
			}
		}
		
		System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		rr.close();
	}
}
