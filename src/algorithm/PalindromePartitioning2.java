package algorithm;


public class PalindromePartitioning2
{
	int min = Integer.MAX_VALUE;
	
    public int minCut(String s) {
        int count = 0;
        dfs(s,0,count);
        return min-1;
    }
    
    public void dfs(String s, int pos, int count)
    {
    	if (pos == s.length())
    	{
    		min = Math.min(min, count);    		
    		return ;
    	}
    	
    	for (int i = pos; i < s.length(); i++)
    	{
    		if (isPalindrome(s, pos, i))
    		{
    			dfs(s, i+1, count+1);
    		}
    	}
    	
    }
    
    public boolean isPalindrome(String s, int i, int j)
    {
    	while (i < j)
    	{
    		if (s.charAt(i++) != s.charAt(j--))
    			return false;
    	}
    	return true;
    }
    
    public int minCut2(String s)
    {
    	if (s == null || s.length() < 2)
    		return 0;
    	
    	int len = s.length();
    	boolean [][] map = new boolean[len][len];
    	int[] cuts = new int[len];	// cuts[i]表示0-i的最小切割数
    	
    	// dp过程
    	for (int i = 0; i <= len-1; i++)
    	{
    		cuts[i] = i;
    		for (int j = 0; j <= i; j++)
    		{
    			if (s.charAt(j) == s.charAt(i) && (j+1 > i-1 || map[j+1][i-1]))
    			{
    				map[j][i] = true;
    				if (j == 0)
    					cuts[i] = 0;
    				else
    					cuts[i] = Math.min(cuts[i], cuts[j-1]+1);
    			}
    		}
    	}
    	return cuts[len-1];
    }
    
    
    public static void main(String[] args)
    {
    	String s = "aaabcd";
    	PalindromePartitioning2 main = new PalindromePartitioning2();
    	System.out.println(main.minCut2(s));
    	
    }
}
