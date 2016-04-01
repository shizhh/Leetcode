package algorithm;

public class LongestIncreasingSubsequence
{
	
	public int lengthOfLIS(int[] nums)
	{
		if (nums == null || nums.length == 0)
			return 0;
		int max = 0;
		int[] p = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
		{
			p[i] = 1;
			for (int j = 0; j < i; j++)
			{
				if (nums[i] > nums[j] && p[j] + 1 > p[i])
				{
					p[i] = p[j] + 1;
				}
			}
			max = Math.max(max, p[i]);
		}
		return max;
	}
	
	// -------------------
	// O(nlogn) using binary search
	// -------------------
	public int lengthOfLIS2(int[] nums)
	{
		int[] seq = new int[nums.length];
		int len = 0;
		seq[0] = nums[0];
		for (int i = 1; i < nums.length; i++)
		{
			if (nums[i]>seq[len])	seq[++len] = nums[i];
			if (nums[i]<seq[0])		seq[0] = nums[i];
			
			// binary search
			int lo = 0;
			int hi = len;
			int mid = 0;
			while (lo <= hi)
			{
				mid = (hi-lo)/2 + lo;
				if (nums[i] == seq[mid])	{ lo = mid; break; }
				if (nums[i] < seq[mid])		hi = mid - 1;
				if (nums[i] > seq[mid])		lo = mid + 1;
			}
			seq[lo] = nums[i];
		}
		return len;
	}
}
