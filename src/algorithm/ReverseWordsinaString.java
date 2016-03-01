package algorithm;


public class ReverseWordsinaString
{
    public String reverseWords(String s)
    {
        if (s == null)
        	return null;
        
        s = s.trim().replaceAll("\\s+", " ");
        int len = s.length();
        
        String str = "";
        int i = len - 1;
        while (i >= 0)
        {
        	int count = 0;
        	while (i >= 0 && s.charAt(i) != ' ')
        	{
        		count++;
        		i--;
        	}
        	str += s.substring(i+1, i+1+count) + " ";
        	i--;
        }
        
    	return str.length() > 0 ? str.substring(0, str.length()-1) : str;
    }
    
    public static void main(String[] args)
    {
    	String s = "      ";
    	ReverseWordsinaString main = new ReverseWordsinaString();
    	//s = s.trim().replaceAll("\\s+", " ");
    	System.out.println(main.reverseWords(s));
    }
    
}
