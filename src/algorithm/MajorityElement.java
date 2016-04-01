package algorithm;


public class MajorityElement
{
	public int majorityElement(int[] nums)
	{
		int times = 1;
		int result = nums[0];
		
		for (int i = 1; i < nums.length; i++)
		{
			if (times == 0)
			{
				result = nums[i];
				times = 1;
			}
			if (nums[i] != result)
			{
				times--;
			}
			else
			{
				times++;
			}
		}
		
		return result;
	}
}
