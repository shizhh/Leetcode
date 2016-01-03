package algorithm;

public class EditDistance {

	public static int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
		int[][] editDst = new int[len1+1][len2+1];
		for (int i = 0; i <= len1; i++) {
			editDst[i][0] = i;
		}
		for (int i = 0; i <= len2; i++) {
			editDst[0][i] = i;
		}
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (word1.charAt(i-1) == word2.charAt(j-1)) {
					editDst[i][j] = editDst[i-1][j-1];
				}else {
					editDst[i][j] = min3(editDst[i-1][j]+1, editDst[i][j-1]+1, editDst[i-1][j-1]+1);
				}
			}
		}
		return editDst[len1][len2];
	}
	
	public static int min3(int a, int b, int c) {
		int min = a;
		if (min > b)
			min = b;
		if (min > c)
			min = c;
		return min;
	}
	public static void main(String[] args) {
		String word1 = "abcd";
		String word2 = "acbd";
		int dis = minDistance(word1, word2);
		System.out.println(dis);
	}

}
