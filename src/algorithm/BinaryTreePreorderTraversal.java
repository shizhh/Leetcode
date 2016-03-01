package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import bean.TreeNode;

public class BinaryTreePreorderTraversal
{
	// ----------------------------
	// 递归
	// ----------------------------
	public List<Integer> preorderTraversal(TreeNode root)
	{
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		
		res.add(root.val);
		res.addAll(preorderTraversal(root.left));
		res.addAll(preorderTraversal(root.right));
		
		return res;
	}
	
	// ----------------------------
	// 非递归
	// ----------------------------
	public List<Integer> preorderTraversal2(TreeNode root)
	{
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		while (!stack.isEmpty() || p != null)
		{
			while (p != null)
			{
				res.add(p.val);
				stack.push(p);
				p = p.left;
			}
			if (!stack.isEmpty())
			{
				p = stack.pop();
				p = p.right;
			}
		}
		
		return res;
	}
	
	
}
