# -*- coding: utf-8 -*-
"""
 @File: stock.py
 @desc: 
 @Time: 2020/4/7 5:02 下午
"""

"""
三个状态：天数i，交易次数k，是否持有0/1
0<=i<=n-1, 1<=k<=K
dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+prices[i])
dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i])
初始化：
dp[-1][k][0] = 0
dp[-1][k][1] = -inf
dp[i][0][0] = 0
dp[i][0][1] = -inf
"""


def max_profit_1(prices):
    """
    最多交易1次，即k=1，状态转移方程退化为
    dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
    dp[i][1] = max(dp[i-1][1], dp[i-1][-1][0]-prices[i])
    """
    inf = float("inf")
    n = len(prices)
    dp = [[0, 0] for _ in range(n)]
    for i in range(n):
        if i == 0:
            dp[i][0] = 0
            dp[i][1] = -inf
        else:
            dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
            dp[i][1] = max(dp[i-1][1], -prices[i])
    return dp[n-1][0]


def max_profit_2(prices):
    """
    最多交易无数次，即k=inf，k=k-1，状态转移方程退化为
    dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
    dp[i][1] = max(dp[i-1][1], dp[i-1][0]-prices[i])
    """
    inf = float("inf")
    n = len(prices)
    dp = [[0, 0] for _ in range(n)]
    for i in range(n):
        if i == 0:
            dp[i][0] = 0
            dp[i][1] = -inf
        else:
            dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
            dp[i][1] = max(dp[i-1][1], dp[i-1][0]-prices[i])
    return dp[n-1][0]


def max_profit_3(prices):
    """
    最多交易无数次，即k=inf，k=k-1，每次卖出之后要等一天才能继续交易，状态转移方程退化为
    dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
    dp[i][1] = max(dp[i-1][1], dp[i-2][0]-prices[i])
    """
    inf = float("inf")
    n = len(prices)
    dp = [[0, 0] for _ in range(n)]
    for i in range(n):
        if i == 0:
            dp[i][0] = 0
            dp[i][1] = -inf
        elif i == 1:
            dp[i][0] = 0
            dp[i][1] = -prices[i]
        else:
            dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
            dp[i][1] = max(dp[i-1][1], dp[i-2][0]-prices[i])
    return dp[n-1][0]


def max_profit_4(prices, fee):
    """
    最多交易无数次，即k=inf，k=k-1，有手续费，状态转移方程退化为
    dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
    dp[i][1] = max(dp[i-1][1], dp[i-1][0]-prices[i]-fee)
    """
    inf = float("inf")
    n = len(prices)
    dp = [[0, 0] for _ in range(n)]
    for i in range(n):
        if i == 0:
            dp[i][0] = 0
            dp[i][1] = -inf
        else:
            dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
            dp[i][1] = max(dp[i-1][1], dp[i-1][0]-prices[i]-fee)
    return dp[n-1][0]


def max_profit_5(prices, K):
    """
    最多交易2次，状态转移方程退化为
    dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+prices[i])
    dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i])
    """
    # K = 2
    inf = float("inf")
    n = len(prices)
    dp = [[[0, 0] for _ in range(K+1)] for _ in range(n)]
    for i in range(n):

        for k in range(1, K+1):
            if i == 0:
                dp[i][k][0] = 0
                dp[i][k][1] = -inf
            else:
                dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+prices[i])
                dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i])
    return dp[n-1][K][0]



def test():
    prices = [3,2,6,0,1,3,5,8,3,10]
    print(max_profit_1(prices))
    print(max_profit_2(prices))
    print(max_profit_3(prices))
    print(max_profit_4(prices, 3))
    print(max_profit_5(prices, 3))

test()
