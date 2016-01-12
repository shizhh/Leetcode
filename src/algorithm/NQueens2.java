package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens2 {
	
	public static int totalNQueens(int n) {
		boolean[] flag = new boolean[n];		// initialize false for queen is not in the position
		boolean[] flag_45 = new boolean[2*n-1];
		boolean[] flag_135 = new boolean[2*n-1];
		
		int count = solveNQueens(n, 0, flag, flag_45, flag_135);
		return count;
	}
	
	public static int solveNQueens(int n, int row, boolean[] flag, boolean[] flag_45, boolean[] flag_135) {
		if (row == n) {
			return 1;
		}
		int count = 0;
		for (int col = 0; col < n; col++) {
			if (!flag[col] && !flag_45[row+col] && !flag_135[row-col+n-1]) {
				flag[col] = flag_45[row+col]=flag_135[row-col+n-1] = true;
				
				count += solveNQueens(n, row+1, flag, flag_45, flag_135);
				
				flag[col] = flag_45[row+col]=flag_135[row-col+n-1] = false;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int count = totalNQueens(4);
		System.out.println(count);
	}
}
