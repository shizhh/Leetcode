package algorithm;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {

	/**
	 * Time Limit Exceeded
	 * */
	public static List<Integer> findSubstring(String s, String[] words){
	
		List<Integer> res = new ArrayList<>();
		
		int wordLength = words[0].length();
		int wordsLength = words.length;
		
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word)+1);
			}else {
				map.put(word, 1);
			}
		}
		
		for (int i=0, len=s.length(), len1=len-wordLength*wordsLength; i<=len1; i++) {
			
			Map<String, Integer> temp = new HashMap<>();
			temp.putAll(map);
			
			int from = i;
			String str = s.substring(from, from+wordLength);
			int count = 0;//记录命中了单词的次数
			while (temp.containsKey(str) && temp.get(str)>0) {
				count++;
				temp.put(str, map.get(str) - 1);
				
				from = from + wordLength;
				if (from + wordLength> len)
					break;//越界
				else str = s.substring(from, from+wordLength);
			}
			
			if (count == wordsLength) {//若L中所有的词命中了一次，则记录下 index
				res.add(i);
			}
			
		}
		
		
		return res;
	}
	
	public static List<Integer> findSubstring2(String s, String[] words) {
		List<Integer> ans = new ArrayList<>();
		int n = s.length();
		int cnt = words.length;	// number of words
		if (n <= 0 || cnt <= 0)	return ans;
		
		// initialize dict from words
		Map<String, Integer> dict = new HashMap<>();
		for (String w : words)
			dict.put(w, !dict.containsKey(w) ? 1 : dict.get(w)+1);
		
		int wl = words[0].length();	// length of each word
		
		for (int i = 0; i < wl; ++i) {
			int left = i, count = 0;
			Map<String, Integer> tdict = new HashMap<>();
			for (int j = i; j <= n - wl; j += wl) {
				String str = s.substring(j, j+wl);
				if (dict.containsKey(str)) {
					tdict.put(str, !tdict.containsKey(str) ? 1 : tdict.get(str)+1);
					if (tdict.get(str) <= dict.get(str)) {
						count++;
					}else {
						while (tdict.get(str) > dict.get(str)) {
							String str1 = s.substring(left, left+wl);
							tdict.put(str1, tdict.get(str1)-1);
							if (tdict.get(str1) < dict.get(str1))
								count--;
							left += wl;
						}
					}
					if (count == cnt) {
						ans.add(left);
						String tstr = s.substring(left, left+wl);
						tdict.put(tstr, tdict.get(tstr)-1);
						count--;
						left += wl;
					}
				}else {
					tdict.clear();
					count = 0;
					left = j + wl;
				}
			}
		}
			
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "barfoothefoobar";
		String[] words = {"foo","bar"};
		System.out.println(findSubstring2(s, words).toString());
//		System.out.println(s.substring(2,3));
	}
	
}
