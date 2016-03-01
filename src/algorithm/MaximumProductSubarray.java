package algorithm;


public class MaximumProductSubarray
{
	public int maxProduct1(int[] nums)
	{
		if (nums == null || nums.length == 0)
			return 0;
		
		int[] product = new int[nums.length];
		int max = 1;
		
		
		for (int i = 0; i < nums.length; i++)
		{
			product[i] = nums[i];
			max = 1;
			for (int j = i; j < nums.length; j++)
			{
				max *= nums[j];
				if (max > product[i])
					product[i] = max;
			}
		}
		max = product[0];
		for (int i = 1; i < product.length; i++)
		{
			if (max < product[i])
				max = product[i];
		}
		return max;
	}
	
	public int maxProduct2(int[] nums)
	{
		if (nums == null || nums.length == 0)
			return 0;
		
		int minLocal = nums[0];
		int maxLocal = nums[0];
		int global = nums[0];
		
		for (int i = 1; i < nums.length; i++)
		{
			int maxCopy = maxLocal;
			maxLocal = Math.max(Math.max(nums[i], maxLocal * nums[i]), minLocal * nums[i]);
			minLocal = Math.min(Math.min(maxCopy * nums[i], nums[i]), minLocal * nums[i]);
			global = Math.max(global, maxLocal);
		}
		return global;
	}
	
	public int maxSubArray(int[] A) 
	{  
	    if(A==null || A.length==0)  
	        return 0;  
	    int global = A[0];  
	    int local = A[0];  
	    for(int i=1;i<A.length;i++)  
	    {  
	        local = Math.max(A[i],local+A[i]);  
	        global = Math.max(local,global);  
	    }  
	    return global;  
	}
	
	public int maxSubArray2(int[] A)
	{
		 if(A==null || A.length==0)  
		     return 0;
		 int max = A[0];
		 int cur = A[0];
		 for (int i = 1; i < A.length; i++)
		 {
			 cur = A[i] + cur;
			 if (cur <= 0)
			 {
				 cur = 0;
			 }
			 if (cur > max)
			 {
				 max = cur;
			 }
		 }
		 return max;
	}
	
	public static void main(String[] args)
	{
		int[] nums = {2,3,-8,4};
		MaximumProductSubarray main = new MaximumProductSubarray();
		System.out.println(main.maxSubArray(nums));
		System.out.println(main.maxSubArray2(nums));
	}
}
