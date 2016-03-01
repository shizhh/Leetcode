package algorithm;

import bean.Point;

public class MaxPointsonaLine
{
	public int maxPoints(Point[] points)
	{
		if (points == null || points.length == 0)
			return 0;
		
		if (points.length == 1)
			return 1;
		
		int len = points.length;
		int max = 0;
		for (int i = 0; i < len-1; i++)
		{
			for (int j = i+1; j < len; j++)
			{
				if (points[j].x == points[i].x && points[j].y == points[i].x)
				{
					continue;
				}
				int count = 2;
				for (int k = 0; k < len; k++)
				{
					if (k != i && k != j && (points[k].x-points[i].x)*(points[j].y-points[i].y) == (points[k].y-points[i].y)*(points[j].x-points[i].x))
					{
						count++;
					}
				}
				max = Math.max(count, max);
			}
		}
		return max == 0 ? len : max;
	}
}
