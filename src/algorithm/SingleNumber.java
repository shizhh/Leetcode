package algorithm;


public class SingleNumber
{
	public int singleNumber(int[] nums)
	{
		int res = 0;
		for (int i = 0; i < nums.length; i++)
		{
			res = res ^ nums[i];
		}
		return res;
	}
	
	public int singleNumber2_1(int[] nums)
	{
		int[] count = new int[32];
		int res = 0;
		for (int i = 0; i < 32; i++)
		{
			for (int j = 0; j < nums.length; j++)
			{
				if (((nums[j] >> i) & 0x1) == 1)
				{
					count[i]++;
				}
			}
			res |= (count[i] % 3) << i;
		}
		return res;
	}
	
	public int singleNumber2_2(int[] nums)
	{
		int ones=0, twos=0, threes=0;
		for (int i = 0; i < nums.length; i++)
		{
			twos |= (ones & nums[i]);
			ones ^= nums[i];
			threes = ~(ones & twos);
			ones &= threes;
			twos &= threes;
		}
		return ones;
	}
}
