package algorithm;

import java.util.Stack;

/**
 * Reverse Polish Notation 逆波兰表达式
 */
public class RPN
{

	public static void main(String[] args)
	{
		String str = "9+(3-1)*3+10/2";
		System.out.println(reverse(str));
		//System.out.println(isDigit('9'));
	}

	public static String reverse(String str)
	{
		int strLen = str.length();
		char[] strCharArray = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		char topchar = '@';
		for (int i = 0; i < strLen; i++)
		{
			char c = strCharArray[i];
			if (isDigit(c))
				sb.append(c);
			else if (isLeftBracket(c))
				stack.push(c);
			else if (isRightBracket(c))	
			{
				while ( (topchar = stack.pop()) != partner(c))
				{
					sb.append(topchar);
				}
			}
			else if (isOperator(c))
			{
				if (stack.empty())
					stack.push(c);
				else if (!stack.isEmpty() && precedence(c) > precedence(stack.peek()))
				{
					stack.push(c);
				}
				else
				{
					//topchar = stack.peek();
					//sb.append(topchar);
					while (!stack.isEmpty() && precedence(c) <= precedence(topchar = stack.peek()))
					{
						sb.append(topchar);
						stack.pop();
					}
					stack.push(c);
				}
			}
				
		}
		while (!stack.isEmpty())
			sb.append(stack.pop());
		return sb.toString();
	}

	private static int precedence(char sign)
	{
		switch (sign)
		{
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
		case '%':
			return 3;
		default:
			return 0;
		}
	}
	
	private static boolean isLeftBracket(char c)
	{
		if (c == '(' || c == '[' || c == '{')
			return true;
		return false;
	}
	
	private static boolean isRightBracket(char c)
	{
		if (c == ')' || c == ']' || c == '}')
			return true;
		return false;
	}
	
	private static boolean isDigit(char c)
	{
		if (c <= '9' && c >= '0')
			return true;
		return false;
	}

	private static boolean isOperator(char c)
	{
		if (precedence(c) > 0)
			return true;
		return false;
	}
	
	private static char partner(char c)
	{
		if (c == ')')
			return '(';
		if (c == ']')
			return '[';
		if (c == '}')
			return '{';
		return '@';
	}
}
