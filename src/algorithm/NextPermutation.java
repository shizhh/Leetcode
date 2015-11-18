package algorithm;

/**
 * 在当前序列中，从尾端往前寻找两个相邻元素，前一个记为*i，后一个记为*ii，并且满足*i < *ii。然后再从尾端寻找另一个元素*j，如果满足*i <
 * *j，即将第i个元素与第j个元素对调，并将第ii个元素之后（包括ii）的所有元素颠倒排序，即求出下一个序列了。
 */
public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutation permutation = new NextPermutation();
		int[] nums = { 3, 2, 1 };
		permutation.nextPermutation(nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}

	public void nextPermutation(int[] nums) {
		int len = nums.length;
		if (len < 2) {
			return;
		}
		int i = len - 1;
		while (i > 0 && nums[i - 1] >= nums[i]) {
			i--;
		}
		if (i == 0) {
			reverse(nums, 0, len - 1);
		} else {
			int j = i - 1;
			int k = len - 1;
			while (nums[j] >= nums[k]) {
				k--;
			}
			int temp = nums[j];
			nums[j] = nums[k];
			nums[k] = temp;
			reverse(nums, i, len - 1);
		}

	}

	public void reverse(int[] A, int p, int r) {
		while (p < r) {
			int temp = A[p];
			A[p] = A[r];
			A[r] = temp;
			p++;
			r--;
		}
	}

}
