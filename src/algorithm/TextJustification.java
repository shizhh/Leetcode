package algorithm;

import java.util.ArrayList;
import java.util.List;


public class TextJustification {
	
	public static List<String> fullJustify(String[] words, int maxWidth) {
		int n = words.length;
		List<String> res = new ArrayList<>();
		List<String> res2 = new ArrayList<>();
		int remain;	// unused spaces
		int used;	// used spaces
		for (int i = 0; i < n; ) {
			List<String> list = new ArrayList<>();
			remain = maxWidth;
			used = 0;
			while (i < n && remain >= words[i].length()) {
				remain = remain - words[i].length() - 1;
				list.add(words[i]);
				used += words[i].length();
				i++;
			}
			res.add(list2String(list, used, maxWidth));
			res2.add(list2String(list,remain+1));
		}
		res.remove(res.size() - 1);
		res.add(res.size(), res2.get(res2.size()-1));
		return res;
	}
	
	private static String list2String(List<String> list, int used, int maxWidth) {
		StringBuilder sb = new StringBuilder();
		int size = list.size();
		
		if (size == 1) {
			sb.append(list.get(0)+kSpaces(maxWidth-used));
			return sb.toString();
		}
		
		int spaces = (maxWidth - used) / (size - 1);
		int rspaces = (maxWidth - used) % (size - 1);
		int i;
		for (i = 0; i < size-1; i++) {
			if (rspaces > 0) {
				sb.append(list.get(i)+kSpaces(spaces+1));
				rspaces--;
			}
			else {
				sb.append(list.get(i)+kSpaces(spaces));
			}
		}
		sb.append(list.get(i));
		return sb.toString();
	}
	
	private static String list2String(List<String> list, int unused) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (i = 0; i < list.size() - 1; i++) {
			sb.append(list.get(i)+" ");
		}
		sb.append(list.get(i)+kSpaces(unused));
		return sb.toString();
	}
	
	private static String kSpaces(int k) {
		StringBuilder sb = new StringBuilder();
		while (k > 0) {
			sb.append(" ");
			k--;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String[] words = {"This", "is", "an", "example", "of", "text", "justification.", "aa"};
		List<String> res = fullJustify(words, 16);
		System.out.println(res);
		
	}
}
