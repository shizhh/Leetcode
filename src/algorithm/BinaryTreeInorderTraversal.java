package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import bean.TreeNode;

public class BinaryTreeInorderTraversal {

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
		if (p != null){
			inorder(p.left, res);
			res.add(p.val);
			inorder(p.right, res);
		}
	}

	// -----------------------------------------
	// 中序遍历树，迭代
	// -----------------------------------------
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		while (!stack.isEmpty() || p != null){
			while (p != null){	// 左子树全部入栈
				stack.push(p);
				p = p.left;
			}
			if (!stack.isEmpty()){
				p = stack.pop();
				res.add(p.val);
				p = p.right;
			}
		}
		return res;
	}
	
	//==========================================================================
	
	// -----------------------------------------
	// 先序遍历树，递归
	// -----------------------------------------
	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		else{
			preorder(root, res);
		}
		return res;
	}
	
	private void preorder(TreeNode p, List<Integer> res){
		if (p != null){
			res.add(p.val);
			preorder(p.left, res);
			preorder(p.right, res);
		}
	}
	
	// -----------------------------------------
	// 先序遍历树，迭代
	// -----------------------------------------
	public List<Integer> preorderTraversal2(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		while(!stack.isEmpty() || p != null){
			while(p != null){	// 左子树全部入栈，压入前访问节点
				res.add(p.val);
				stack.push(p);
				p = p.left;
			}
			if(!stack.isEmpty()){
				p = stack.pop();
				p = p.right;
			}
		}
		return res;
	}
	
	//==========================================================================
	
	
	// -----------------------------------------
	// 后序遍历树，递归
	// -----------------------------------------
	public List<Integer> postorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if (root == null){
			return res;
		}
		else{
			postorder(root, res);
		}
		return res;
	}
	
	private void postorder(TreeNode p, List<Integer> res){
		if (p != null){
			postorder(p.left, res);
			postorder(p.right, res);
			res.add(p.val);
		}
	}
	
	// -----------------------------------------
	// 后序遍历树，迭代
	// -----------------------------------------
	public List<Integer> postorderTraversal2(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if (root == null){
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		TreeNode visited = p;
		while(!stack.isEmpty() || p != null){
			while (p != null){	// 左子树全部入栈
				stack.push(p);
				p = p.left;
			}
			if (!stack.isEmpty()){
				TreeNode t = stack.peek().right;
				if (t == null || t == visited){
					p = stack.pop();
					res.add(p.val);
					visited = p;
					p = null;
				}else{
					p = t;
				}
			}
		}
		return res;
	}
	
	//==========================================================================
	
	
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

		BinaryTreeInorderTraversal main = new BinaryTreeInorderTraversal();
//		List<Integer> res1 = main.inorderTraversal(t1);
//		List<Integer> res2 = main.preorderTraversal(t1);
		List<Integer> res3 = main.postorderTraversal(t1);
		
//		List<Integer> res11 = main.inorderTraversal2(t1);
//		List<Integer> res22 = main.preorderTraversal2(t1);
		List<Integer> res33 = main.postorderTraversal2(t1);
		System.out.println(res3);
		System.out.println(res33);
	}
}
