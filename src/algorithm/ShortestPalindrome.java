package algorithm;


public class ShortestPalindrome
{
	
	public String shortestPalindrome_usingkmp(String s)
	{
		if (s.length() <= 1)	return s;
		String str = s + "#" + new StringBuilder(s).reverse().toString();
		int[] next = new int[str.length()];
		
		for (int i = 1; i < str.length(); i++)
		{
			int pre = next[i-1];
			while (pre > 0 && str.charAt(i) != str.charAt(pre))
				pre = next[pre-1];
			if (str.charAt(i) == str.charAt(pre))
				pre++;
			next[i] = pre;
		}
		
		return new StringBuilder(s.substring(next[next.length-1])).reverse().toString()+s;
	}
	
	public String shortestPalindrome(String s)
	{
		StringBuilder sb = new StringBuilder(s);
		int head = 0;
		int tail = s.length()-1;
		int len = s.length();
		int insertIndex = 0;
		while (head < tail)
		{
			while (head < tail && sb.substring(head, head+1).equals(sb.substring(tail, tail+1)))
			{
				head += 1;
				tail -= 1;
			}
			if (head >= tail)
				break;
			tail = sb.length()-1 - insertIndex;
			sb.insert(insertIndex++, sb.substring(tail, tail+1));
			head = insertIndex;
			tail = sb.length()-1 - insertIndex;
		}
		return sb.toString();
	}
	
	public static void main(String[] args)
	{
//		String s = "aabba";
		String s = "aaabaa";
//		String s = "aacecaaa";
//		System.out.println(s.length());
		ShortestPalindrome sp = new ShortestPalindrome();
		System.out.println(sp.shortestPalindrome_usingkmp(s));
	}
}
