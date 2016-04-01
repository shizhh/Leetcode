package test;


public class HeapSort
{
	public void sort(int[] nums)
	{
		buildHeap(nums, nums.length);
		for (int i = nums.length-1; i >= 0; i--)
		{
			swap(nums, i, 0);
			heapfy(nums, 0, i);
		}
	}
	
	private void buildHeap(int[] nums, int heapSize)
	{
		for (int i = nums.length/2; i>=0; i--)
		{
			heapfy(nums, i, heapSize);
		}
	}
	
	private void heapfy(int[] nums, int i, int heapSize)
	{
		int left = 2*i+1;
		int right = 2*i+2;
		int largest = i;
		if (left < heapSize && nums[left] > nums[largest])	largest = left;
		if (right < heapSize && nums[right] > nums[largest])	largest = right;
		if (largest != i)
		{
			swap(nums, largest, i);
			heapfy(nums, largest, heapSize);
		}
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
		HeapSort heapSort = new HeapSort();
		heapSort.sort(nums);
		for (int v : nums){
			System.out.print(v+" ");
		}
	}
}
