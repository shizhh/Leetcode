package algorithm;

import bean.TreeNode;

public class MinimumDepthofBinaryTree
{
    public int minDepth(TreeNode root) {
        if (root == null){
        	return 0;
        }
        // root is not null
        if (root.left == null){
        	return 1+minDepth(root.right);
        }
        if (root.right == null){
        	return 1 + minDepth(root.left);
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
    
    public static void main(String[] args){
    	TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		
		MinimumDepthofBinaryTree main = new MinimumDepthofBinaryTree();
		System.out.println(main.minDepth(t1));
    }
}
