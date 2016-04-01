package algorithm;


public class MissingNumber
{

	public int missingNumber(int[] nums)
	{
		int i = 0;
		int result = 0;
		for (i = 0; i < nums.length; i++)
		{
			result ^= i ^ nums[i];
		}
		return result ^ i;
	}
}
