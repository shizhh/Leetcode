package algorithm;

/**
 * Created by szh on 16/4/5.
 */
public class NumArray {

    static int [] nums;
    static int [][] dp;
    static boolean [][] isCalced;

    public NumArray(int[] nums)
    {
        this.nums = nums;
        dp = new int[nums.length][nums.length]; //dp[i][j] denotes the sum of nums[i ... j]
        isCalced = new boolean[nums.length][nums.length];
    }

    public int sumRange(int i, int j)
    {
        if (isCalced[i][j]) return dp[i][j];
        else {
            if (i == j) {
                dp[i][j] = nums[i];
            }
            else
            {
                dp[i][j] = sumRange(i+1, j) + nums[i];
            }
        }
        isCalced[i][j] = true;
        return dp[i][j];
    }

    public static void main(String [] args)
    {
        int [] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 1));
        System.out.println(numArray.sumRange(1, 2));
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);