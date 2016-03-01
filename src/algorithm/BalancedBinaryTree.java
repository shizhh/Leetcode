package algorithm;

import bean.TreeNode;

public class BalancedBinaryTree
{
	// -----------------------------------
	// 求每一个子树的深度，然后判断
	// -----------------------------------
	public boolean isBalanced(TreeNode root)
	{
		if (root == null)
			return true;
		int differ = Math.abs(depth(root.left) - depth(root.right));
		if (differ > 1)
			return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);
	}
	
	private int depth(TreeNode p)
	{
		if (p == null)
			return 0;
		return Math.max(depth(p.left), depth(p.right)) + 1;
	}
	
	// -----------------------------------
	// 递归地判断子树是否平衡
	// -----------------------------------
	public boolean isBalanced2(TreeNode root)
	{
		return dfsdepth(root) != -1;
	}
	
	private int dfsdepth(TreeNode p)
	{
		if (p == null)
			return 0;
		int left = dfsdepth(p.left);
		if (left == -1)
			return -1;
		int right = dfsdepth(p.right);
		if (right == -1)
			return -1;
		if (Math.abs(left-right)>1)
			return -1;
		return Math.max(left, right)+1;
	}
	
	public static void main(String[] args)
	{
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		
		BalancedBinaryTree main = new BalancedBinaryTree();
		System.out.println(main.isBalanced(t1));
		System.out.println(main.isBalanced2(t1));
	}
}
