package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import bean.TreeNode;

public class BinaryTreeLevelOrderTraversal
{
	
	public List<List<Integer>> levelOrder(TreeNode root)
	{
		List<List<Integer>> res = new ArrayList<>();
		if (root == null){
			return res;
		}
		// root != null
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()){
			List<Integer> list = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++){
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left != null){
					queue.add(node.left);
				}
				if (node.right != null){
					queue.add(node.right);
				}
			}
			res.add(list);
		}
		return res;
	}
	
	public static void main(String[] args){
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t4.right = t5;
		
		BinaryTreeLevelOrderTraversal main = new BinaryTreeLevelOrderTraversal();
		System.out.println(main.levelOrder(t1));
	}
}
