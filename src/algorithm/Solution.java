/**
 * 
 */
package algorithm;


import util.StringUtil;

/**
 * @author zhenhui
 *
 */
public class Solution
{
	public static void main(String[] args)
	{
		String a = "0";
		String b = "0";
		String s = Solution.addBinary(a, b);
		System.out.println(s);
	}
	/**
	 * https://leetcode.com/problems/add-binary/
	 * */
	public static String addBinary(String a, String b)
	{
		char[] resultStr = null;
		if (a == "")
			return b;
		else if (b == "")
			return "";
		else 
		{
			a = StringUtil.reverse(a);
			b = StringUtil.reverse(b);
			int lengtha = a.length();
			int lengthb = b.length();
			if (lengtha < lengthb)
			{
				String s = a;
				a = b;
				b = s;
				lengtha = a.length();
				lengthb = b.length();
			}
			
			char[] stra = a.toCharArray();
			char[] strb = b.toCharArray();
			
			resultStr = new char[lengtha + 1];
			int pre = 0;
			int i;
			for (i = 0; i < lengthb; i++)
			{
				int tmp = Integer.parseInt(stra[i]+"") + Integer.parseInt(strb[i]+"") + pre;
				pre = tmp >> 1;
				resultStr[i] = (tmp & 0x1) == 1 ? '1' : '0';
			}
			for (; i < lengtha; i++)
			{
				int tmp = Integer.parseInt(stra[i]+"") + pre;
				pre = tmp >> 1;
				resultStr[i] = (tmp & 0x1) == 1 ? '1' : '0';
			}
			if (pre == 1)
			{
				resultStr[i] = '1';
			}
		}
		String s = String.valueOf(resultStr);
		return StringUtil.reverse(s.trim());
	}
}
