package algorithm;


public class RotateArray
{
	// -----------------------------------
	// 0 --> k, 1 --> k+1, ...
	// -----------------------------------
	public void rotate1(int[] nums, int k) 
    {
        int len = nums.length;
        k = k % len;
        if (k == 0)
        	return;
        
        int start = 0;
        int cur = 0;
        int t1 = 0;
        int t2 = nums[start];
        
        // Rotate n elements, n == len
        for (int i = 0; i < len; i++)
        {
        	t1 = nums[(cur+k)%len];
        	nums[(cur+k)%len] = t2;
        	t2 = t1;
        	cur = (cur+k)%len;
        	if (cur == start)
        	{
        		start++;
        		cur = start;
        		t2 = nums[cur];
        	}
        }
    }
	
	// -----------------------------------
	// 0,...,len-k-1 | len-k,...,len-1
	// -----------------------------------
	public void rotate2(int[] nums, int k)
	{
		int len = nums.length;
        k = k % len;
        if (k == 0)
            return;
        
        reverse(nums, 0, len-k-1);
        reverse(nums, len-k, len-1);
        reverse(nums, 0, len-1);
	}
	private void reverse(int[] nums, int start, int end)
    {
        while(start < end)
        {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }
	
	// -----------------------------------
	// 
	// -----------------------------------
	public void rotate3(int[] nums, int k)
	{
		
	}
	
	public static void main(String[] args)
	{
		int[] nums = {1,2,3,4};
		RotateArray main = new RotateArray();
		main.rotate1(nums, 03);
		for (int i = 0; i < nums.length; i++)
		{
			System.out.println(nums[i]);
		}
	}
}
