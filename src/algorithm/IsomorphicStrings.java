package algorithm;


public class IsomorphicStrings
{
	public boolean isIsomorphic(String s, String t)
    {
        char[] mapST = new char[256];
        char[] mapTS = new char[256];
        int lenS = s.length();
        int lenT = t.length();
        if (lenS != lenT)
            return false;
        int i = 0;
        while (i < lenS)
        {
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            
            if (mapST[chs] != mapTS[cht] )
            	return false;
            mapST[chs] = (char)(i+1);
            mapTS[cht] = (char)(i+1);
            i++;
        }
        return true;
    }
	
	public static void main(String[] args)
	{
		String s = "ab";
		String t = "aa";
		IsomorphicStrings main = new IsomorphicStrings();
		System.out.println(main.isIsomorphic(s, t));
	}
}
