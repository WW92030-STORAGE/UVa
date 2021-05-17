import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class u10642 { // AC XIII
	static long triangle(int x) {
		long num = x * (x + 1);
		return num / 2;
	}
	
	static long num(int x, int y) { // 0 0 = 1
		int layer = x + y + 1; // 0 0 is the first layer
		long prev = triangle(layer - 1);
		int slot = (y - x + layer - 1) / 2;
	//	System.out.println(x + " " + y + " " + layer + " " + prev + " " + slot);
		return prev + slot;
	}
	
	static int n, x1, y1, x2, y2;
	
	public static void main (String[] args) throws IOException {
	//	System.out.println(num(0, 1));
		
		BufferedReader rr = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(rr.readLine()); 
		n = Integer.parseInt(st.nextToken());
		
		for (int sk = 0; sk < n; sk++) {
			st = new StringTokenizer(rr.readLine()); 
			
			long start = System.nanoTime();
			y1 = Integer.parseInt(st.nextToken());
			x1 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			
			System.out.println("Case " + (sk + 1) + ": " + (num(x2, y2) - num(x1, y1)));
			
		//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		}

		rr.close();
	}
}
