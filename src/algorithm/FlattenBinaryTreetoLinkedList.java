package algorithm;

import bean.TreeNode;

public class FlattenBinaryTreetoLinkedList
{
	
	public void flatten(TreeNode root)
	{
		if (root == null)
			return;
		
		helper(root);
	}
	
	public TreeNode helper(TreeNode root)
	{
		if (root == null)
			return null;
		
		if (root.left == null && root.right == null)
			return root;
		
		TreeNode left = root.left;
		TreeNode right = root.right;
		
		root.left = null;
		
		if (left != null)
		{
			root.right = left;
			helper(left).right = right;
		}
		
		if (right != null)
			return helper(root.right);
		else return helper(root.left);
	}
	
	public void flatten2(TreeNode root)
	{
		if (root == null)
			return;
		
		if (root.left != null)
		{
			TreeNode left = root.left;
			TreeNode right = root.right;
			
			root.left = null;
			root.right = left;
			
			TreeNode p = left;
			while (p.right!= null)
			{
				p = p.right;
			}
			
			p.right = right;
		}
		flatten(root.right);
	}
	
}
