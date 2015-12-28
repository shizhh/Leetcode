package algorithm;

public class MinimumPathSum {
	
	public static int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		return minPathSum(grid, m, n);
	}
	
	public static int minPathSum(int[][] grid, int m, int n) {
		int[][] sum = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					sum[i][j] = grid[i][j];
				}
				else if (i == 0 && j > 0) {
					sum[i][j] = sum[i][j-1] + grid[i][j];
				}
				else if (i > 0 && j == 0) {
					sum[i][j] = sum[i-1][j] + grid[i][j];
				}
				else {
					sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i][j];
				}
			}
		}
		return sum[m-1][n-1];
	}
	
	public static void main(String[] args) {
		int[][] grid = {
				{1,2,3},
				{1,8,3},
				{4,7,3}
				};
		int res = minPathSum(grid);
		System.out.println(res);
	}
	
}
