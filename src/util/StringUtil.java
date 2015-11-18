package util;

public class StringUtil
{
	
	public static void main(String[] args)
	{
		String s = StringUtil.reverse("abcde");
		System.out.println(s);
	}
	
	public static String reverse(String s)
	{

		char[] str = s.toCharArray();

		int begin = 0;
		int end = s.length() - 1;

		while (begin < end)
		{
			str[begin] = (char) (str[begin] ^ str[end]);
			str[end] = (char) (str[begin] ^ str[end]);
			str[begin] = (char) (str[end] ^ str[begin]);
			begin++;
			end--;
		}

		return String.valueOf(str);
	}
}
