/**
 * 
 * 
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 
 * */
package algorithm;

import java.util.Hashtable;

public class TwoSum {

	public static void main(String[] args) {
		
		int[] a = {2, 7, 11, 15};
		int[] ret = twoSum(a, 26);
		System.out.println(ret[0] + "..." + ret[1]);
	}
	
	public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        
        for (int i = 0; i < nums.length; i++) {
        	if(ht.get(target - nums[i]) != null) {
        		result[0] = ht.get(target - nums[i]) + 1;
        		result[1] = i + 1;
        	}else {
        		ht.put(nums[i], i);
        	}
        }
		return result;
    }

}

