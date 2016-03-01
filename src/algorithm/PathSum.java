package algorithm;

import bean.TreeNode;

public class PathSum
{
	public boolean hasPathSum(TreeNode root, int sum)
	{
		if (root == null)
			return false;
		
		return helper(root, 0, sum);
	}
	
	public boolean helper(TreeNode root, int curSum, int sum)
	{
		if (root == null)
			return curSum == sum;
		if (root.left == null && root.right == null)
			return curSum + root.val == sum;
		boolean flag = false;
		if (root.left != null)
			flag = helper(root.left, curSum+root.val, sum);
		if (!flag && root.right != null)
			flag = helper(root.right, curSum+root.val, sum);
		return flag;
	}
	
	public static void main(String[] args)
	{
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(11);
		TreeNode t5 = new TreeNode(13);
		TreeNode t6 = new TreeNode(4);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(2);
		TreeNode t9 = new TreeNode(1);
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t4.left = t7;
		t4.right = t8;
		t3.left = t5;
		t3.right = t6;
		t6.left = t9;
		
		PathSum main = new PathSum();
		System.out.println(main.hasPathSum(t1, 17));
		
	}
}
