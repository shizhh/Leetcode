package algorithm;

public class ImplementStrStr {
	public static void main(String[] args) {
		String haystack = "a";
		String needle = "a";
		
		ImplementStrStr solution = new ImplementStrStr();
		int res = solution.strStr(haystack, needle);
		System.out.println(res);
	}
	
	public int strStr(String haystack, String needle) {
		int haystack_len = haystack.length();
		int needle_len = needle.length();
		if (haystack_len == 0 && needle_len == 0)
			return 0;
		if (haystack_len < needle_len)
			return -1;
		int i = 0;
		int j = 0;
		for (i = 0; i < haystack_len; i++) {
			int k = i;
			for (j = 0; j < needle_len; j++) {
				if (k == haystack_len)
					return -1;
				char haystack_char = haystack.charAt(k);
				char needle_char = needle.charAt(j);
				if ( haystack_char != needle_char ) {
					break;
				}else {
					//j++;
					k++;
				}
			}
			if ( j == needle_len)
				return i;
		}
		return -1;
	}
}
