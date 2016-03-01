package algorithm;


public class Candy
{
	public int candy(int[] ratings)
	{
		int sum = 0;
		
		int[] candys = new int[ratings.length];
		
		for (int i = 0; i < ratings.length; i++)
			candys[i] = 1;
		
		for (int i = 1; i < ratings.length; i++)
		{
			if (ratings[i] > ratings[i-1])
				candys[i] = candys[i-1]+1;
		}
		
		for (int i = ratings.length-2; i >= 0; i--)
		{
			sum += candys[i+1];
			if (ratings[i] > ratings[i+1] && candys[i] <= candys[i+1])
				candys[i] = candys[i+1]+1;
		}
		sum += candys[0];
		return sum;
	}
	
	
}
