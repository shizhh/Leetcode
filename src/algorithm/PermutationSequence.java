package algorithm;

import java.util.List;
import java.util.ArrayList;

public class PermutationSequence {
	
	public static String getPermutation(int n, int k) {
		if (n < 0)	return "";
		StringBuilder sb = new StringBuilder();
		int[] factN = new int[n+1];
		factN[0] = 1;
		for (int i = 1; i <= n; i++) {
			factN[i] = factN[i-1] * i;
			sb.append(i);
		}
		if (k < 0 || k > factN[n])	return "";

		String ret = permute(sb.toString(), k, factN);
		return ret;
	}
	
//	@Deprecated
//	public static String getPermutation(int n, int k) {
//        String s = new String();
//        List<String> res = new ArrayList<>();
//        int[] used = new int[n+1];
//        permute(n, k, used, s, res);
//		return res.get(k-1);
//    }
	
	// 超时 timeout
//	@Deprecated
//	public static void permute(int n, int k, int[] used, String s, List<String> res) {
//		if (s.length() == n) {
//			res.add(s);
//			return;
//		}
//		if (k < 0)
//			return;
//		for (int i = 1; i <= n; i++) {
//			if (used[i] == 1)
//				continue;
//			s += String.valueOf(i);
//			used[i] = 1;
//			permute(n, k--, used, s, res);
//			used[i] = 0;
//			s = s.substring(0, s.length() - 1);
//		}
//	}
	
	
	public static String permute(String s, int k, int[] factN) {
		k--;
		int N = s.length();
		StringBuilder sb = new StringBuilder();
		for (int i = N-1; i >= 0; i--) {
			int firstS = k / factN[i];
			k %= factN[i];
			sb.append(s.substring(firstS, firstS+1));
			s = removeS(s, firstS);
			System.out.println(s);
		}
		return sb.toString();
	}
	
	public static String removeS(String s, int index) {
		return s.substring(0, index) + s.substring(index+1);
	}
	
	// n < 10
	public static int factorialN(int n) {
		int ret = 1;
		while (n > 1) {
			ret *= (n--);
		}
		return ret;
	}
	
	
	public static void main(String[] args) {
		String s = getPermutation(4,24);
		System.out.println(s);
		
	}
}
