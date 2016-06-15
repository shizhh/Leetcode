package algorithm;

/**
 * Created by szh on 16/4/14.
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= min) min = nums[i];
            else if (nums[i] <= secondMin) secondMin = nums[i];
            else return true;
        }
        return false;
    }
}
