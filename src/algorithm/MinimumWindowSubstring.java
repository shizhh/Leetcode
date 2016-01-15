package algorithm;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static String minWindow(String s, String t) {
		if (s == null || s.length() < t.length() || s.length() == 0)
			return "";
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			map.put(ch, map.containsKey(ch) ? map.get(ch)+1 : 1);
		}
		
		int counter = t.length();
		int begin=0, end=0, d=s.length()+1, head=0;
		while (end < s.length()) {
			if (map.containsKey(s.charAt(end))) {
				map.put(s.charAt(end), map.get(s.charAt(end))-1);
				if (map.get(s.charAt(end)) >= 0) {
					counter--;
				}
			}
			while (counter == 0) {
				if (end - begin +1 < d) {
					d = end -begin+1;
					head = begin;
				}
				char ch2 = s.charAt(begin);
				if (map.containsKey(s.charAt(begin))) {
					map.put(s.charAt(begin), map.get(s.charAt(begin))+1);
					if (map.get(s.charAt(begin)) > 0) {
						counter++;
					}
				}
				begin++;
			}
			end++;
		}
		return d > s.length() ? "" : s.substring(head, head+d);
	}
	
	public static void main(String[] args) {
		String s = "AAAABEDCOOODRBANC";
		String t = "ABC";
		System.out.println(minWindow(s, t));
	}
}
