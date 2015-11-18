/**
 * 
 */
package algorithm;

/**
 * @author zhenhui
 *
 */
public class LengthOfLastWord
{
	public int lengthOfLastWord(String s)
	{
		int length;
		
		if (s.trim().equals("") || s.equals(""))
			length = 0;
		else 
		{
			String[] str = s.trim().split(" ");
			length = str[str.length-1].length();
		}
		return length;
	}
}
