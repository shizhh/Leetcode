package algorithm;


public class BestTimetoBuyandSellStock
{
	public int maxProfit(int[] prices)
	{
		int len = prices.length;
		if (len <= 1)
			return 0;
		int profit = 0;
		int minPrice = prices[0];
		for (int i = 1; i < len; i++)
		{
			minPrice = Math.min(minPrice, prices[i-1]);
			if (prices[i] - minPrice > profit)
				profit = prices[i] - minPrice;
		}
		return profit;
	}
	
	// ---------------------------------
	// 转化为数组中的最大子段和
	// ---------------------------------
	public int maxProfit2(int[] prices)
	{
		int len = prices.length;
		if (len <= 1)
			return 0;
		
		int maxSum = 0, curSum = 0;
		for (int i = 1; i < len; i++)
		{
			curSum += prices[i] - prices[i-1];
			if (curSum <= 0)
				curSum = 0;
			if (curSum > maxSum)
				maxSum = curSum;
			
		}
		return maxSum;
	}
	
	
	public static void main(String[] args)
	{
		int[] prices = {5, 2, 4, 6, 3, 7, 1, 10};
		BestTimetoBuyandSellStock main = new BestTimetoBuyandSellStock();
		System.out.println(main.maxProfit(prices));
		System.out.println(main.maxProfit2(prices));
	}
}
