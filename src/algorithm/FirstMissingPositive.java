package algorithm;

public class FirstMissingPositive {
	
	public static int firstMissingPositive(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; ++i) {
			while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i]-1]) {
				exch(nums, i, nums[i]-1);
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (nums[i] != i+1) {
				return i+1;
			}
		}
		return n+1;
	}
	
	public static void exch(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,0};
		int[] nums2 = {3,4,-1,1};
		int res = firstMissingPositive(nums2);
		System.out.println(res);
	}
	
}
