package algorithm;

public class MaximumSubarray {

	public static int maxSubArray(int[] nums) {
		int length = nums.length;
		if (length < 1)
			return 0;
		
		int[] dp = new int[length];
		dp[0] = nums[0];
		int max = dp[0];
		for (int i = 1; i < length; i++) {
			dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);		// max subarray end with nums[i]
			max = Math.max(max, dp[i]);
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int s = maxSubArray(nums);
		System.out.println(s);
	}

}
