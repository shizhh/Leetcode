package algorithm;

import java.util.HashSet;

/**
 * 
 * 
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * */
public class LongestSubstring {
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int max = 0;
		HashSet<Character> set = new HashSet<Character>();
		int left = 0;
		int right = 0;
		while (right < s.length()) {
			if (!set.contains(s.charAt(right))) {
				set.add(s.charAt(right));
			} else {
				max = max < right - left ? right - left : max;
				while (s.charAt(left) != s.charAt(right)) {
					set.remove(s.charAt(left));
					left = left + 1;
				}
				left = left + 1;
			}
			// The right point add one everytime
			right = right + 1;
		}
		return max > right - left ? max : right - left;
	}

	// This method is just here to test the class
	// public static void main(String[] args) {
	// String s = "abcdefcdefgde";
	// System.out.println(lengthOfLongestSubstring(s));
	// }
}
