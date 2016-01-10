package algorithm;

public class RotateImage {
	
	/*
	 * clockwise rotate
	 * first reverse up to down, then swap the symmetry 
	 * 1 2 3     7 8 9     7 4 1
	 * 4 5 6  => 4 5 6  => 8 5 2
	 * 7 8 9     1 2 3     9 6 3
	*/
	
	/*
	 * anticlockwise rotate
	 * first reverse left to right, then swap the symmetry
	 * 1 2 3     3 2 1     3 6 9
	 * 4 5 6  => 6 5 4  => 2 5 8
	 * 7 8 9     9 8 7     1 4 7
	*/
	
	
	public static void rotate(int[][] matrix) {
		reverse(matrix);
		int n = matrix.length;
		int tmp;
		for (int i = 0; i < n; ++i) {
			for (int j = i; j < n; ++j) {
				tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}
	
	public static void reverse(int[][] matrix) {
		int n = matrix.length;
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n/2; i++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n-1-i][j];
				matrix[n-1-i][j] = tmp;
			}
		}
	}
	
	public static void show(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}};
		show(matrix);
		rotate(matrix);
		
		show(matrix);
	}
}
