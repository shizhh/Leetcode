package algorithm;

public class WildcardMatching {
	
	public static boolean isMatch(String s, String p) {
		int st = 0, pt = 0, starIndex = -1, match = 0;
		while (st < s.length()) {
			if (pt < p.length() && (s.charAt(st) == p.charAt(pt) || p.charAt(pt) == '?')) {
				st++;
				pt++;
			}
			else if (pt < p.length() && p.charAt(pt) == '*') {
				match = st;
				starIndex = pt;
				pt++;
			}
			else if (starIndex != -1) {
				pt = starIndex + 1;
				match++;
				st = match;
			}
			else return false;
		}
		
		while (pt < p.length() && p.charAt(pt) == '*') {
			pt++;
		}
		return pt == p.length();
	}
	
	public static boolean isMatch2(String s, String p) {
		int sl = s.length();
		int pl = p.length();
		boolean[][] a = new boolean[sl+1][pl+1];
		a[0][0] = true;
		for (int i = 0; i < pl; i++) {
			a[0][i+1] = p.charAt(i) == '*' ? a[0][i] : false;
		}
		for (int i = 1; i <= sl; i++) {
			a[i][0] = false;
		}
		for (int i = 0; i < sl; i++) {
			for (int j = 0; j < pl; j++) {
				if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
					a[i+1][j+1] = a[i][j];
				}
				else if (p.charAt(j) == '*') {
					a[i+1][j+1] = a[i+1][j] || a[i][j+1];
				}
				else a[i+1][j+1] = false;
			}
		}
		return a[sl][pl];
	}
	
	public static void main(String[] args) {
		String s = "aa";
		String p = "*";
		boolean fa = isMatch2(s, p);
		System.out.println(fa);
	}
}
