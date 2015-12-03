package algorithm;

public class MultiplyStrings {
	
	public static String multiply(String num1, String num2) {
		int length1 = num1.length();
		int length2 = num2.length();
		if (length1 < 1 || length2 < 1 || num1.equals("0") || num2.equals("0"))
			return "0";
		
		
		int[] t1 = new int[length1];
		int[] t2 = new int[length2];
		int[] result = new int[length1 + length2];
		for (int i = length1 - 1; i >= 0; i--) {
			int t = Integer.valueOf(num1.substring(i, i+1));
			t1[length1-1-i] = t;
		}
		//show(t1);
		//System.out.println("----------------------");
		for (int i = length2 - 1; i >= 0; i--) {
			int t = Integer.valueOf(num2.substring(i, i+1));
			t2[length2-1-i] = t;
		}
		//show(t2);
		
		for (int i = 0; i < length1; i++) {
			for (int j = 0; j < length2; j++) {
				result[i + j] += t1[i] * t2[j];
			}
		}
		//show(result);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length - 1; i++) {
			int r = result[i] % 10;
			int p = result[i] / 10;
			result[i] = r;
			sb.insert(0, result[i]);
			if (p > 0) {
				result[i + 1] += p;
				if (i + 1 == result.length - 1) {
					sb.insert(0, p);
				}
			}
		}
		return sb.toString();
	}
	
	public static void show(int[] a) {
		for (int i : a) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		String num1 = "96346546463634634643463463463436436436536443636363469";
		String num2 = "1856364663633464363456346343464363443643656634634640";
		String result = multiply(num1, num2);
		System.out.println(result);
		System.out.println(result.length());
	}
}
