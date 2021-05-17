import java.util.Scanner;

public class u10161 { // AC IX
	static class pair implements Comparable<pair>{
		private int x;
		private int y;
		public pair(int a, int b) {
			x = a;
			y = b;
		}
		
		public void set(int a, int b) {
			x = a;
			y = b;
		}
		
		public void set(pair p) {
			x = p.x;
			y = p.y;
		}
		
		public pair clone() {
			return new pair(this.x, this.y);
		}
		
		public pair invert() {
			return new pair(this.y, this.x);
		}
		
		public int compareTo(pair other) {
			int px = this.x;
			int py = this.y;
			int ox = other.x;
			int oy = other.y;
			if (px != ox) return px - ox;
			if (py != oy) return py - oy;
			return 0;
		}
		
		public boolean equals(pair other) {
			return this.compareTo(other) == 0;
		}
		
		public String toString() {
			return "[" + x + " " + y + "]";
		}
	}
	
	static int sqrtless(int x) {
		int s = (int)Math.sqrt(x);
		if (s * s == x) return s - 1;
		return s;
	}
	
	static pair solve(int n) {
		int layer = sqrtless(n);
		int rem = n - (layer * layer);
		int length = layer * 2 + 1;
	//	System.out.println(layer + " " + rem + " " + length + " " + (length / 2));
		
		pair p = new pair(0, 0);
		if (rem <= length / 2) p.set(layer + 1, rem);
		else p.set(layer + 1 - (rem - layer - 1), layer + 1);
		if (layer % 2 == 1) p = p.invert();
		return p;
	}
	
	static int n;
	
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		while (x.hasNextInt()) {
			n = x.nextInt();
			if (n == 0) break;
			pair res = solve(n);
			System.out.println(res.x + " " + res.y);
		}
	}
}
