package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		String[] board = new String[n];
		char[] row = new char[n];
		Arrays.fill(row, '.');
		Arrays.fill(board, String.valueOf(row));
		
		boolean[] flag = new boolean[n];		// initialize false for queen is not in the position
		boolean[] flag_45 = new boolean[2*n-1];
		boolean[] flag_135 = new boolean[2*n-1];
		
		solveNQueens(res, board, 0, flag, flag_45, flag_135);
		
		return res;
	}
	
	public static void solveNQueens(List<List<String>> res, String[] board, int row, boolean[] flag, boolean[] flag_45, boolean[] flag_135) {
		int n = board.length;
		if (row == n) {
			res.add(new ArrayList<String>(Arrays.asList(board)));
			return;
		}
		for (int col = 0; col < n; col++) {
			if (!flag[col] && !flag_45[row+col] && !flag_135[row-col+n-1]) {
				
				flag[col] = flag_45[row+col]=flag_135[row-col+n-1] = true;
				
				char[] chars = board[row].toCharArray();
				chars[col] = 'Q';
				board[row] = String.valueOf(chars);
				
				solveNQueens(res, board, row+1, flag, flag_45, flag_135);
				
				flag[col] = flag_45[row+col]=flag_135[row-col+n-1] = false;
				
				chars = board[row].toCharArray();
				chars[col] = '.';
				board[row] = String.valueOf(chars);
			}
		}
	}
	
	public static void main(String[] args) {
		List<List<String>> res = solveNQueens(4);
		System.out.println(res);
	}

}
