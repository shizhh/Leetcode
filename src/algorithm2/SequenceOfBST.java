package algorithm2;


public class SequenceOfBST
{
	public boolean verify(int[] nums, int lo, int hi)
	{
		if (lo > hi)	return false;
		
		if (lo == hi)	return true;
		
		int root = nums[hi];
		
		int i = 0;
		for (i = lo; i < hi; i++)
		{
			if (nums[i] > root)
				break;
		}
		
		int j = i;
		
		for (; j < hi; j++)
		{
			if (nums[j] < root)
				return false;
		}
		
		boolean left = verify(nums, lo, i-1);
		boolean right = verify(nums, i, hi-1);
		
		return left && right;
	}
	
	public static void main(String[] args)
	{
		int[] nums = {5,7,6,9,11,10,8};
//		int[] nums = {7,4,6,5};
		System.out.println(new SequenceOfBST().verify(nums, 0, nums.length-1));
	}
}
