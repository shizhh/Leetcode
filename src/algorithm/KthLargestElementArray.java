package algorithm;


public class KthLargestElementArray
{
	
	public int findKthLargest2(int[] nums, int k)
	{
		k = nums.length - k;
		int lo = 0;
		int hi = nums.length-1;
		while (lo < hi)
		{
			int j = partition(nums, lo, hi);
			if (j < k)	lo = j + 1;
			else if (j > k)	hi = j - 1;
			else break;
		}
		return nums[k];
	}
	
	public int partition(int[] nums, int lo, int hi)
	{
		int i = lo;
		int j = hi+1;
		int v = nums[lo];
		while (true)
		{
			while(i < hi && nums[++i] < v);
			while(j > lo && nums[--j] > v);
			if (i >= j)
				break;
			swap(nums, i, j);
		}
		swap(nums, lo, j);
		
		return j;
	}
	
	public int findKthLargest(int[] nums, int k)
	{
//		int heapSize = nums.length;
		int heapSize = k;
		buildHeap(nums, heapSize);
		while(heapSize > 0)
		{
			swap(nums, 0, heapSize-1);
			heapfy(nums, --heapSize, 0);
		}
		
		for (int i = 0; i < nums.length; i++)
		{
			System.out.println(nums[i]);
		}
		return nums[nums.length-k-1];
	}
	
	private void buildHeap(int[] nums, int heapSize)
	{
		for (int i = nums.length/2; i>=0; i--)
		{
			heapfy(nums, heapSize, i);
		}
	}
	
	// 大顶堆，从上往下维护
	private void heapfy(int[] nums, int heapSize, int index)
	{
		int leftChild = (index<<1)+1;
		int rightChild = leftChild+1;
		int largestIndex = index;
		if (leftChild < heapSize && nums[leftChild] > nums[largestIndex])
			largestIndex = leftChild;
		if (rightChild < heapSize && nums[rightChild] > nums[largestIndex])
			largestIndex = rightChild;
		if (largestIndex != index)
		{
			swap(nums, index, largestIndex);
			heapfy(nums, heapSize, largestIndex);
		}
	}
	
	// 当 i==j 时，会出问题，值为0
//	private void swap(int[] nums, int i, int j)
//	{
//		nums[i] = (nums[i] ^ nums[j]);
//		nums[j] = (nums[i] ^ nums[j]);
//		nums[i] = (nums[i] ^ nums[j]);
//	}
	
	private void swap(int[] nums, int i, int j)
	{
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
	
	private void print(int[] nums)
	{
		for (int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		int[] nums = {3,2,1,5,6,4};
		KthLargestElementArray main = new KthLargestElementArray();
		System.out.println(main.findKthLargest2(nums, 6));
		
	}
}
