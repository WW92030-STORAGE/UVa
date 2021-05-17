import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class u12100 { // AC III
	static TreeMap<Integer, Integer> multiset = new TreeMap<Integer, Integer>();
	
	static int add(int x) {
		if (!multiset.containsKey(x)) multiset.put(x, 1);
		else multiset.put(x, multiset.get(x) + 1);
		return x;
	}
	
	static int remove(int x) {
		multiset.put(x, multiset.get(x) - 1);
		if (multiset.get(x) <= 0) multiset.remove(x);
		return x;
	}
	
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	static int n, t;
	static int pos;
	
	public static void main (String[] args) throws IOException {
		BufferedReader rr = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(rr.readLine()); 
		t = Integer.parseInt(st.nextToken());
		
		for (int sk = 0; sk < t; sk++) {
			queue.clear();
			multiset.clear();
			st = new StringTokenizer(rr.readLine()); 
			n = Integer.parseInt(st.nextToken());
			pos = Integer.parseInt(st.nextToken());
			
			long start = System.nanoTime();
			
			st = new StringTokenizer(rr.readLine()); 
			for (int i = 0; i < n; i++) {
				int x = Integer.parseInt(st.nextToken());
				queue.add(x);
				add(x);
			}
			
			int res = 0;
			while (!queue.isEmpty() && pos >= 0) {
				int x = queue.poll();
				res++;
				pos--;
				remove(x);
				if (queue.isEmpty() || multiset.isEmpty()) break;
				int max = multiset.lastKey();
				if (max > x) {
					add(x);
					queue.add(x);
					if (pos == -1) pos = queue.size() - 1;
					res--;
				}
			//	System.out.println("POS " + pos + "\n" + multiset + "\n" + queue);
			}
			
			System.out.println(res);
			
		//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		}

		rr.close();
	}
}
