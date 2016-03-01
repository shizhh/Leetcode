package algorithm;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning
{
    public List<List<String>> partition(String s) {
    	List<List<String>> res = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        dfs(s,0,list,res);
        return res;
    }
    
    public void dfs(String s, int pos, List<String> list, List<List<String>> res)
    {
    	if (pos == s.length())
    	{
    		res.add(new ArrayList<>(list));
    		return;
    	}
    	
    	for (int i = pos; i < s.length(); i++)
    	{
    		if (isPalindrome(s, pos, i))
    		{
    			list.add(s.substring(pos, i+1));
    			dfs(s, i+1, list, res);
    			list.remove(list.size()-1);
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
    
    public static void main(String[] args)
    {
    	String s = "aaa";
    	PalindromePartitioning main = new PalindromePartitioning();
    	System.out.println(main.partition(s));
    }
}
