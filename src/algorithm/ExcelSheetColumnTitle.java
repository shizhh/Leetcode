package algorithm;


public class ExcelSheetColumnTitle
{
	public String convertToTitle(int n)
	{
		
		StringBuilder sb = new StringBuilder();
		
		int q = (n-1) / 26;
		int r = (n-1) % 26;
		
		while (q > 0)
		{
			sb.insert(0, (char)(r+'A'));
			n = q;
			q = (n-1) / 26;
			r = (n-1) % 26;
		}
		
		sb.insert(0, (char)(r+'A'));
		return sb.toString();
		
	}
	
	public static void main(String[] args)
	{
		System.out.println(new ExcelSheetColumnTitle().convertToTitle(207));
	}
	
}
