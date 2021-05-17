import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class u11935 { // AC II
	static class triple implements Comparable<triple>{
		private int x;
		private int y;
		private int z;
		public triple(int a, int b, int c) {
			x = a;
			y = b;
			z = c;
		}
		
		public void set(int a, int b, int c) {
			x = a;
			y = b;
			z = c;
		}
		
		public int compareTo(triple other) {
			int px = this.x;
			int py = this.y;
			int pz = this.z;
			int ox = other.x;
			int oy = other.y;
			int oz = other.z;
			if (px != ox) return px - ox;
			if (py != oy) return py - oy;
			if (pz != oz) return pz - oz;
			return 0;
		}
		
		public boolean equals(triple other) {
			return this.compareTo(other) == 0;
		}
		
		public String toString() {
			return "[" + x + " " + y + " " + z + "]";
		}
	}
	
	static ArrayList<triple> events = new ArrayList<triple>();
	// x = time (to be sorted by)
	// y = event. 0 = consume 1 = leak 2 = gas 3 = mekanik 4 = goal
	// z = value for each event. 0 default
	
	static boolean test(double inventory) {
		double inv = inventory + 0.0;
		int con = 0;
		int leak = 0;
		for (int i = 0; i < events.size() - 1; i++) {
			triple now = events.get(i);
			triple next = events.get(i + 1);
			int dist = next.x - now.x;
			switch (now.y) {
			case 0:
				con = now.z;
				break;
			case 1:
				leak++;
				break;
			case 2:
				inv = inventory;
				break;
			case 3:
				leak = 0;
				break;
			case 4:
				return true;
			}
			
			inv -= leak * dist;
			inv -= dist * (double)con / 100.0;
			if (inv <= 0) return false;
		}
		return true;
	}
	
	static int transcribe(String s) {
		s = s.toLowerCase();
		if (s.equals("consumption")) return 0;
		if (s.equals("leak")) return 1;
		if (s.equals("station")) return 2;
		if (s.equals("mechanic")) return 3;
		if (s.equals("goal")) return 4;
		return -1;
	}
	
	static double solve(double low, double high) {
		while (low + 0.00001 < high) {
			double mid = (low + high) / 2.0;
		//	System.out.println(low + " " + mid + " " + high);
			boolean works = test(mid);
			if (works) high = mid;
			else low = mid;
		}
		return high;
	}
	
	static String format(String s) {
		while (s.indexOf(".") >= s.length() - 3) s = s + "0";
		return s;
	}
	
	public static void main (String[] args) throws IOException {
		BufferedReader rr = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		int time = (int)(Math.random() * (1 << 30));
		String event = "";
		int code = (int)(Math.random() * (1 << 30));
		int value = (int)(Math.random() * (1 << 30));
		boolean end = false;
		while (true) {
			events.clear();
			while (true) {
				st = new StringTokenizer(rr.readLine());
				time = Integer.parseInt(st.nextToken());
				event = st.nextToken();
				if (event.equals("Fuel") || event.equals("Gas")) event = st.nextToken();
				code = transcribe(event);
				if (code == 0) value = Integer.parseInt(st.nextToken());
				else value = -1;
				if (time == 0 && value == 0 && code == 0) {
					end = true;
					break;
				} // insert condition here
			//	System.out.println(time + " " + event + " " + value);
				events.add(new triple(time, code, value));
				if (code == 4) break;
			}
			if (end) break;
			
			long start = System.nanoTime();
			
		//	System.out.println(events);
			
			double inv = solve(0, Integer.MAX_VALUE);
			double res = (double)((int)(inv * 1000)) / 1000;
			System.out.println(format("" + res));
			
		//	System.out.println("ELAPSED " + (System.nanoTime() - start) / 1000000);
		}

		rr.close();
	}
}
