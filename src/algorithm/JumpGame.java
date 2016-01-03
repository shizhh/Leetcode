package algorithm;

public class JumpGame {

	public static boolean canJump(int[] nums) {
		int length = nums.length;
		if (length < 1)
			return false;
		int maxDis = 0;
		for (int i = 0; i <= maxDis; ++i) {
			if (maxDis < i)
				return false;
			maxDis = Math.max(maxDis, i+nums[i]);
			if (maxDis >= length-1)
				return true;
		}
		return false;
	}
	
	public static boolean canJump2(int[] nums) {
		int maxDis = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (maxDis < i) 
				return false;
			maxDis = Math.max(i+nums[i], maxDis);
			if (maxDis >= nums.length-1)
				return true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,1,1,0,4};
		boolean fg = canJump2(nums);
		System.out.println(fg);
	}
}
