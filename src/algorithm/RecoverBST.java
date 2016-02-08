package algorithm;

import java.util.ArrayList;
import java.util.List;

import bean.TreeNode;

public class RecoverBST {

	TreeNode mistake1, mistake2;
	TreeNode pre = null;
	
	public void recoverTree(TreeNode root) {
		recursive_traversal(root);
		if (mistake1 != null && mistake2 != null){
			int tmp = mistake1.val;
			mistake1.val = mistake2.val;
			mistake2.val = tmp;
		}
	}

	public void recursive_traversal(TreeNode root){
		if (root == null){
			return;
		}
		// 遍历左子树
		if (root.left != null){
			recursive_traversal(root.left);
		}
		
		// 出现逆序情况
		if (pre != null && pre.val > root.val){
			if (mistake1 == null){
				mistake1 = pre;
				mistake2 = root;
			}else {
				mistake2 = root;
			}
		}
		
		pre = root;
		// 遍历右子树
		if (root.right != null){
			recursive_traversal(root.right);
		}
	}
	
	
	
	// -----------------------------------------
	// 中序遍历树，递归
	// -----------------------------------------
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root != null) {
			inorder(root, res);
		}
		return res;
	}

	private void inorder(TreeNode p, List<Integer> res) {
		if (p != null) {
			inorder(p.left, res);
			res.add(p.val);
			inorder(p.right, res);
		}
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

		RecoverBST main = new RecoverBST();
		List<Integer> tree = main.inorderTraversal(t1);
		System.out.println(tree);
		main.recoverTree(t1);
		tree = main.inorderTraversal(t1);
		System.out.println(tree);
	}

}
