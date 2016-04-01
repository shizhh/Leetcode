package algorithm;


public class PerfectSquares
{
	public int numSquares_dp(int n)
	{
		int[] p = new int[n+1];
		p[0] = 0;
		for (int i = 1; i <= n; i++)
		{
			p[i] = n;
			for (int j = 1; j*j <= i; j++)
			{
				p[i] = Math.min(p[i], p[i-j*j]+1);
			}
			
		}
		return p[n];
	}
	
	public int numSquares_recurive(int n)
	{
		int res = n;
		if (n == 0 || n == 1)
			return n;
		System.out.println(n);
		for (int j = 1; j*j<=n; j++)
		{
			res = Math.min(numSquares_recurive(n-j*j)+1, res);
		}
		return res;
	}
	
	public static void main(String[] args)
	{
		System.out.println(new PerfectSquares().numSquares_recurive(20)+"....");
	}
}
