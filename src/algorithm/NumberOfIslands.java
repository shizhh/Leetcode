package algorithm;


public class NumberOfIslands
{
	public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
    		return 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int num = 0;
        for (int i = 0; i < m; i++)
        {
        	for (int j = 0; j < n; j++)
        	{
        		if (grid[i][j] == '1')
        		{
                    num--;
        			visited[i][j] = true;
        			dfs(grid, i, j, num, visited);
        		}
        	}
        }
        
        return -num;
    }
    public void dfs(char[][] grid, int x, int y, int num, boolean[][] visited)
    {
    	int m = grid.length;
        int n = grid[0].length;
    	
    	int[][] next = {
    			{0, 1},
    			{1, 0},
    			{0, -1},
    			{-1, 0}
    	};
    	
        grid[x][y] = '#';
    	
    	for (int i = 0; i < 4; i++)
    	{
    		int tx = x + next[i][0];
    		int ty = y + next[i][1];
    		
    		if (tx < 0 || tx >= m || ty < 0 || ty >= n)
    			continue;
    		
    		if (grid[tx][ty] == '1' && !visited[tx][ty])
    		{
    			visited[tx][ty] = true;
    			dfs(grid, tx, ty, num, visited);
    		}
    	}
    }
    public static void main(String[] args)
    {
    	System.out.println((int)('0'-1));
    }
}
