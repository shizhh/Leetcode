package algorithm;

public class DistinctSubsequences
{
	// 自底向上
	public int numDistinct(String s, String t)
	{
		int sLen = s.length();
		int tLen = t.length();
		int[][] dp = new int[tLen + 1][sLen + 1];
		// 初始化
		for (int i = 0; i <= sLen - 1; i++)
		{
			dp[0][i] = 1;
		}
		
		for (int i = 0; i <= tLen - 1; i++)
			for (int j = 0; j <= sLen - 1; j++)
			{
				if (s.charAt(j) == t.charAt(i))
				{
					dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j];
				}
				else
					dp[i + 1][j + 1] = dp[i + 1][j];
			}
			
		return dp[tLen][sLen];
	}
	
	// 自顶向下
	public int numDistinct2(String S, String T)
	{
		if (S.length() == 0)
		{
			return T.length() == 0 ? 1 : 0;
		}
		if (T.length() == 0)
		{
			return 1;
		}
		int cnt = 0;
		for (int i = 0; i < S.length(); i++)
		{
			if (S.charAt(i) == T.charAt(0))
			{
				cnt += numDistinct2(S.substring(i + 1), T.substring(1));
			}
		}
		return cnt;
	}
	
	// 带备忘录的自顶向下
	public int numDistinct3(String s, String t)
	{
		int sLen = s.length();
		int tLen = t.length();
		int [][] r = new int[tLen+1][sLen+1];
		for (int i = 0; i <= tLen; i++)
			for (int j = 0; j <= sLen; j++)
				r[i][j] = -1;
		
		return memoizedNumDistinct(s, t, r);
	}
	
	private int memoizedNumDistinct(String s, String t, int[][] r)
	{
		if (s.length() == 0)
		{
			return t.length() == 0 ? 1 : 0;
		}
		if (t.length() == 0)
		{
			return 1;
		}
		
		int sLen = s.length();
		int tLen = t.length();
		if (r[tLen][sLen] >= 0)
			return r[tLen][sLen];
		
		int cnt = 0;
		for (int i=0; i < sLen; i++)
		{
			if (s.charAt(i) == t.charAt(0))
			{
				cnt += memoizedNumDistinct(s.substring(i + 1), t.substring(1), r);
			}
		}
		
		return cnt;
	}
	
	public int numDistinct4(String s, String t)
	{
		int sLen = s.length();
		int tLen = t.length();
		if (tLen == 0)
		{
			return sLen >= 0 ? 1 : 0;
		}
		if (sLen <= tLen)
		{
			if (s.equals(t))
				return 1;
			else return 0;
		}
		if (s.charAt(sLen-1) != t.charAt(tLen-1))
			return numDistinct4(s.substring(0, sLen-1), t);
		else
			return numDistinct4(s.substring(0, sLen-1), t) + numDistinct4(s.substring(0, sLen-1), t.substring(0, tLen-1));
	}
	
	public static void main(String[] args)
	{
		String s = "aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe";
		String t = "bddabdcae";
		DistinctSubsequences main = new DistinctSubsequences();
		System.out.println(main.numDistinct3(s, t));
		System.out.println(main.numDistinct4(s, t));
	}
}
