package algorithm;

import java.util.Arrays;
import java.util.List;

public class SpiralMatrix2 {
	
	public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n < 1)
        	return matrix;
        int count = 1;
        int left = 0;
        int right = n-1;
        int up = 0;
        int down = n-1;
        while (left <= right && up <= down) {
        	for (int i = left; i <= right; i++) {
        		matrix[up][i] = count;
        		count++;
        	}
        	up++;
        	for (int i = up; i <= down; i++) {
        		matrix[i][right] = count;
        		count++;
        	}
        	right--;
        	if (up <= down) {
        		for (int i = right; i >= left; i--) {
        			matrix[down][i] = count;
        			count++;
        		}
        		down--;
        	}
        	if (left <= right) {
        		for (int i = down; i >= up; i--) {
        			matrix[i][left] = count;
        			count++;
        		}
        		left++;
        	}
        }
        return matrix;
    }
	
	public static void main(String[] args) {
		int n = 0;
		int[][] matrix = new int[n][n];
		matrix = generateMatrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
		
	}
}
