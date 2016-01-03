package algorithm;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Subset2 {

	public static List<List<Integer>> subsetWithDup(int[] nums) {
		int length = nums.length;
		if (length < 1)
			return null;
		
		Arrays.sort(nums);
		
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> nullList = new ArrayList<>();
		res.add(nullList);
		
		for (int i = 0; i < length; i++) {
			int c = 1;
			while (i+1< length && nums[i] == nums[i+1]) {
				c++;
				i++;
			}
			int size = res.size();
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < c; k++) {
					List<Integer> newList = new ArrayList<>(res.get(j));
					for (int p = 0; p <= k; p++)
						newList.add(nums[i]);
					res.add(newList);
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,2,3};
		List<List<Integer>> res = subsetWithDup(nums);
		System.out.println(res);
 	}
}
