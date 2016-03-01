package algorithm;


public class FindPeakElement
{
	public int findPeakElement(int[] nums)
	{
		return findPeakElement(nums, 0, nums.length-1);
	}
	
	public int findPeakElement(int[] nums, int start, int end)
	{
		if (start == end)
			return start;
		
		int mid = (end - start) / 2 + start;
		
		if (mid == start)
		{
		    if (nums[start] > nums[start+1])
		        return start;
		    else return start+1;
		}
		if (mid == end)
		{
			if (nums[end] > nums[end-1])
		        return end;
		    else return end-1;
		}
		
		if (mid+1 < nums.length && mid-1>=0 && nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1])
		{
			return mid;
		}
		else 
		{
			if (nums[mid+1] > nums[mid-1])
			{
				return findPeakElement(nums, mid+1, end);
			}
			else
			{
				return findPeakElement(nums, start, mid-1);
			}
		}
	}
	
	public static void main(String[] args)
	{
		int [] nums = {0,1,0};
		FindPeakElement main = new FindPeakElement();
		System.out.println(main.findPeakElement(nums));
	}
}
