package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak2 {
    
    Map<String, List<String>> map = new HashMap<>();
    
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
    	StringBuilder sb = new StringBuilder();
    	helper(s, wordDict, sb, res);
    	return res;
    }
    
    public void helper(String s, Set<String> wordDict, StringBuilder sb, List<String> res) {
        
    	if (s == null || s.length() == 0)
    	{
    		res.add(sb.toString().substring(1));
    		return;
    	}
    	
    	if (map.containsKey(s))
    	{
    	    for (String str : map.get(s))
    	    {
    		    sb.append(str);
    		    res.add(sb.toString().substring(1));
    	        sb.delete(sb.length()-str.length(), sb.length());
    	    }
    		return;
    	}
    	
    	for (String word : wordDict)
    	{
    		int len = word.length();
    		if (len <= s.length() && s.substring(0, len).equals(word))
    		{
    			sb.append(" "+ word);
    			helper(s.substring(len), wordDict, sb, res);
    			map.put(s.substring(len), res);
    			sb.delete(sb.length()-len-1, sb.length());
    		}
    	}
    	
    }
    
    public List<String> wordBreak2(String s, Set<String> wordDict)
    {
    	List<String> list = new ArrayList<>();
    	if(map.containsKey(s))	return map.get(s);
    	
    	for (int i = 1; i <= s.length(); i++)
    	{
    		String left = s.substring(0,i);
    		String right = s.substring(i);
    		if (wordDict.contains(left))
    		{
    			List<String> a = wordBreak2(right, wordDict);
    			for (String b : a)
    			{
    				list.add(left+" "+b);
    			}
    			if (right.length() == 0)	list.add(left);
    		}
    	}
    	map.put(s, list);
    	return list;
    }
    
    public static void main(String[] args)
    {
    	String s  = "catsanddog";
    	Set<String> wordDict = new HashSet<>();
    	wordDict.add("cat");
    	wordDict.add("cats");
    	wordDict.add("and");
    	wordDict.add("sand");
    	wordDict.add("dog");
    	WordBreak2 main = new WordBreak2();
    	System.out.println(main.wordBreak2(s, wordDict));
    }
}