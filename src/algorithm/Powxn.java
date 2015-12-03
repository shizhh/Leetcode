package algorithm;

public class Powxn {
	
	public static double myPow(double x, int n) {
		if (n == 0)
			return 1;
		int sign = n >= 0 ? 1 : -1;
		long nl = (long)n * sign;
		int length = logN(nl);
		double[] t = new double[length];
		t[0] = x;
		double result = 1.0;
		for (int i = 1; i < length; i++) {
			t[i] = t[i-1] * t[i-1];
		}
		
		for (int i = 0; i < length; i++)
			if (((nl >> i) & 0x1) == 1) {
				result *= t[i];
			}
		
		return sign == -1 ? 1 / result : result;
	}
	
	public static int logN(long n) {
		int log = 0;
		while (n > 0) {
			n = n / 2;
			log++;
		}
		return log;
	}
	
	public static void main(String[] args) {
		double x = 1;
		int n = -2147483648;
		System.out.println(Math.pow(x, n));
		System.out.println(myPow(x, n));
	}
	
}
