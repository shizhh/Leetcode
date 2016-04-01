package algorithm;


public class MaximalSquare
{
	public int maximalSquare(char[][] matrix)
	{
		int[][] p = new int[matrix.length][matrix[0].length];
		int edge = 0;
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				if (i>0 && j>0 && matrix[i][j]=='1')	p[i][j] = min3(p[i-1][j-1]+1, p[i-1][j]+1, p[i][j-1]+1);
				
				if (i == 0)		p[i][j] = matrix[i][j]=='1' ? 1 : 0;
				
				if (j == 0)		p[i][j] = matrix[i][j]=='1' ? 1 : 0;
				
				edge = Math.max(p[i][j], edge);
				
			}
		}
		return edge*edge;
	}
	
	private int min3(int a, int b, int c)
	{
		return Math.min(Math.min(a, b), c);
	}
}
