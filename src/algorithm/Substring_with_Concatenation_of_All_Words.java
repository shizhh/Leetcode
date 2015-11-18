package algorithm;

import java.util.*;

public class Substring_with_Concatenation_of_All_Words {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "foo";
		String[] words = {"o","o", "f"};
		System.out.println(findSubstring(s, words).toString());
//		System.out.println(s.substring(2,3));
	}
	
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
	
	
}
