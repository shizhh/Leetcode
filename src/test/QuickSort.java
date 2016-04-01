package test;


public class QuickSort
{
	public void sort(int[] nums)
	{
		sort(nums, 0, nums.length-1);
	}
	
	private void sort(int[] nums, int lo, int hi)
	{
		if (lo >= hi)
			return;
		int j = partition(nums, lo, hi);
		sort(nums, lo, j-1);
		sort(nums, j+1, hi);
	}
	
	private int partition(int[]nums, int lo, int hi)
	{
		int i = lo;
		int j = hi+1;
		int v  = nums[lo];
		while (i < j)
		{
			while (i < j && nums[++i] < v);
			while (i < j && nums[--j] > v);
			if (i >= j)
				break;
			swap(nums, i, j);
		}
		swap(nums, lo, j-1);
		return j-1;
	}
	
	private void swap(int[] nums, int i, int j)
	{
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
	
	public static void main(String[] args)
	{
		int[] nums = {4,5,3,-1,0,10,7,2,3};
		QuickSort quickSort = new QuickSort();
		quickSort.sort(nums);
		for (int v : nums){
			System.out.print(v+" ");
		}
	}
}
