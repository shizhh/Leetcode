package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import bean.TreeNode;

public class BinaryTreeRightSideView
{
	
	// ---------------------------------
	// 层次遍历
	// ---------------------------------
	public List<Integer> rightSideView(TreeNode root)
	{
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty())
		{
			int size = queue.size();
			for (int i = 1; i <= size; i++)
			{
				TreeNode node = queue.poll();
				if (i == size)
				{
					list.add(node.val);
				}
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
		}
		
		return list;
	}
	
	
	public List<Integer> rightSideView2(TreeNode root)
	{
		List<Integer> result = new ArrayList<>();
		helper(root, 0, result);
		return result;
	}
	
	private void helper(TreeNode cur, int depth, List<Integer> result)
	{
		if (cur == null)
			return;
		
		if (depth == result.size())
			result.add(cur.val);
		
		helper(cur.right, depth+1, result);
		helper(cur.left, depth+1, result);
	}
}
