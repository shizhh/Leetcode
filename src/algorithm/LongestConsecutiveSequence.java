package algorithm;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence
{
	public int longestConsecutive(int[] nums)
	{
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if (map.containsKey(nums[i]))
				continue;
			int left = map.containsKey(nums[i]-1) ? map.get(nums[i]-1) : 0;
			int right = map.containsKey(nums[i]+1) ? map.get(nums[i]+1) : 0;
			map.put(nums[i], left+right+1);
			if (map.containsKey(nums[i]-left))
				map.put(nums[i]-left, left+right+1);
			if (map.containsKey(nums[i]+right))
				map.put(nums[i]+right, left+right+1);
			if (left+right+1 > res)
				res = left+right+1;
		}
		return res;
	}
	public static void main(String[] args)
	{
		int[] nums = {1,2,4,5,3,7,6};
		LongestConsecutiveSequence main = new LongestConsecutiveSequence();
		System.out.println(main.longestConsecutive(nums));
	}
}
