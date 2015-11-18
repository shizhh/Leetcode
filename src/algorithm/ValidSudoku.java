/**
 * 
 */
package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhenhui
 *
 */
public class ValidSudoku {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	public boolean isValidSudoku(char[][] board) {
		int m = board.length;
		int n = board[0].length;
		if (m!=n)
			return false;
		return isValidRow(board) && isValidLine(board) && isValidSquare(board);
	}
	public boolean isValidRow(char[][] board) {
		int m = board.length;
		int n = board[0].length;
		for (int i=0; i<m; ++i) {
			Map<Character, Integer> map = new HashMap<>();
			for (int j=0; j<n; ++j) {
				char ch = board[i][j];
				if (ch != '.'){
					if (!map.containsKey(ch))
						map.put(ch, 1);
					else return false;
				}
			}
		}
		return true;
	}
	public boolean isValidLine(char[][] board) {
		int m = board.length;
		int n = board[0].length;
		for (int i=0; i<m; ++i) {
			Map<Character, Integer> map = new HashMap<>();
			for (int j=0; j<n; ++j) {
				char ch = board[j][i];
				if (ch != '.'){
					if (!map.containsKey(ch))
						map.put(ch, 1);
					else return false;
				}
			}
		}
		return true;
	}
	public boolean isValidSquare(char[][] board) {
		int m = board.length;
		int n = board[0].length;
		for (int i=1; i<m; i+=3){
			for (int j=1; j<n; j+=3){
				Map<Character, Integer> map = new HashMap<>();
				for (int p=i-1; p<=i+1;++p){
					for (int q=j-1; q<=j+1; ++q){
						char ch = board[p][q];
						if (ch != '.'){
							if (!map.containsKey(ch))
								map.put(ch, 1);
							else return false;
						}
					}
				}
			}
		}
		return true;
	}
	
}
