import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class u01261 { // AC XII
	static TreeSet<String> used = new TreeSet<String>();
	static boolean test(String s) {
		used.clear();
		Queue<String> q = new LinkedList<String>();
		q.add(s);
		while (!q.isEmpty()) {
			String now = q.poll();
			ArrayList<Integer> ind = new ArrayList<Integer>();
			ind.add(0);
			ind.add(now.length());
			for (int i = 0; i < now.length() - 1; i++) {
				if (now.charAt(i) != now.charAt(i + 1)) ind.add(i + 1);
			}
			Collections.sort(ind);
			for (int i = 0; i < ind.size() - 1; i++) {
				if (ind.get(i + 1) - ind.get(i) <= 1) continue;
				String next = now.substring(0, ind.get(i)) + "" + now.substring(ind.get(i + 1));
				if (!used.contains(next)) {
					used.add(next);
					q.add(next);
					if (used.contains("")) return true;
				}
			}
		}
		return used.contains("");
	}
	
	static int n;
	static String s;
	
	public static void main (String[] args) throws IOException {
		BufferedReader rr = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(rr.readLine()); 
		n = Integer.parseInt(st.nextToken());
		
		for (int sk = 0; sk < n; sk++) {
			s = rr.readLine();
			
			long start = System.nanoTime();
			boolean b = test(s);
			if (b) System.out.println(1);
			else System.out.println(0);
			
			System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		}

		rr.close();
	}
}