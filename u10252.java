import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class u10252 { // AC IX
	static TreeMap<Character, Integer> s1 = new TreeMap<Character, Integer>();
	static TreeMap<Character, Integer> s2 = new TreeMap<Character, Integer>();
	static TreeMap<Character, Integer> res = new TreeMap<Character, Integer>();
	
	static TreeSet<Character> chars = new TreeSet<Character>();
	
	static String m, n;
	
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		while (x.hasNextLine()) {
			m = x.nextLine();
			n = x.nextLine();
			
			s1.clear();
			s2.clear();
			res.clear();
			chars.clear();
			
			for (int i = 0; i < m.length(); i++) {
				char c = m.charAt(i);
				if (!s1.containsKey(c)) s1.put(c, 0);
				s1.put(c, s1.get(c) + 1);
				chars.add(c);
			}
			
			for (int i = 0; i < n.length(); i++) {
				char c = n.charAt(i);
				if (!s2.containsKey(c)) s2.put(c, 0);
				s2.put(c, s2.get(c) + 1);
				chars.add(c);
			}
			
			for (char c : chars) {
				if (s1.containsKey(c) && s2.containsKey(c)) res.put(c, Math.min(s1.get(c), s2.get(c)));
			}
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (char c : res.keySet()) {
				int num = res.get(c);
				for (int i = 0; i < num; i++) list.add((int)c);
			}
			
			Collections.sort(list);
			String ans = "";
			for (int i : list) ans = ans + "" + (char)i;
			System.out.println(ans);
		}
	}
}
