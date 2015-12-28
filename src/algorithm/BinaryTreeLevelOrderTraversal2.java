package algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversal2 {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		
		return null;
	}

	public static void translevel(List<List<Integer>> res, List<Integer> tmp, TreeNode node) {
		
	}
	
	
	public static void main(String[] args) {
		
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void BFS() {
		Queue<TreeNode> queue = new LinkedList<>();
		
	}
	
	public static void DFS(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			
		}
	}
}
