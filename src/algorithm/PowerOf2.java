package algorithm;

public class PowerOf2 {
	
	public static boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;
		while ((n & 0x1) == 0) {
			n = n >> 1;
		}
		if (n == 1)
			return true;
		else {
			return false;
		}
	}
	
	public static boolean isPowerOf2(int n) {
		if (n <= 0) {
			return false;
		}
		return (n&(n-1)) == 0;
	}
	
	public static void main(String[] args) {
		int n = 10348384;
		boolean fg = isPowerOf2(n);
		System.out.println(fg);
	}
}
