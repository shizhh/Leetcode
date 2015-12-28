package algorithm;

public class MaximumDepth {
	
	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		
	}
	
	
	public static void main(String[] args) {
		
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}


