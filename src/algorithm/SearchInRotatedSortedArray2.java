package algorithm;

public class SearchInRotatedSortedArray2 {
	
	public static boolean search(int[] nums, int target) {
		if (nums.length < 1)
			return false;
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int mid = start + (end-start)/2;
			if (nums[mid] == target)
				return true;
			if (nums[start] < nums[mid]) {
				if (target < nums[mid] && target >= nums[start])
					end = mid - 1;
				else start = mid + 1;
			}
			else if (nums[start] > nums[mid]){
				if (target > nums[mid] && target <= nums[end])
					start = mid + 1;
				else end = mid - 1;
			}
			else {
				start++;
			}
		}
		return target == nums[start];
	}
	
	public static void main(String[] args) {
		int[] nums = {4, 5, 5 ,5 , 6, 7, 0, 1, 2, 4};
		System.out.println(search(nums, 9));
	}
} 
