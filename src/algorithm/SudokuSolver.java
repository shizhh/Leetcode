package algorithm;

/**
 * 回溯法
 * */
public class SudokuSolver {

	public static void main(String[] args) {
		
		char[][] board = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		SudokuSolver main = new SudokuSolver();
		main.solveSudoku(board);
		
		main.print(board);
	}
	/**
	 * 用数组存储数独的状态，每一位数存储一行状态，共9行
	 * */
	public void solveSudoku(char[][] board) {
		solver(board);
    }
	
	public boolean solver(char[][] board){
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				if(board[i][j] == '.'){
					for (int k = 1; k <= 9; k++){
						board[i][j] = (char) ('0' + k);
						if(isValid(board, i, j) && solver(board)){
							return true;
						}
						board[i][j] = '.';
					}
					return false;
				}
			}
		}
		return true;
	}
	
	public void init(char[][] board,int[] row,int[] line, int[] rid) {
		for(int i = 0; i<9; i++){
			for(int j=0; j<9; j++){
				char ch = board[i][j];	//按行读
				char ch2 = board[j][i];	//按列读
				if(ch!='.'){
					row[i] += Integer.valueOf(String.valueOf(ch));
				}
				if(ch2!='.'){
					line[j] += Integer.valueOf(String.valueOf(ch));
				}
			}
		}
		
	}
	
	public boolean isValid(char[][] board, int x, int y) {
		for (int i = 0; i<9; i++){
			if(board[x][y] == board[x][i] && y != i)
				return false;
		}
		for (int j = 0; j<9; j++){
			if(board[x][y] == board[j][y] && x != j)
				return false;
		}
		
		for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++)
			for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++){
				if(board[x][y] == board[i][j] && i != x && j != y)
					return false;
			}
		return true;
	}
	
	public void print(char[][] board){
		for (int i = 0; i < 9; i++) {
			for (int j=0; j<9; j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
