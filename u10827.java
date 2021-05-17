import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class u10827 { // AC XV
	static int[][] grid;
	static int[][] psum;
	
	static int n, t;
	
	static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
	
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
	
	public static void main (String[] args) throws IOException {
		BufferedReader rr = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(rr.readLine()); 
		t = Integer.parseInt(st.nextToken());
		
		for (int sk = 0; sk < t; sk++) {
			st = new StringTokenizer(rr.readLine()); 
			n = Integer.parseInt(st.nextToken()) * 2;
			
			long start = System.nanoTime();
			
			grid = new int[n][n];
			
			for (int i = 0; i < n / 2; i++) {
				st = new StringTokenizer(rr.readLine()); 
				for (int j = 0; j < n / 2; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					grid[i + n / 2][j + n / 2] = grid[i + n / 2][j] = grid[i][j + n / 2] = grid[i][j];
				}
			}
			
			psum = psum(grid);
			
		//	print(psum);
			
			int max = Integer.MIN_VALUE;
			for (int x1 = 0; x1 < n / 2; x1++) {
				for (int x2 = x1; x2 < x1 + n / 2; x2++) {
					for (int y1 = 0; y1 < n / 2; y1++) {
						for (int y2 = y1; y2 < y1 + n / 2; y2++) max = Math.max(max, query(psum, x1, y1, x2, y2));
					}
				}
			}
			
			System.out.println(max);
		//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		}

		rr.close();
	}
	
}
