import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class u00613 { // AC XII
	static String inv(String s) {
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) map.put(c, 0);
			map.put(c, map.get(c) + 1);
		}
		String res = "";
		for (char c : map.keySet()) res = res + "" + map.get(c) + "" + c;
		return res;
	}
	
	static String n, original;
	
	public static void main (String[] args) throws IOException {
		BufferedReader rr = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(rr.readLine());
			n = st.nextToken();
			original = "" + n;
			
			BigInteger b = new BigInteger(n);
			if (b.compareTo(BigInteger.ZERO) < 0) break; // insert condition here
			
			long start = System.nanoTime();
			
			TreeMap<String, Integer> index = new TreeMap<String, Integer>();
			index.put("" + n, 0);
			int loop = -1;
			boolean immediate = true;
			int i = 0;
			for (i = 1; i < 16; i++) {
				n = inv(n);
				if (index.containsKey(n)) {
					loop = i - index.get(n);
					break;
				}
				index.put("" + n, i);
				immediate = false;
			}
			
			if (loop < 0) System.out.println(original + " can not be classified after 15 iterations");
			else if (loop == 1) {
				if (immediate) System.out.println(original + " is self-inventorying");
				else System.out.println(original + " is self-inventorying after " + (i - 1) + " steps");
			}
			else System.out.println(original + " enters an inventory loop of length " + loop);
			
		//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		}

		rr.close();
	}
}
