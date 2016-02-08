package algorithm;

import bean.TreeNode;

public class ValidateBinarySearchTree {
	
	public boolean isValidBST(TreeNode root){
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean isValidBST(TreeNode root, int minVal, int maxVal){
		if (root == null){
			return true;
		}
		if (root.val <= minVal || root.val >= maxVal) return false;
		return isValidBST(root.left, minVal, root.val) & isValidBST(root.right, root.val, maxVal);
	}
	
	public static void main(String[] args){
		TreeNode t1 = new TreeNode(10);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(15);
		TreeNode t4 = new TreeNode(6);
		TreeNode t5 = new TreeNode(20);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		ValidateBinarySearchTree main = new ValidateBinarySearchTree();
		System.out.println(main.isValidBST(t1));
	}
}
