package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import bean.TreeNode;

public class BinaryTreeLevelOrderTraversal2 {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null){
			return res;
		}
		// root is not null
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()){
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i=0; i<size; i++){
				TreeNode node = queue.poll();
				list.add(node.val);
				
				if (node.left != null){
					queue.offer(node.left);
				}
				if (node.right != null){
					queue.offer(node.right);
				}
			}
			res.add(0, list);
		}
		return res;
	}	
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t4.right = t5;
		
		BinaryTreeLevelOrderTraversal2 main = new BinaryTreeLevelOrderTraversal2();
		System.out.println(main.levelOrderBottom(t1));
	}
	
}
