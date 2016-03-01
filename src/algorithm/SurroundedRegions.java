package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions
{
	//int[][] book = new int[][];
	
	public void solve(char[][] board)
	{
		int m = board.length;
		if (m < 2)
			return;
		int n = board[0].length;
		if (n < 2)
			return;
		int[][] book = new int[m][n];
		
		// top
		for (int i = 0; i < n; i++)
		{
			if (board[0][i] == 'O')
			{
//				dfs(board, 0, i, book);
				bfs(board, 0, i);
			}
		}
		
		// bottom
		for (int i = 0; i < n; i++)
		{
			if (board[m-1][i] == 'O')
			{
//				dfs(board, m-1, i, book);
				bfs(board, m-1, i);
			}
		}
		
		// left
		for (int i = 0; i < m; i++)
		{
			if (board[i][0] == 'O')
			{
//				dfs(board, i, 0, book);
				bfs(board, i, 0);
			}
		}
		
		// right
		for (int i = 0; i < m; i++)
		{
			if (board[i][n-1] == 'O')
			{
//				dfs(board, i, n-1, book);
				bfs(board, i, n-1);
			}
		}
		
		for ( int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
			{
				if(board[i][j] == 'O')  
                    board[i][j] = 'X';  
                else if(board[i][j] == '#')  
                    board[i][j] = 'O';
			}
		
	}
	
	// --------------------------
	// StackOverflowError
	// --------------------------
	public void dfs(char[][] board, int x, int y, int[][] book)
	{
		int m = board.length;
		int n = board[0].length;
		int[][] next = {
				{0, 1},
				{0, -1},
				{1, 0},
				{-1, 0}
		};
		
		board[x][y] = '#';
		
		for (int k = 0; k <= 3; k++)
		{
			int tx = x + next[k][0];
			int ty = y + next[k][1];
			if (tx < 0 || tx >= m || ty < 0 || ty >= n)
				continue;
			if (board[tx][ty] == 'O' && book[tx][ty] == 0)
			{
				//System.out.println(board[tx][ty]);
				book[tx][ty] = 1;
				dfs(board, tx, ty, book);
			}
		}
	}
	
	// --------------------------
	// bfs
	// --------------------------
	public void bfs(char[][] board, int i, int j)
	{
		board[i][j] = '#';
		
		int m = board.length;
		int n = board[0].length;
		
		Queue<Integer> queue = new LinkedList<>();
		int code = i * n + j;
		queue.offer(code);
		while (!queue.isEmpty())
		{
			code = queue.poll();
			int row = code / n;
			int col = code % n;
			if(row>0 && board[row-1][col]=='O')  
	        {  
	            queue.offer((row-1)*n+col);  
	            board[row-1][col]='#';  
	        }  
	        if(row<m-1 && board[row+1][col]=='O')  
	        {  
	            queue.offer((row+1)*n+col);  
	            board[row+1][col]='#';  
	        }  
	        if(col>0 && board[row][col-1]=='O')  
	        {  
	            queue.offer(row*n+col-1);  
	            board[row][col-1]='#';  
	        }  
	        if(col<n-1 && board[row][col+1]=='O')  
	        {  
	            queue.offer(row*n+col+1);  
	            board[row][col+1]='#';  
	        }
		}
	}
	
	
	private void print(char[][] board)
	{
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[0].length; j++)
			{
				System.out.print(board[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		char[][] board = {
				{'X','X','X','X'},
				{'X','O','O','X'},
				{'X','X','O','X'},
				{'X','O','X','X'}
		};
		
		int[][] book = new int[board.length][board[0].length];
		
		SurroundedRegions main = new SurroundedRegions();
		main.print(board);
		main.solve(board);
		//main.dfs(board, 3, 0, book);
		main.print(board);
		
	}
	
}
