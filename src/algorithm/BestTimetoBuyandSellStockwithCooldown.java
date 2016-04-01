package algorithm;

public class BestTimetoBuyandSellStockwithCooldown
{
	
	/*
	 * buy[i] = max(sell[i-2]-price, buy[i-1])
	 * sell[i] = max(buy[i-1]+price, sell[i-1])
	 * */
	
	
	/*
	 * 每一天有3种状态，buy,sell,rest
	 * buy[i] = max(buy[i-1]-price[i], sell[i-1]-price[i], rest[i-1]-price[i], buy[i-1])
	 * sell[i] = max(buy[i-1]+price[i], sell[i-1]+price[i], rest[i-1]+price[i], sell[i-1])
	 * rest[i] = max(buy[i-1], sell[i-1], rest[i-1])
	 * 然后去除上述不合理的情况
	 * buy[i]<=sell[i],rest[i]<=sell[i],所以rest[i] = sell[i-1]
	 * buy[i] = max(buy[i-1]-price[i], sell[i-1]-price[i], sell[i-2]-price[i], buy[i-1])
	 * sell[i] = max(buy[i-1]+price[i], sell[i-1]+price[i], sell[i-2]+price[i], sell[i-1])
	 * 因为 buy[i-1]-price[i] <= buy[i-1], 昨天卖了，今天不可能再买
	 * 所以 buy[i] = max(sell[i-2]-price[i], buy[i-1])
	 * 因为 昨天和前天卖了，今天不可能再卖
	 * 所以 sell[i] = max(buy[i-1]+price[i], sell[i-1])
	 * 
	 * 所以有递推式
	 * buy[i] = max(sell[i-2]-price[i], buy[i-1])
	 * sell[i] = max(buy[i-1]+price[i], sell[i-1])
	 * */
	public int maxProfit(int[] prices)
	{
		int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
		for (int i = 0; i < prices.length; ++i)
		{
			prev_buy = buy;
			buy = Math.max(prev_sell-prices[i], prev_buy);
			prev_sell =sell;
			sell = Math.max(prev_buy+prices[i], prev_sell);
		}
		return sell;
	}
}
