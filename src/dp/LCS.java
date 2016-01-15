package dp;

public class LCS {
	
	public static void LCS_Length(String s, String p, String[][] b, int[][] c) {
		int m = s.length();
		int n = p.length();
		char[] cs = s.toCharArray();
		char[] cp = p.toCharArray();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (cs[i] == cp[j]) {
					c[i+1][j+1] = c[i][j]+1;
					b[i][j] = "\\";
				}
				else if (c[i][j+1] >= c[i+1][j]) {
					c[i+1][j+1] = c[i][j+1];
					b[i][j] = "^";
				}
				else {
					c[i+1][j+1] = c[i+1][j];
					b[i][j] = "<";
				}
			}
		}
	}
	
	public static void print_LCS(String[][] b, String s, int i, int j) {
		if (i == -1 || j == -1)
			return;
		if (b[i][j] == "\\") {
			print_LCS(b, s, i-1, j-1);
			System.out.print(s.charAt(i));
		}else if (b[i][j] == "^") 
			print_LCS(b, s, i-1, j);
		else print_LCS(b, s, i, j-1);
	}
	
	public static void main(String[] args) {
		String s = "ABCBDAB";
		String p = "BDCABA";
		int m = s.length();
		int n = p.length();
		String[][] b = new String[m][n];
		int[][] c = new int[m+1][n+1];
		LCS_Length(s, p, b, c);
		print_LCS(b, s, m-1, n-1);
	}
}
