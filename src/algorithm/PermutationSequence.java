package algorithm;

import java.util.List;
import java.util.ArrayList;

public class PermutationSequence {
	
	public static String getPermutation(int n, int k) {
        String sb = new String();
        List<String> res = new ArrayList<>();
        int[] used = new int[n+1];
        permute(n, k, used, sb, res);
		return res.get(k-1);
    }
	
	public static void permute(int n, int k, int[] used, String s, List<String> res) {
		if (s.length() == n) {
			res.add(s);
			return;
		}
		if (k < 0)
			return;
		for (int i = 1; i <= n; i++) {
			if (used[i] == 1)
				continue;
			s += String.valueOf(i);
			used[i] = 1;
			permute(n, k--, used, s, res);
			used[i] = 0;
			s = s.substring(0, s.length() - 1);
		}
	}
	
	public static void main(String[] args) {
		String s = getPermutation(8,15485);
		System.out.println(s);
	}
}
