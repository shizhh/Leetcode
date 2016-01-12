package algorithm;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		int m = matrix.length;
		if (m < 1)
			return res;
		int n = matrix[0].length;
        int left = 0;
        int right = n-1;
        int up = 0;
        int down = m-1;
        while (left <= right && up <= down) {
        	// traverse right
        	for (int i = left; i <= right; i++) {
        		res.add(matrix[up][i]);
        	}
        	up++;
        	// traverse down
	        for (int i = up; i <= down; i++) {
	        	res.add(matrix[i][right]);
	        }
        	right--;
        	//traverse left
        	if (up <= down) {
        		for (int i = right; i >= left; i--) {
        			res.add(matrix[down][i]);
        		}
        		down--;
        	}
        	// traverse up
        	if (left <= right) {
        		for (int i = down; i >= up; i--) {
        			res.add(matrix[i][left]);
        		}
        		left++;
        	}
        }
        
		return res;
    }
	
	
	public static void main(String[] args) {
		int[][] matrix = {
				{ 1, 2, 3, 4 },
				{ 5, 6, 7, 8 },
				{ 9, 10,11,12 }};
		List<Integer> res = spiralOrder(matrix);
		System.out.println(res);
	}
}
