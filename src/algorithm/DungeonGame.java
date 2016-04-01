package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class DungeonGame
{
	
	int max = Integer.MIN_VALUE;
	int min = Integer.MIN_VALUE;
	
	
	public int calculateMinimumHP(int[][] dungeon)
	{
		int hp = dungeon[0][0];
		int[][] book = new int[dungeon.length][dungeon[0].length];
		book[0][0] = 1;
		dfs(dungeon, 0, 0, book, hp, 1);
		return Math.abs(min)+1;
	}
	
	public void dfs(int[][] dungeon, int x, int y, int[][] book, int hp, int curMin)
	{
		int m = dungeon.length;
		int n = dungeon[0].length;
		
		if (x == m-1 && y == n-1)
		{
//			System.out.println("-----------");
			//hp += dungeon[x][y];
			if (min < curMin)
				min = curMin;
			return;
		}
		
		int[][] next = {
				{0, 1},
				{1, 0}
		};
		
		for (int k = 0; k < 2; k++)
		{
			int tx = x + next[k][0];
			int ty = y + next[k][1];
			
			if (tx < 0 || tx >= m || ty < 0 || ty >= n)
				continue;
			
//			if (book[tx][ty] == 0) {
//				book[tx][ty] = 1;
				hp += dungeon[tx][ty];
				if (hp < curMin)
				{
					curMin = hp;
				}
				dfs(dungeon, tx, ty, book, hp, curMin);
				hp -= dungeon[tx][ty];
//				book[tx][ty] = 0;
//			}
		}
		
	}
	
	public int calculateMinimumHP2(int[][] dungeon)
	{
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[] hp = new int[m*n];
		hp[0] = dungeon[0][0];
		//int[][] book = new int[dungeon.length][dungeon[0].length];
		//book[0][0] = 1;
		bfs(dungeon, 0, 0, hp, 1);
		return min;
	} 
	
	public void bfs(int[][] dungeon, int x, int y, int[] hp, int curMin)
	{
		int m = dungeon.length;
		int n = dungeon[0].length;
		
		Queue<Integer> queue = new LinkedList<>();
		
		int code = x * m + y;
		queue.add(code);
		
		int[][] next = {
				{0, 1},
				{1, 0}
		};
		
		while (!queue.isEmpty())
		{
			code = queue.poll();
			x = code / m;
			y = code % m;
			for (int k = 0; k < 2; k++)
			{
				int tx = x + next[k][0];
				int ty = y + next[k][1];
				
				if ((tx == m-1 && ty == n) || (tx == m && ty == n-1))
				{
					if (min < curMin)
						min = curMin;
					return;
				}
				
				if (tx < 0 || tx >= m || ty < 0 || ty >= n)
					continue;
				
				code = tx * m + ty;
				queue.offer(code);
				
				hp[code] = dungeon[tx][ty] + hp[x*m+y];
				if (hp[code] < curMin)
				{
					curMin = hp[code];
				}
				//hp -= dungeon[tx][ty];
				
				
			}
		}
	}
	
	
	public int calculateMinimumHP3(int[][] dungeon)
	{
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] hp = new int[m][n];
		
		hp[m-1][n-1] = dungeon[m-1][n-1] < 0 ? 1-dungeon[m-1][n-1] : 1;
		
		for (int j = n-2; j >= 0; j--)
		{
			hp[m-1][j] = hp[m-1][j+1] - dungeon[m-1][j] <= 0 ? 1 : hp[m-1][j+1] - dungeon[m-1][j];
		}
		
		for (int i = m-2; i >= 0; i--)
		{
			hp[i][n-1] = hp[i+1][n-1] - dungeon[i][n-1] <= 0 ? 1 : hp[i+1][n-1] - dungeon[i][n-1];
		}
		
		for (int i = m-2; i >= 0; i--)
		{
			for (int j = n-2; j >= 0; j--)
			{
				hp[i][j] = Math.min(hp[i+1][j], hp[i][j+1]) - dungeon[i][j] <= 0 ? 1 : Math.min(hp[i+1][j], hp[i][j+1]) - dungeon[i][j];
			}
		}
		
		return hp[0][0];
	}
	
	public static void main(String[] args)
	{
		int [][] dungeon = {
				{-2, -3, 3},
				{-5, -10, 1},
				{10, 30, -5},
		};
		
		DungeonGame main = new DungeonGame();
		System.out.println(main.calculateMinimumHP3(dungeon));
	}
}
