package algorithm;


public class MinimumSizeSubarraySum
{

	public int minSubArrayLen(int s, int[] nums)
	{
		int minLen = nums.length+1;
		int curSum = 0;
		int start = 0;
		int end = 0;
		while (end < nums.length)
		{
			curSum += nums[end];
			while (start <= end  && curSum >= s)
			{
				minLen = Math.min(minLen, end-start+1);
				
				curSum -= nums[start];
				start++;
			}
			if (start > end)
				return 1;
			end++;
			
		}
		return minLen == nums.length+1 ? 0 : minLen;
	}
}
