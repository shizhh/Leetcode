package algorithm2;

import java.util.LinkedList;
import java.util.Queue;

public class BFS
{
	class Note
	{
		int x;
		int y;
		int f;
		int s;
	}
	
	public void bfs(int[][] a, int x, int y, int startx, int starty)
	{
		Queue<Note> queue = new LinkedList<>();
		int m = a.length;
		int n = a[0].length;
		int[][] book = new int[m][n];
		int next[][] = {
				{0, 1},
				{1, 0},
				{0, -1},
				{-1, 0}
		};
		Note note = new Note();
		note.x = startx;
		note.y = starty;
		note.s = 0;
		note.f = 0;
		queue.offer(note);
		book[startx][starty] = 1;
		int flag = 0;
		while (!queue.isEmpty())
		{
			// 枚举4个方向
			for (int i = 0; i <= 3; i++)
			{
				Note note1 = queue.peek();
				int tx = note1.x + next[i][0];
				int ty = note1.y + next[i][1];
				if (tx < 0 || tx >= m || ty < 0 || ty >= n)
					continue;
				Note note2 = null;
				if (a[tx][ty] == 0 && book[tx][ty] == 0)
				{
					book[tx][ty] = 1;
					note2 = new Note();
					note2.x = tx;
					note2.y = ty;
					note2.s = note1.s + 1;
					//note2.f = note1
					queue.offer(note2);
				}
				if (tx == x && ty == y)
				{
					flag = 1;
					System.out.println(note2.s);
					break;
				}
			}
			if (flag == 1){
				System.out.println("finded");
				//System.out.println(queue.peek().s);
				//System.out.println(queue.size());
				break;
			}
			queue.poll();
		}
	}
	
	public static void main(String[] args)
	{
		int[][] a = {
				{0,0,1,0},
				{0,0,0,0},
				{0,0,1,0},
				{0,1,0,0},
				{0,0,0,1}
		};
		
		int x = 3, y = 2;
		BFS main = new BFS();
		main.bfs(a, x, y, 0, 0);
	}
}
