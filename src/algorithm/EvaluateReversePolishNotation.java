package algorithm;

import java.util.Stack;

public class EvaluateReversePolishNotation
{
	public int evaRPN(String[] tokens)
	{
		if (tokens == null)
			return 0;
		
		int len = tokens.length;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < len; i++)
		{
			String s = tokens[i];
			if (s != "+" || s != "-" || s != "*" || s != "/")
			{
				stack.push(Integer.valueOf(s));
			}
			else 
			{
				int a = stack.pop();
				int b = stack.pop();
				int c = 0;
				switch (s)
				{
				case "+":
					c = b + a;
					break;
				case "-":
					c = b - a;
					break;
				case "*":
					c = b * a;
					break;
				case "/":
					c = b / a;
					break;
				default:
					break;
				}
				stack.push(c);
			}
		}
		return stack.pop();
	}
	
	public static void main(String[] args)
	{
		String s = "+";
		System.out.println(s.equals("+"));
	}
}
