package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder
{
	// --------------------------------
	// dfs
	// --------------------------------
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) 
    {
    	if(beginWord==null || endWord==null || beginWord.length()==0 || endWord.length()==0 || beginWord.length()!=endWord.length())  
            return 0;
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        queue.offer(beginWord);
        wordList.add(endWord);
        
        while (!queue.isEmpty())
        {
        	String s = queue.poll();
        	int dis = map.get(s);
        	if (s.equals(endWord))
        	{
        		return dis;
        	}
        	for (int i = 0; i < s.length(); i++)
        	{
        		for (int j = 'a'; j <= 'z'; j++)
        		{
        			StringBuilder sb = new StringBuilder(s);
        			if (sb.charAt(i) == (char)j)
        				continue;
        			sb.setCharAt(i, (char)j);
        			String str = sb.toString();
        			if (!map.containsKey(str) && wordList.contains(str))
        			{
        				queue.offer(str);
        				map.put(str, dis+1);
        			}
        		}
        	}
        }
    	return 0;
    }
    
    public int ladderLength2(String beginWord, String endWord, Set<String> wordList)
    {  
    	if(beginWord==null || endWord==null || beginWord.length()==0 || endWord.length()==0 || beginWord.length()!=endWord.length())  
            return 0; 
        LinkedList<String> queue = new LinkedList<String>();  
        HashSet<String> visited = new HashSet<String>();  
        int level= 1;  
        int lastNum = 1;  
        int curNum = 0;  
        queue.offer(beginWord);  
        visited.add(beginWord);  
        while(!queue.isEmpty())  
        {  
            String cur = queue.poll();  
            lastNum--;  
            for(int i=0;i<cur.length();i++)  
            {  
                char[] charCur = cur.toCharArray();  
                for(char c='a';c<='z';c++)  
                {  
                    charCur[i] = c;  
                    String temp = new String(charCur);  
                    if(temp.equals(endWord))  
                        return level+1;  
                    if(wordList.contains(temp) && !visited.contains(temp))  
                    {  
                        curNum++;  
                        queue.offer(temp);  
                        visited.add(temp);  
                    }  
                }  
            }  
            if(lastNum==0)  
            {  
                lastNum = curNum;  
                curNum = 0;  
                level++;  
            }  
        }  
        return 0;  
    }
    
    public static void main(String[] args)
    {
    	String beginWord = "hit";
    	String endWord = "cog";
    	Set<String> wordList = new HashSet<>();
    	wordList.add("hot");
    	wordList.add("dot");
    	wordList.add("dog");
    	wordList.add("lot");
    	wordList.add("log");
    	
    	WordLadder main = new WordLadder();
    	System.out.println(main.ladderLength(beginWord, endWord, wordList));
    	
    }
}
