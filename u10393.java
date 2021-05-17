import java.util.Scanner;
import java.util.TreeSet;

public class u10393 { // AC XIII
	static char[][] chars = 
		{{'q', 'a', 'z'}, {'w', 's', 'x'}, 
				{'e', 'd', 'c'}, 
				{'r', 'f', 'v', 't', 'g', 'b'},
				{' '}, {' '},
				{'y', 'h', 'n', 'u', 'j', 'm'},
				{'i', 'k', ','}, {'o', 'l', '.'}, 
				{'p', ';', '/'}
		};
	
	static TreeSet<Character> set = new TreeSet<Character>();
	static TreeSet<Integer> removed = new TreeSet<Integer>();
	static TreeSet<String> list = new TreeSet<String>();
	static TreeSet<String> res = new TreeSet<String>();
	static TreeSet<String> ans = new TreeSet<String>();
	
	static int n, m;
	
	static boolean check(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!set.contains(s.charAt(i))) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		while (x.hasNextInt()) {
			m = x.nextInt();
			n = x.nextInt();
			set.clear();
			removed.clear();
			list.clear();
			res.clear();
			ans.clear();
			
			for (int i = 0; i < m; i++) removed.add(x.nextInt() - 1);
			x.nextLine(); // i hate it when i have to do this
			for (int i = 0; i < n; i++) list.add(x.nextLine());
			
			for (int i = 0; i < 9; i++) {
				if (removed.contains(i)) continue;
				for (char c : chars[i]) set.add(c);
			}
			
			int maxlength = Integer.MIN_VALUE;
			for (String s : list) if (check(s)) {
				res.add(s);
				maxlength = Math.max(maxlength, s.length());
			}
			
			for (String s : res) if (s.length() == maxlength) ans.add(s);
			
			String out = "" + ans.size();
			for (String s : ans) out = out + "\n" + s;
			System.out.println(out); // fast output hack
		}
	}
}
