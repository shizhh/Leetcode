package algorithm;


public class CompareVersionNumbers
{
	public int compareVersion(String version1, String version2)
	{
		String[] versionArray1 = version1.split("\\.");
		String[] versionArray2 = version2.split("\\.");
		
		int len = Math.min(versionArray1.length, versionArray2.length);
		int i = 0;
		for (i = 0; i < len; i++)
		{
			int flag = compareTO(versionArray1[i], versionArray2[i]);
			if (flag != 0)
				return flag;
			else
			{
				// do nothing
			}
		}
		
		if (versionArray1.length > versionArray2.length)
		{
		    while (i < versionArray1.length)
		    {
		        int t = compareTO(versionArray1[i], "");
		        if (t != 0)
		            return t;
		        i++;
		    }
			return 0;
		}
		else if (versionArray1.length < versionArray2.length)
		{
			while (i < versionArray2.length)
		    {
		        int t = compareTO("", versionArray2[i]);
		        if (t != 0)
		            return t;
		        i++;
		    }
			return 0;
		}
		else	return 0;
	}
	
	public int compareTO(String s1, String s2)
	{
		int i = 0, j = 0;
		while (i < s1.length() && s1.charAt(i) == '0')
			i++;
		while (j < s2.length() && s2.charAt(j) == '0')
			j++;
		while (i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j))
		{
			i++;
			j++;
		}
		if (s1.length()-i > s2.length()-j)
		    return 1;
		else if (s1.length()-i < s2.length()-j)
		    return -1;
		else
		{
    		if ( i == s1.length() && j == s2.length())
    			return 0;
    		else if (j == s2.length())
    			return 1;
    		else return -1;
		}
	}
	
	public static void main(String[] args)
	{
		String version1 = "1.0";
		String version2 = "1";
		CompareVersionNumbers main = new CompareVersionNumbers();
		System.out.println(main.compareVersion(version1, version2));
	}
	
}
