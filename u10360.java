import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class u10360 { // AC X
	static int[][] psum(int[][] arr) { // must be a rectangle
		int[][] res = new int[arr.length + 1][arr[0].length + 1];
		res[1][1] = arr[0][0];
		for (int i = 1; i < arr.length; i++) res[i + 1][1] = res[i][1] + arr[i][0];
		for (int i = 1; i < arr[0].length; i++) res[1][i + 1] = res[1][i] + arr[0][i];
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) res[i + 1][j + 1] = arr[i][j] + res[i + 1][j] + res[i][j + 1] - res[i][j];
		}
		return res;
	}
	
	static int query(int[][] psum, int x1, int y1, int x2, int y2) {
		int box1 = psum[x2 + 1][y2 + 1];
		int box2 = psum[x1][y1];
		int box3 = psum[x1][y2 + 1];
		int box4 = psum[x2 + 1][y1];
		return box1 + box2 - box3 - box4;
	}
	
	static int[][] grid;
	static int[][] psum;
	
	static int t, n, d;
	static final int size = 1500;
	
	static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
	
	public static void main (String[] args) throws IOException {
		BufferedReader rr = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(rr.readLine()); 
		t = Integer.parseInt(st.nextToken());
		
		for (int sk = 0; sk < t; sk++) {
			d = Integer.parseInt(rr.readLine());
			n = Integer.parseInt(rr.readLine());
			
			long start = System.nanoTime();
			
			grid = new int[size][size];
			int x, y, s;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(rr.readLine()); 
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				s = Integer.parseInt(st.nextToken());
				grid[x][y] = s;
			}
			
			psum = psum(grid);
		//	print(grid);
		//	print(psum);
			
			int max = Integer.MIN_VALUE;
			int xp = 0;
			int yp = 0;
			for (int i = d; i < size - d; i++) {
				for (int j = d; j < size - d; j++) {
					int x1 = i - d;
					int x2 = i + d;
					int y1 = j - d;
					int y2 = j + d;
					int query = query(psum, x1, y1, x2, y2);
					if (query > max) {
						max = query;
						xp = i;
						yp = j;
					}
				}
			}
			
			System.out.println(xp + " " + yp + " " + max);
			
			System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		}

		rr.close();
	}
}
