package algorithm;

import java.util.Stack;

import bean.TreeNode;

public class BSTIterator
{
	
	private Stack<TreeNode> stack = null;
	
	public BSTIterator(TreeNode root)
	{
		stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null)
		{
			stack.push(cur);
			cur = cur.left;
		}
	}
	
	/**
	 * @return whether we have a next smallest number
	 */
	public boolean hasNext()
	{
		return !stack.isEmpty();
	}
	
	/**
	 * @return the next smallest number
	 */
	public int next()
	{
		int res = 0;
		TreeNode node = stack.pop();
		res = node.val;
		if (node.right != null)
		{
			node = node.right;
			stack.push(node);
			node = node.left;
			while (node != null)
			{
				stack.push(node);
				node = node.left;
			}
		}
		return res;
	}
}
