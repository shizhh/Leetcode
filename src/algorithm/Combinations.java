package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if (n < k)
			return res;
		
		List<Integer> comb = new ArrayList<>();
		combine(res, comb, 1, n, k);
		return res;
	}
	
	public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
		if (k == 0) {
			combs.add(new ArrayList<>(comb));
			return;
		}
		for ( int i = start; i <= n; i++) {
			comb.add(i);
			combine(combs, comb, i+1, n, k-1);
			comb.remove(comb.size()-1);
		}
	}
	
	public static void main(String[] args) {
		List<List<Integer>> res = combine(4, 2);
		System.out.println(res);
	}
}
