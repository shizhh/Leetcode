package algorithm;


public class FindMinimuminRotatedSortedArray
{
	
	// ---------------------------------
	// duplicates are not allowed
	// ---------------------------------
	public int findMin(int[] nums)
	{
		return findMin(nums, 0, nums.length-1);
	}
	
	private int findMin(int[] nums, int start, int end)
	{
		if (start == end)
			return nums[start];
		
		int mid = (end - start) / 2 + start;
		
		if (nums[mid] > nums[start] && nums[mid] > nums[end])
		{
			return findMin(nums, mid+1, end);
		}
		else if (nums[mid] < nums[start] && nums[mid] < nums[end])
		{
			return findMin(nums, start, mid);
		}
		else if (nums[mid] >= nums[start] && nums[mid] < nums[end])
		{
			return findMin(nums, start, mid);
		}
		else
		{
			return findMin(nums, mid+1, end);
		}
		
	}
	
	
	// -------------------------------------
	// duplicates are allowed
	// -------------------------------------
	public int findMin2(int[] nums)
	{
		return findMin2(nums, 0, nums.length-1);
	}
	
	private int findMin2(int[] nums, int start, int end)
	{
		if (start == end)
			return nums[start];
		
		
		int mid = (end - start) / 2 + start;
		
		if (nums[mid] > nums[start])
		{
			if (nums[mid] > nums[end])
			{
				return findMin2(nums, mid+1, end);
			}
			else if (nums[mid] < nums[end])
			{
				return findMin2(nums, start, mid);
			}
			else
			{
				return findMin2(nums, start, mid);
			}
		}
		else if (nums[mid] < nums[start])
		{
			if (nums[mid] > nums[end])
			{
				return findMin2(nums, mid+1, end);
			}
			else if (nums[mid] < nums[end])
			{
				return findMin2(nums, start, mid);
			}
			else
			{
				return findMin2(nums, start, mid);
			}
		}
		else 
		{
			if (nums[mid] > nums[end])
			{
				return findMin2(nums, mid+1, end);
			}
			else if (nums[mid] < nums[end])
			{
				return findMin2(nums, start, mid);
			}
			else
			{
				return Math.min(findMin2(nums, start, mid), findMin2(nums, mid+1, end));
			}
		}
	}
	
	public static void main(String[] args)
	{
		int[] nums = {1,1,0,0,0,1};
		FindMinimuminRotatedSortedArray main = new FindMinimuminRotatedSortedArray();
		System.out.println(main.findMin2(nums));
	}
}
