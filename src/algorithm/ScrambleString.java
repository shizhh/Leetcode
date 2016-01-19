package algorithm;

public class ScrambleString {

	public static boolean isScramble(String s1, String s2){
		int n1 = s1.length();
		int n2 = s2.length();
		if(n1 != n2)
			return false;
		if(n1 == 0)
			return true;
		boolean[][][] res = new boolean[n1][n2][n1+1];
		for(int i = 0; i<n1; i++){
			for(int j=0;j<n2;j++){
				res[i][j][1] = (s1.charAt(i)==s2.charAt(j));
			}
		}
		for(int len=2; len <= n1; len++){
			for(int i=0; i<= n1-len; i++){
				for(int j=0; j<=n2-len; j++){
					for(int k = 1; k<len; k++){
						res[i][j][len] |= res[i][j][k]&res[i+k][j+k][len-k] || res[i][j+len-k][k]&res[i+k][j][len-k];
					}
				}
			}
		}
		return res[0][0][n1];
	}
	public static void main(String[] args){
		String s1 = "great";
		String s2 = "rgtae";
		System.out.println(isScramble(s1, s2));
	}
}
