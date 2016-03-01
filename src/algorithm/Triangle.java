package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Triangle
{
	
	// -----------------------------------------
	// 看成倒三角来处理，自底向上
	// -----------------------------------------
	public int minimumTotal(List<List<Integer>> triangle)
	{
		if (triangle == null || triangle.size() == 0)
			return 0;
			
		int[] sum = new int[triangle.size()];
		for (int i = 0; i < triangle.size(); i++)
			sum[i] = triangle.get(triangle.size() - 1).get(i);
			
		for (int i = triangle.size() - 2; i >= 0; i--)
		{
			for (int j = 0; j <= i; j++)
				sum[j] = Math.min(sum[j], sum[j + 1]) + triangle.get(i).get(j);
		}
		return sum[0];
	}
	
	// -----------------------------------------
	// 自顶向下
	// -----------------------------------------
	public int minimumTotal2(List<List<Integer>> triangle)
	{
		if (triangle == null || triangle.size() == 0)
			return 0;
			
		int size = triangle.size();
		int[][] sum = new int[size][size];
		sum[0][0] = triangle.get(0).get(0);
		
		for (int i = 1; i < size; i++)
		{
			sum[i][0] = sum[i - 1][0] + triangle.get(i).get(0);
			for (int j = 1; j < triangle.get(i).size() - 1; j++)
			{
				sum[i][j] = Math.min(sum[i - 1][j - 1], sum[i - 1][j])
						+ triangle.get(i).get(j);
			}
			sum[i][triangle.get(i).size()
					- 1] = sum[i - 1][triangle.get(i - 1).size() - 1]
							+ triangle.get(i).get(triangle.get(i).size() - 1);
		}
		int min = sum[size - 1][0];
		for (int i = 1; i < size; i++)
		{
			if (min > sum[size - 1][i])
				min = sum[size - 1][i];
		}
		return min;
	}
	
	// -----------------------------------------
	// 自顶向下，优化数组
	// -----------------------------------------
	public int minimumTotal3(List<List<Integer>> triangle)
	{
		if (triangle == null || triangle.size() == 0)
			return 0;
		if (triangle.size() == 1)
			return triangle.get(0).get(0);
		int[] sums = new int[triangle.size()];
		sums[0] = triangle.get(0).get(0);
		for (int i = 1; i < triangle.size(); i++)
		{
			sums[i] = sums[i - 1] + triangle.get(i).get(i);
			for (int j = i - 1; j >= 1; j--)
			{
				sums[j] = (sums[j] < sums[j - 1] ? sums[j] : sums[j - 1])
						+ triangle.get(i).get(j);
			}
			sums[0] = sums[0] + triangle.get(i).get(0);
			
		}
		int minimum = sums[0];
		for (int i = 1; i < sums.length; i++)
		{
			if (sums[i] < minimum)
			{
				minimum = sums[i];
			}
		}
		return minimum;
	}
	
	public static void main(String[] args)
	{
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		List<Integer> l3 = new ArrayList<>();
		List<Integer> l4 = new ArrayList<>();
		l1.add(2);
		l2.add(3);
		l2.add(4);
		l3.add(6);
		l3.add(5);
		l3.add(7);
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		list.add(l1);
		list.add(l2);
		list.add(l3);
		list.add(l4);
		
		Triangle main = new Triangle();
		System.out.println(main.minimumTotal(list));
		System.out.println(main.minimumTotal2(list));
	}
}
