import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class u11581 { // AC IV
	static class grid implements Comparable<grid> {
		private int[][] board;
		
		public grid(int[][] grid) {
			board = grid.clone();
		}
		
		public grid clone() {
			int[][] g0 = new int[board.length][board[0].length];
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) g0[i][j] = board[i][j];
			}
			return new grid(g0);
		}
		
		public int compareTo(grid other) {
			int[][] ox = other.board;
			if (board.length != ox.length) return board.length - ox.length;
			if (board[0].length != ox[0].length) return board[0].length - ox[0].length;
			
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] != ox[i][j]) return board[i][j] - ox[i][j];
				}
			}
			return 0;
		}
		
		public boolean equals(grid other) {
			return this.compareTo(other) == 0;
		}
		
		public boolean inBounds(int x, int y) {
			if (x < 0 || x >= board.length) return false;
			if (y < 0 || y >= board[x].length) return false;
			return true;
		}
		
		public String toString() {
			String res = "";
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) res = res + board[i][j] + " ";
				if (i < board.length - 1) res = res + "\n";
			}
			return res;
		}
	}
	
	static TreeMap<grid, Integer> map = new TreeMap<grid, Integer>();
	
	static grid next(grid g) {
		int[][] h = new int[g.board.length][g.board[0].length];
		int[] dx = {01, 00, -1, 00};
		int[] dy = {00, 01, 00, -1};
		for (int i = 0; i < g.board.length; i++) {
			for (int j = 0; j < g.board[i].length; j++) {
				int sum = 0;
				for (int k = 0; k < 4; k++) {
					int xp = i + dx[k];
					int yp = j + dy[k];
					if (g.inBounds(xp, yp)) sum += g.board[xp][yp];
				}
				h[i][j] = sum % 2;
			}
		}
		return new grid(h);
	}
	
	static int solve(grid g) {
		map.clear();
		int i = 0;
		while (!map.containsKey(g)) {
			map.put(g, i);
			i++;
			g = next(g);
		}
		return map.get(g) - 1;
	}
	
	static int n;
	static grid g;
	
	public static void main (String[] args) throws IOException {
		Scanner x = new Scanner(System.in);
		n = x.nextInt();
		
		int[][] arr = new int[3][3];
		for (int sk = 0; sk < n; sk++) {
			for (int i = 0; i < 3; i++) {
				int line = x.nextInt();
				arr[i][0] = (line / 100) % 10;
				arr[i][1] = (line / 10) % 10;
				arr[i][2] = line % 10;
			}
			
			long start = System.nanoTime();
			
			g = new grid(arr);
		//	System.out.println(g);
			
			System.out.println(solve(g));
			
		//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		}
	}
}
