package algorithm;


public class BestTimetoBuyandSellStock4
{
	public int maxProfit(int k, int[] prices)
	{
		
		int day = prices.length;
		
		if (k >= day / 2)
		{
			int profit = 0;
			for (int i = 1; i < day; i++)
			{
				if (prices[i]-prices[i-1] > 0)
					profit += prices[i]-prices[i-1];
			}
			return profit;
		}
		
		int[][] profit = new int[k+1][day];	// profit[j][i]表示第i天前操作了j次的最大收益，要求profit[k][day]
		
//		for (int i = 0; i <= k; i++)
//		{
//			profit[i][0] = 0;
//		}
//		for (int i = 0; i < day; i++)
//		{
//			profit[0][i] = 0;
//		}
		
		for (int i = 1; i <= k; i++)
		{
			int max = -prices[0];
			for (int j = 1; j < day; j++)
			{
				profit[i][j] = Math.max(prices[j]+max, profit[i][j-1]);
				max = Math.max(max, profit[i-1][j-1]-prices[j]);
			}
		}
		
		return profit[k][day-1];
	}
	
	public static void main(String[] args)
	{
		int[] prices = {5, 2, 4, 6, 3, 7, 1, 10};
		int k = 1;
		BestTimetoBuyandSellStock4 main = new BestTimetoBuyandSellStock4();
		System.out.println(main.maxProfit(k, prices));
	}
}
