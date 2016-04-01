package algorithm;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle
{
	
	public static int maxRectangle(char[][] matrix, int row, int col)
	{
		int m = matrix.length;
		int n = matrix[0].length;
		int minWidth = Integer.MAX_VALUE;
		int maxArea = 0;
		for (int i = row; i < m; i++)
		{
			if (matrix[i][col] == '1')
			{
				int width = 0;
				while (col + width < n && matrix[i][col + width] == '1')
				{
					width++;
				}
				if (width < minWidth)
				{
					minWidth = width;
				}
				int area = minWidth * (i - row + 1);
				if (area > maxArea)
				{
					maxArea = area;
				}
			}
		}
		return maxArea;
	}
	
	public static int maximalRectangle(char[][] matrix)
	{
		int m = matrix.length;
		if (m < 1)
		{
			return 0;
		}
		int n = matrix[0].length;
		int maxArea = 0;
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (matrix[i][j] == '1')
				{
					int area = maxRectangle(matrix, i, j);
					if (area > maxArea)
					{
						maxArea = area;
					}
				}
			}
		}
		return maxArea;
	}
	
	/**
	 * 如果我们把每一行看成x坐标，那高度就是从那一行开始往上数的1的个数。
	 * 带入我们的maxAreaInHist方法，在O(n^2)时间内就可以求出每一行形成的“柱状图”的最大矩形面积了。
	 * 它们之中最大的，就是我们要的答案。
	 */
	public static int maximalRectangle2(char[][] matrix)
	{
		int m = matrix.length;
		if (m < 1)
		{
			return 0;
		}
		int n = matrix[0].length;
		int[][] heights = new int[m][n + 1];
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (matrix[i][j] == '0')
				{
					heights[i][j] = 0;
				}
				else
				{
					heights[i][j] = i == 0 ? 1 : heights[i - 1][j] + 1;
				}
			}
		}
		int maxArea = 0;
		for (int i = 0; i < m; i++)
		{
			int area = maxAreaInHist(heights[i]);
			if (area > maxArea)
			{
				maxArea = area;
			}
		}
		return maxArea;
	}
	
	public static int maxAreaInHist(int[] heights)
	{
		int n = heights.length;
		Stack<Integer> s = new Stack<>();
		int max_area = -1;
		int[] h = Arrays.copyOf(heights, n + 1); // h[n]=0
		int i = 0;
		while (i < h.length)
		{
			if (s.isEmpty() || h[i] >= h[s.peek()])
			{
				s.push(i++);
			}
			else
			{
				int top = s.pop();
				int area = h[top] * (s.isEmpty() ? i : i - 1 - s.peek());
				max_area = Math.max(area, max_area);
			}
		}
		return max_area;
	}
	
	public static int maximalRectangleUsingDP(char[][] matrix)
	{
		int m = matrix.length;
		int n = matrix[0].length;
		int maxA = 0;
		int[] left = new int[n];
		int[] right = new int[n];
		for (int i = 0; i < n; i++)
			right[i] = n;
		int[] height = new int[n];
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
				height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
			int preleft = 0;
			for (int j = 0; j < n; j++)
			{
				if (matrix[i][j] == '1')
					left[j] = Math.max(left[j], preleft);
				else
				{
					left[j] = 0;
					preleft = j + 1;
				}
			}
			int preright = n;
			for (int j = n - 1; j >= 0; j--)
			{
				if (matrix[i][j] == '1')
					right[j] = Math.min(right[j], preright);
				else
				{
					right[j] = n;
					preright = j;
				}
			}
			for (int j = 0; j < n; j++)
				maxA = Math.max((right[j] - left[j]) * height[j], maxA);
		}
		return maxA;
	}
	
	public static int maximalRectangle3(char[][] matrix)
	{
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
		{
			return 0;
		}
		int rows = matrix.length, cols = matrix[0].length;
		int[] left = new int[cols], right = new int[cols], top = new int[cols];
		Arrays.fill(left, cols); // max distance (inclusive) to left-most 1 at
								 // (y,x)
		Arrays.fill(right, cols); // max distance (inclusive) to right-most 1 at
								  // (y,x)
		Arrays.fill(top, 0); // max distance (inclusive) to top-most 1 at (y,x)
		int max = 0;
		for (int y = 0; y < rows; y++)
		{
			for (int x = 0; x < cols; x++)
			{
				if (matrix[y][x] == '1')
				{
					top[x] += 1;
				}
				else
				{
					top[x] = 0;
				}
			}
			int l = 0; // max left distance so far
			for (int x = 0; x < cols; x++)
			{
				if (matrix[y][x] == '1')
				{
					left[x] = Math.min(left[x], ++l);
				}
				else
				{
					left[x] = cols;
					l = 0;
				}
			}
			int r = 0; // max right distance so far
			for (int x = cols - 1; x >= 0; x--)
			{
				if (matrix[y][x] == '1')
				{
					right[x] = Math.min(right[x], ++r);
				}
				else
				{
					right[x] = cols;
					r = 0;
				}
			}
			for (int x = 0; x < cols; x++)
			{
				if (matrix[y][x] == '1')
				{
					// width should exclude double count of current element
					max = Math.max(max, (left[x] + right[x] - 1) * top[x]);
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args)
	{
		char[][] matrix = {
				{ '0', '0', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' },
				{ '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' } };
		long time0 = System.currentTimeMillis();
		int area = maximalRectangle(matrix);
		long time1 = System.currentTimeMillis();
		System.out.println("area=" + area);
		System.out.println(time1 - time0);
		System.out.println(maximalRectangleUsingDP(matrix));
		// System.out.println(maximalRectangle3(matrix));
	}
}
