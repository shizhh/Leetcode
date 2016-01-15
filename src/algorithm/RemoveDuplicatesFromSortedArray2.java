package algorithm;

public class RemoveDuplicatesFromSortedArray2 {

	public static int removeDuplicates(int[] nums) {
		int counter = 0;
		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[index]) {
				if (counter != 2) {
					nums[++index] = nums[i];
					counter = 2;
				}
			}
			else {
				nums[++index] = nums[i];
				counter = 1;
			}
		}
		return index + 1;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3,4,4,4,4,5,6,7,7,8,8,8,9};
		int n = removeDuplicates(nums);
		for (int i = 0; i < n; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
