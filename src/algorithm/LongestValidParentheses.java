package algorithm;

public class LongestValidParentheses {

	public static int longestValidParentheses(String s) {
		int length = s.length();
		if (length < 1)
			return 0;
		
		int[] dp = new int[length];		// dp[i] denote the longest length of valid parentheses which is end at i
		dp[0] = 0;
		int max = 0;
		for (int i = 1; i < length; i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i-1) == '(') {
					dp[i] = i-2 > 0 ? dp[i-2] + 2 : 2;
					max = Math.max(max, dp[i]);
				}else {
					if (i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '(') {
						dp[i] = dp[i-1] + 2 + (i-dp[i-1]-2 >=0 ? dp[i-dp[i-1]-2] : 0);
						max = Math.max(dp[i], max);
					}
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		String s = "()()((()))";
		int k = longestValidParentheses(s);
		System.out.println(k);
	}

}
