package algorithm;

public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,3,5,6};
		int target = 0;
		System.out.println(searchInsert(nums, target));
	}
	
	public static int searchInsert(int[] nums, int target) {
		int i = 0;
		int j = nums.length -1 ;
		int mid = 0;
		while (i<=j) {
			mid = (j-i)/2+i;
			if (nums[mid] == target){
				return mid;
			}else {
				if (nums[mid] < target) {
					i = mid + 1;
				}else {
					j = mid - 1;
				}
				
			}
		}
		return i;
	}
}
