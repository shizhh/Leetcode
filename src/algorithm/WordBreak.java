package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordBreak
{
	
	Map<String, Boolean> map = new HashMap<>();
	
    public boolean wordBreak(String s, Set<String> wordDict) {
    	
    	if (s == null || s.length() == 0)
    		return true;
    	
    	for (String word : wordDict)
    	{
    		int len = word.length();
    		if (s.substring(0, len).equals(word))
    		{
    			if (wordBreak(s.substring(len), wordDict))
    				return true;
    		}
    	}
    	
    	map.put(s, false);
    	return false;
    }
    
}
