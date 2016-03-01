package algorithm;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class GroupAnagrams {
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<>();
		//Arrays.sort(strs);
		for (String s : strs) {
			char[] tc = s.toCharArray();
			Arrays.sort(tc);
			String key = String.valueOf(tc);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(s);
		}
		
		for(String key: map.keySet()) {
	        Collections.sort(map.get(key));
	    }
		
		return new ArrayList<List<String>>(map.values());
	}
	
	
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = groupAnagrams(strs);
		System.out.println(res);
	}
	
}
