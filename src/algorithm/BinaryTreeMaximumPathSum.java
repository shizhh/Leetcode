package algorithm;

import bean.TreeNode;

public class BinaryTreeMaximumPathSum
{
	int maxValue = 0;
	
	public int maxPathSum(TreeNode root)
	{
		maxValue = Integer.MIN_VALUE;
		helper(root);
		return maxValue;
	}
	
	public int helper(TreeNode root)
	{
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.val;
		
		int left=0, right=0;
		if (root.left != null)
			left = helper(root.left);
		if (root.right != null)
			right = helper(root.right);
		maxValue = Math.max(maxValue, left + right + root.val);
		return left > right ? left + root.val : right + root.val;
	}
	
	// ------------------------------------
	// 引入局部变量
	// ------------------------------------
	public int maxPathSum2(TreeNode root)
	{
		int[] max = {Integer.MIN_VALUE};
		helper(root, max);
		return max[0];
	}
	
	public int helper(TreeNode root, int[] max)
	{
		if (root == null)
			return 0;
		
		int left=0, right=0;
		if (root.left != null)
			left = Math.max(helper(root.left, max), 0);
		if (root.right != null)
			right = Math.max(helper(root.right, max), 0);
		max[0] = Math.max(max[0], left + right + root.val);
		return left > right ? left + root.val : right + root.val;
	}
	
	public static void main(String[] args)
	{
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(-1);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
//		t1.left = t2;
//		t1.right = t3;
//		t2.left = t4;
//		t2.right = t5;
//		t3.left = t6;
//		t3.right = t7;
		
		BinaryTreeMaximumPathSum main = new BinaryTreeMaximumPathSum();
		System.out.println(main.maxPathSum2(t1));
		
	}
}
