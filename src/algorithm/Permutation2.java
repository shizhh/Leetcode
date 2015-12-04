package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {
	
	public static List<List<Integer>> permuteUnique(int[] nums) {
		if (nums.length < 1) {
			return null;
		}
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		int[] used = new int[nums.length];
		permute(nums, used, list, res);
		return res;
	}
	
	public static void permute(int[] nums, int[] used, List<Integer> list, List<List<Integer>> res) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (used[i] == 1)
				continue;
			// 两个数相同，必须是前一个已经使用后，后一个才能用，为了消除重复
			if (i > 0 && nums[i] == nums[i-1]) {
				if (used[i-1] == 0)
					continue;
			}
			list.add(nums[i]);
			used[i] = 1;
			permute(nums, used, list, res);
			used[i] = 0;
			list.remove(list.size()-1);
		}
		
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 1};
		List<List<Integer>> res = permuteUnique(nums);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}
	
	
}
