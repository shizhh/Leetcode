package algorithm;

public class JumpGame2 {
	
	public static int jump(int[] nums) {
		int maxDis = 0;
		int maxEdge = 0;
		int count = 0;
		for (int i = 0; i < nums.length-1; ++i) {
			maxDis = Math.max(maxDis, i+nums[i]);
			if (maxDis >= nums.length - 1)
				return count+1;
			if (i == maxEdge) {
				count++;
				maxEdge = maxDis;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,1,1,1};
		int res = jump(nums);
		System.out.println(res);
	}
}
