package algorithm;


public class BestTimetoBuyandSellStock3
{
	public int maxProfit(int[] prices)
	{
		int len = prices.length;
		if (len <= 1)
			return 0;
		
		int[] profit = new int[len];
		profit[0] = 0;
		// 从前往后
		int maxProfit = 0;
		int minPrice = prices[0];
		for (int i = 1; i < len; i++)
		{
			minPrice = Math.min(prices[i-1], minPrice);
			if (prices[i]-minPrice > maxProfit)
				maxProfit = prices[i]-minPrice;
			profit[i] = maxProfit;
		}
		// 从后往前
		int result = profit[len-1];
		int maxPrice = prices[len-1];
		maxProfit = 0;
		for (int i = len-2; i >= 0; i--)
		{
			maxPrice = Math.max(maxPrice, prices[i+1]);
			if (maxPrice - prices[i] > maxProfit)
				maxProfit = maxPrice - prices[i];
			if (result < profit[i] + maxProfit)
				result = profit[i] + maxProfit;
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		int[] prices = {1, 4, 5, 7};
		BestTimetoBuyandSellStock3 main = new BestTimetoBuyandSellStock3();
		System.out.println(main.maxProfit(prices));
	}
	
}
