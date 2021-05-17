import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class u11292 { // AC
	static ArrayList<Integer> sizes = new ArrayList<Integer>();
	static ArrayList<Integer> diameters = new ArrayList<Integer>();
	
	static int n, d;
	
	public static void main (String[] args) throws IOException {
		BufferedReader rr = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(rr.readLine());
			d = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			if (n == 0 && d == 0) break; // insert condition here
			
			sizes.clear();
			diameters.clear();
			for (int i = 0; i < d; i++) diameters.add(Integer.parseInt(rr.readLine()));
			for (int i = 0; i < n; i++) sizes.add(Integer.parseInt(rr.readLine()));
			
			Collections.sort(sizes);
			Collections.sort(diameters);
		//	System.out.println(sizes + "\n" + diameters);
			
			long start = System.nanoTime();
			
			int sum = 0;
			boolean good = true;
			int ind = 0;
			for (int i = 0; i < d; i++) {
				int diam = diameters.get(i);
				while (ind < n && sizes.get(ind) < diam) ind++;
				if (ind >= n) {
					good = false;
					break;
				}
				sum += sizes.get(ind);
				ind++; // no repeats
			}
			
			if (good) System.out.println(sum);
			else System.out.println("Loowater is doomed!");
		//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		}

		rr.close();
	}
}
