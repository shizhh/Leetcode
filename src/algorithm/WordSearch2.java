package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import algorithm.Trie;

public class WordSearch2
{

	public List<String> findWords(char[][] board, String[] words)
	{
		Set<String> res = new HashSet<>();
		Trie trie = new Trie();
		for (String word : words)
			trie.insert(word);
		
		boolean[][] visited = new boolean[board.length][board[0].length];
		
		for ( int i = 0; i < board.length; i++) {
			for ( int j = 0 ; j < board[0].length; j++) {
				dfs(board, visited, "", i, j, trie, res);
			}
		}
		
		return new ArrayList<>(res);
	}
	
	public void dfs(char[][] board, boolean[][] visited, String tword, int i, int j, Trie trie, Set<String> res)
	{
		if (i > board.length-1 || i < 0 || j < 0 || j > board[0].length-1)
			return;
		if (visited[i][j])
			return;
		
		tword = tword + board[i][j];
		
		if (!trie.startsWith(tword))
			return;
		
		if (trie.search(tword))
			res.add(tword);
		
		visited[i][j] = true;
		dfs(board, visited, tword, i-1, j, trie, res);
		dfs(board, visited, tword, i+1, j, trie, res);
		dfs(board, visited, tword, i, j-1, trie, res);
		dfs(board, visited, tword, i, j+1, trie, res);
		visited[i][j] = false;
	}
}
