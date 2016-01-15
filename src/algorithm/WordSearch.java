package algorithm;

public class WordSearch {

	public static boolean exist(char[][] board, String word) {
		for ( int i = 0; i < board.length; i++) {
			for ( int j = 0 ; j < board[0].length; j++) {
				if (exist(board, "", word, i, j))
					return true;
			}
		}
		return false;
	}
	
	public static boolean exist(char[][] board, String tword, String word, int i, int j) {
		if (tword.equals(word))
			return true;
		if (i > board.length-1 || i < 0 || j < 0 || j > board[0].length-1 || board[i][j] != word.charAt(tword.length()))
			return false;
		char ch = board[i][j];
		board[i][j] = '*';
		boolean result = 	exist(board, tword+ch, word, i+1, j)	// move down
						||	exist(board, tword+ch, word, i-1, j)	// move up
						||	exist(board, tword+ch, word, i, j+1)	// move right
						||	exist(board, tword+ch, word, i, j-1);	// move left
		board[i][j] = ch;
		return result;
	}
	
	public static void main(String[] args) {
		String word = "SEEDC";
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}};
		System.out.println(exist(board, word));
	}
}
