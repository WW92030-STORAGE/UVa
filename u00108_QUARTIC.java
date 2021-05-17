import java.util.Scanner;

public class u00108_QUARTIC { // AC
	static int[][] grid;
	static int[][] psum;
	static int n;
	
	static int query(int x1, int y1, int x2, int y2) {
		int box1 = psum[x2 + 1][y2 + 1];
		int box2 = psum[x1][y1];
		int box3 = psum[x1][y2 + 1];
		int box4 = psum[x2 + 1][y1];
		return box1 + box2 - box3 - box4;
	}
	
	static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		n = x.nextInt();
		grid = new int[n][n];
		psum = new int[n + 1][n + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) grid[i][j] = x.nextInt();
		}
		
		psum[1][1] = grid[0][0];
		for (int i = 0; i < n; i++) {
			psum[i + 1][1] = psum[i][1] + grid[i][0];
			psum[1][i + 1] = psum[1][i] + grid[0][i];
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				psum[i + 1][j + 1] = grid[i][j] + psum[i + 1][j] + psum[i][j + 1] - psum[i][j];
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int x1 = 0; x1 < n; x1++) {
			for (int x2 = x1; x2 < n; x2++) {
				for (int y1 = 0; y1 < n; y1++) {
					for (int y2 = y1; y2 < n; y2++) {
						max = Math.max(max, query(x1, y1, x2, y2));
					}
				}
			}
		}
		
		System.out.println(max);
	}
}
