package algorithm;


public class ValidPalindrome
{
	public boolean isPalindrome(String s)
	{
		if (s == null)
			return true;
		s = s.toLowerCase();
		int len = s.length();
		int start = 0;
		int end = len - 1;
		
		while (start < end)
		{
			while (start <= end && !('A'<=s.charAt(start) && s.charAt(start)<='Z') 
					&& !('a'<=s.charAt(start) && s.charAt(start)<='z') 
					&& !('0'<=s.charAt(start) && s.charAt(start)<='9'))
				start++;
			if (start == end+1)
				return true;
			while (end >= start && !('A'<=s.charAt(end) && s.charAt(end)<='Z')
					&& !('a'<=s.charAt(end) && s.charAt(end)<='z')
					&& !('0'<=s.charAt(end) && s.charAt(end)<='9'))
				end--;
			if (s.charAt(start) != s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		String s = "";
		ValidPalindrome main = new ValidPalindrome();
		System.out.println(main.isPalindrome(s));
	}
}
