package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import bean.TreeNode;

public class BinaryTreePostorderTraversal
{
	// -----------------------------------------
	// 后序遍历树，递归
	// -----------------------------------------
	public List<Integer> postorderTraversal(TreeNode root)
	{
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		
		res.addAll(postorderTraversal(root.left));
		res.addAll(postorderTraversal(root.right));
		res.add(root.val);
		
		return res;
	}
	
	// -----------------------------------------
	// 后序遍历树，迭代
	// -----------------------------------------
	public List<Integer> postorderTraversal2(TreeNode root)
	{
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		TreeNode visited = p;
		while (!stack.isEmpty() || p != null)
		{
			while (p != null)
			{
				stack.push(p);
				p = p.left;
			}
			if (!stack.isEmpty())
			{
				TreeNode t = stack.peek().right;
				if (t == null || t == visited)
				{
					p = stack.pop();
					res.add(p.val);
					visited = p;
					p = null;
				}
				else
				{
					p = t;
				}
			}
		}
		
		return res;
	}
}
