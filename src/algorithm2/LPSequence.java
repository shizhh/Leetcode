package algorithm;

/**
 * Created by szh on 16/4/4.
 * 最长回文子序列LPS
 */
public class LPSequence
{
    public int lps_recursive(String s, int left, int right)
    {
        if (left == right)  return 1;   // only one character
        if (left > right)   return 0;   // s[left ... right] is not a substring
        if (s.charAt(left) == s.charAt(right))  return 2+lps_recursive(s, left+1, right-1);

        return Math.max(lps_recursive(s, left+1, right), lps_recursive(s, left, right-1));
    }

    public int lps_dp(String s)
    {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i)    dp[i][i] = 1;

        for (int k = 2; k <= s.length(); ++k)   // 枚举子序列长度
        {
            int tmp = 0;
            for (int i = 0; i+k <= s.length(); ++i)  // 枚举子序列起始位置,为s[i, i+k]
            {
                if (s.charAt(i) == s.charAt(i+k-1))   tmp = 2 + dp[i+1][i+k-2];
                else { tmp = Math.max(dp[i+1][i+k-1], dp[i][i+k-2]); }
                dp[i][i+k-1] = tmp;
            }
        }
        return dp[0][s.length()-1];
    }

    public static void main(String [] args)
    {
        String s = "abcdfcba";
        LPSequence lpSequence = new LPSequence();
        System.out.println(lpSequence.lps_recursive(s, 0, s.length()-1));
        System.out.println(lpSequence.lps_dp(s));
    }
}
