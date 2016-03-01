package algorithm;

import java.util.LinkedList;
import java.util.Queue;

import bean.TreeLinkNode;

public class PopulatingNextRightPointersinEachNode
{
	public void connect(TreeLinkNode root)
	{
		if (root == null)
			return;
		
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.add(root);
		TreeLinkNode node = null;
		while (!queue.isEmpty())
		{
			int size = queue.size();
			for (int i = 0; i < size; i++)
			{
				node = queue.poll();
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
				
				node.next = queue.peek();
			}
			node.next = null;
		}
	}
}
