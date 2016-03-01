package algorithm;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle
{
	public List<List<Integer>> generate(int numRows)
	{
		List<List<Integer>> res = new ArrayList<>();
		
		if (numRows < 1)
			return res;
		List<Integer> first = new ArrayList<>();
		first.add(1);
		res.add(first);
		for (int i = 2; i <= numRows; i++)
		{
			List<Integer> list = new ArrayList<>();
			List<Integer> preList = res.get(i-2);
			for (int j = 0; j < i; j++)
			{
				if (j == 0)
					list.add(1);
				else if (j == i-1)
					list.add(1);
				else 
				{
					list.add(preList.get(j-1)+preList.get(j));
				}
			}
			res.add(list);
		}
		
		
		return res;
	}
	
	public static void main(String[] args)
	{
		PascalTriangle main = new PascalTriangle();
		System.out.println(main.generate(0));
	}
}
