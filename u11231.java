import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class u11231 { // AC
	static int query(int m, int n) { // given that the bottom right square is white
		int area = m * n;
		if (area % 2 == 0) return area / 2;
		return (area + 1) / 2;
	}
	
	static int m, n, c;
	
	public static void main (String[] args) throws IOException {
		BufferedReader rr = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(rr.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if (n == 0 && m == 0 && c == 0) break; // insert condition here
			
			long start = System.nanoTime();
			
			long res = 0;
			if (c == 1) res = query(n - 7, m - 7);
			else {
				int box = query(n - 7, m - 8);
				int edge = query(n - 8, 1);
				res = box + edge;
			}
			
			System.out.println(res);
			
		//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		}

		rr.close();
	}
}
