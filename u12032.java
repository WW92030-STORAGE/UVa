import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class u12032 { // AC IV
	static int[] pos; // augment with 0 at front
	
	static boolean test(int k) {
		int s = k;
		for (int i = 0; i < pos.length - 1; i++) {
			int d = pos[i + 1] - pos[i];
			if (d == k) k--;
			else if (d > k) return false;
		}
		return true;
	}
	
	static int n, t;
	
	public static void main (String[] args) throws IOException {
		BufferedReader rr = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(rr.readLine()); 
		t = Integer.parseInt(st.nextToken());
		
		for (int sk = 0; sk < t; sk++) {
			st = new StringTokenizer(rr.readLine()); 
			n = Integer.parseInt(st.nextToken());
			
			long start = System.nanoTime();
			
			pos = new int[n + 1];
			st = new StringTokenizer(rr.readLine()); 
			for (int i = 0; i < n; i++) pos[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(pos);
			
			int low = 0;
			int high = 1 << 24;
			
			while (low + 10 < high) {
				int mid = (low + high) / 2;
			//	System.out.println(low + " " + mid + " " + high);
				if (test(mid)) high = mid;
				else low = mid;
			}
			
			int res = 0;
			for (res = Math.max(0, low - 10); res < high + 10; res++) {
				if (test(res)) break;
			}
			
			System.out.println("Case " + (sk + 1) + ": " + res);
			
		//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		}

		rr.close();
	}
}
