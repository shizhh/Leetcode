package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FractiontoRecurringDecimal
{
	public String fractionToDecimal(int numerator, int denominator)
	{
		StringBuilder sb = new StringBuilder();
		long q = (long)numerator / denominator;
		long r = Math.abs((long)numerator % denominator);
		
		if ( r != 0)
		{
		    if (q==0 && ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)))
		        sb.append("-");
			sb.append(q);
			sb.append(".");
			Map<Long, Integer> map = new HashMap<>();
			fraction2Decimal(r * 10, Math.abs((long)denominator), 0, map, sb);
		}
		else
		{
			sb.append(q);
		}
		return sb.toString();
	}
	
	public void fraction2Decimal(long numerator, long denominator, int index, Map<Long, Integer> map, StringBuilder sb)
	{
		if (numerator == 0)
		{
			return;
		}
		
		if (map.containsKey(numerator))
		{
			sb.append(")");
			int width = map.size() - map.get(numerator);
			sb.insert(sb.length()-width-1, "(");
			return;
		}
		else
		{
			map.put(numerator, index);
			sb.append(String.valueOf(numerator / denominator));
			numerator = numerator % denominator;
			numerator = 10 * numerator;
			fraction2Decimal(numerator, denominator, index+1, map, sb);
		}
	}
	public static void main(String[] args)
	{
//		int a = -1;
//		int b = Integer.MAX_VALUE-1;
		System.out.println("input 2 numbers:");
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		FractiontoRecurringDecimal main = new FractiontoRecurringDecimal();
		System.out.println(main.fractionToDecimal(a, b));
	}
}
