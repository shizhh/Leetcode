package algorithm;

public class Search2DMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		int i = binarySearch2(matrix, target);
		return binarySearch(matrix[i], target);
	}
	
	private static boolean binarySearch(int[] array, int target) {
		int i = 0;
		int j = array.length - 1;
		int mid;
		while (i <= j) {
			mid = (j - i) / 2 + i;
			if (array[mid] == target)
				return true;
			else if (array[mid] < target)
				i = mid + 1;
			else j = mid - 1;
		}
		return false;
	}
	
	private static int binarySearch2(int[][] array, int target) {
		int i = 0;
		int j = array.length - 1;
		int mid = 0;
		while (i <= j) {
			mid = (j-i)/2 + i;
			if (target < array[mid][0]) {
				j = mid - 1;
			}
			else if (target > array[mid][0]) {
				i = mid + 1;
			}
			else return mid;
		}
		return j >= 0 ? j : 0;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1,   3,  5,  7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}};
		int [][] matrix2 = {{1}};
//		System.out.println(searchMatrix(matrix2, 0));
		
//		int[] array = {1, 10, 23};
		System.out.println(binarySearch2(matrix2, 11));
	}
}
