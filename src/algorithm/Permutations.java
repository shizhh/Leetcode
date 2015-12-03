package algorithm;

import java.util.List;
import java.util.ArrayList;

public class Permutations {
	
	
	public static List<List<Integer>> permute(int[] nums) {
		if (nums.length < 1) {
			return null;
		}
		
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		int[] used = new int[nums.length];
		permute(nums, used, list, res);
		return res;
	}
	
	
	public static List<List<Integer>> permute2(int[] nums) {
		if (nums.length < 1)
			return null;
		
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> l = new ArrayList<>();
		l.add(nums[0]);
		res.add(l);
		for (int i = 1; i < nums.length; i++) {
			res = permute(nums[i], res);
		}
		return res;
	}
	
	// 递归法
	public static List<List<Integer>> permute(int r, List<List<Integer>> res) {
		List<List<Integer>> tmp = new ArrayList<List<Integer>>();
		
		for (List<Integer> list : res) {
			for (int i = 0; i <= list.size(); i++) {
				List<Integer> t = new ArrayList<>(list);
				t.add(i, r);
				tmp.add(t);
			}
		}
		return tmp;
	}
	
	// 回溯法
	public static void permute(int[] nums, int[] used, List<Integer> list, List<List<Integer>> res) {
		if (nums.length == list.size()) {
			res.add(new ArrayList<>(list));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (used[i] == 1)
				continue;
			list.add(nums[i]);
			used[i] = 1;
			permute(nums, used, list, res);
			used[i] = 0;	
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String[] args) {
		// 递归
//		int[] nums = {1,2,3};
//		List<List<Integer>> res = permute(nums);
//		for (List<Integer> list : res) {
//			System.out.println(list);
//		}
		
		// 回溯
		int[] nums = {1,2,3};
		List<List<Integer>> res = permute(nums);
		for (List<Integer> l : res) {
			System.out.println(l);
		}
	}
}
