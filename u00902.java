import java.util.Scanner;
import java.util.TreeMap;

public class u00902 { // AC I
	static TreeMap<String, Integer> map = new TreeMap<String, Integer>();
	
	static void increment(String s) {
		if (!map.containsKey(s)) map.put(s, 0);
		map.put(s, map.get(s) + 1);
	}
	
	static int n;
	static String s;
	
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		while (x.hasNextInt()) {
			n = x.nextInt();
			s = x.next();
			
			map.clear();
			
			String res = s.substring(0, n);
			increment("" + res);
			for (int i = n; i < s.length(); i++) {
				res = res.substring(1, res.length()) + "" + s.charAt(i);
				increment("" + res);
			}
			
		//	System.out.println(map);
			
			int maxval = Integer.MIN_VALUE;
			for (String i : map.keySet()) {
				if (map.get(i) > maxval) {
					maxval = map.get(i);
					res = "" + i;
				}
			}
			
			System.out.println(res);
		}
	}
}
