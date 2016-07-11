package algorithm;

/**
 * Created by szh on 16/7/11.
 */
public class FindDuplicateNumber {
    public int findDuplicate1(int[] nums) {
        if (nums.length > 1){
            int slow = nums[0];
            int fast = nums[nums[0]];
            while(slow != fast){
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while(slow!=fast){
                slow=nums[slow];
                fast=nums[fast];
            }
            return slow;
        }
        return -1;
    }

}
