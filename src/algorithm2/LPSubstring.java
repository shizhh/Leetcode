package algorithm;

/**
 * Created by szh on 16/4/4.
 */
public class LPSubstring
{
    public int lps_recursive(String s, int left, int right)
    {
        return 0;
    }


    public String lps_dp(String s)
    {
        int [][] dp = new int[s.length()][s.length()];
        int start = 0; int len = 1;
        for (int i = 0; i < s.length(); ++i)
        {
            dp[i][i] = 1;
            if (i+1 < s.length() && s.charAt(i) == s.charAt(i+1))   { dp[i][i+1] = 1; start = i; len = 2; }
        }
        for (int k = 3; k <= s.length(); ++k)
        {
            for (int i = 0; i <= s.length()-k; ++i)
            {
                if (s.charAt(i) == s.charAt(i+k-1))   dp[i][i+k-1] = dp[i+1][i+k-2];
                if (dp[i][i+k-1] == 1 && len < k)   { start = i; len = k; }
            }
        }
        System.out.println(start);
        System.out.println(len);
        return s.substring(start, start+len);
    }

    public static void main(String [] args)
    {
        String s = "abcdfcba";
        LPSubstring lpSubstring = new LPSubstring();
        System.out.println(lpSubstring.lps_dp(s));
    }
}
