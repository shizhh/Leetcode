package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	
	public static List<List<Integer>> subsets(int[] nums) {
		if (nums.length == 0)
			return null;
		
		Arrays.sort(nums);
		
		List<List<Integer>> resList = new ArrayList<>();
		resList.add(new ArrayList<>());
		System.out.println(resList);
		subsets(nums, 0, resList);
		System.out.println(resList);
		return resList;
	}
	
	public static void subsets(int[] nums, int index, List<List<Integer>> resList) {
		
		if (index == nums.length) {
			return;
		}
		
		int size = resList.size();
		
		for (int i = 0; i < size; i++) {
			List<Integer> newList = new ArrayList<>(resList.get(i));
			newList.add(nums[index]);
			resList.add(newList);
		}
		index++;
		subsets(nums, index, resList);
	}
	
	public static void main(String[] args) {
		int[] nums = {4,1,0};
		List<List<Integer>> resList = subsets(nums);
		//System.out.println(resList);
	}
}
