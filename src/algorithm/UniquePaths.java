package algorithm;

public class UniquePaths {
	public static void main(String[] args) {
		UniquePaths main = new UniquePaths();
		int result = main.uniquePaths(2, 2);
		System.out.print(result);
	}
	public int uniquePaths(int m, int n) {
		int tmp = m;
		m = m > n ? m :n;
		n = tmp > n ? n : tmp;
		if (n <= 1) return 1;
		int k = n -1;
		int r = m + n - 1;
		long result_a = 1L;
		while ((k--) > 0) {
			result_a *= (long)(--r);
		}
		long result_b = 1L;
		k = n - 1;
		while(k>0) {
			result_b *= (long)(k);
			k--;
		}
		System.out.println(result_a);
		System.out.println(result_b);
		return (int)(result_a / result_b);
	}
	
}
