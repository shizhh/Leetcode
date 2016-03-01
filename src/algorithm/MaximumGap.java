package algorithm;


public class MaximumGap
{
	public int maximumGap(int[] nums) 
	{
        if (nums == null || nums.length <= 1)
			return 0;
		
		int maxNum = nums[0];
		int minNum = nums[0];
		for (int i = 1; i < nums.length; i++)
		{
			if (nums[i] > maxNum)
				maxNum = nums[i];
			if (nums[i] < minNum)
			    minNum = nums[i];
		}
		int bukketSize = (maxNum-minNum) / (nums.length-1) == 0 ? 1 : (maxNum-minNum) / (nums.length-1);
		int bukketNum = (maxNum-minNum) / bukketSize + 1;
		
		int[] min = new int[bukketNum];
		int[] max = new int[bukketNum];
		for (int i = 0; i < bukketNum; i++)
		{
		    min[i] = maxNum + 1;
		    max[i] = -1;
		}
		
		for (int i = 0; i < nums.length; i++)
		{
			int index = (nums[i]-minNum) / bukketSize;
			if (min[index] > nums[i])
				min[index] = nums[i];
			if (max[index] < nums[i])
				max[index] = nums[i];
		}
		
		int maxGap = 0;
		int index = 0;
		for (int i = 1; i < bukketNum; i++)
		{
		    if (max[i] != -1 && min[i] != maxNum + 1)
		    {
			    maxGap = min[i] -max[index] > maxGap ? min[i]-max[index] : maxGap;
			    index = i;
		    }
		    
		}
		return maxGap;
    }	
}
