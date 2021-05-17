import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class u12036 { // AC IV
	static HashMap<Integer, Integer> multiset = new HashMap<Integer, Integer>();
	
	static void increment(int i) {
		if (!multiset.containsKey(i)) multiset.put(i, 0);
		multiset.put(i, multiset.get(i) + 1);
	}
	
	static int n, t;
	
	public static void main (String[] args) throws IOException {
		BufferedReader rr = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(rr.readLine()); 
		t = Integer.parseInt(st.nextToken());
		
		for (int sk = 0; sk < t; sk++) {
			st = new StringTokenizer(rr.readLine()); 
			n = Integer.parseInt(st.nextToken());
			multiset.clear();
			
			long start = System.nanoTime();
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(rr.readLine()); 
				for (int j = 0; j < n; j++) {
					int x = Integer.parseInt(st.nextToken());
					increment(x);
				}
			}
			
			boolean good = true;
			for (int i : multiset.keySet()) {
				if (multiset.get(i) > n) {
					good = false;
					break;
				}
			}
			
			if (good) System.out.println("Case " + (sk + 1) + ": yes");
			else System.out.println("Case " + (sk + 1) + ": no");
			
		//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		}

		rr.close();
	}
}
