package algorithm2;

import java.util.ArrayList;
import java.util.List;

public class Test
{
	public void convert(String s, int i, List<String> res)
	{
		if (i >= s.length())
			return;
		
		if (s.charAt(i) == '9' || s.charAt(i) == 'g')
		{				
//			convert(s, i+1, res);
			s = change(s, i);
			res.add(s);
			convert(s, i+1, res);
			s = change(s, i);
			convert(s, i+1, res);
		}
		else
		{
			convert(s, i+1, res);
		}
		
	}
	
	public String change(String s, int i)
	{
		if (s.charAt(i) == '9')
			return s.substring(0,i)+"g"+s.substring(i+1);
		if (s.charAt(i) == 'g')
			return s.substring(0,i)+"9"+s.substring(i+1);
		else return s;
	}
	
	public static void main(String[] args)
	{
		List<String> res  = new ArrayList<>();
		String s = "x99xxx";
		res.add(s);
		new Test().convert(s, 0, res);
		System.out.println(res);
	}
}
