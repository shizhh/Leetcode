package algorithm;

import bean.TreeNode;

public class SumRoottoLeafNumbers
{
	public int sumNumbers(TreeNode root)
	{
		return sumNumbers(root, 0);
	}
	
	public int sumNumbers(TreeNode root, int x) {
        if (root == null)
        	return 0;
        if (root.left == null && root.right == null)
        	return root.val + x * 10;
        int left=0, right=0;
        if (root.left != null)
        	left = sumNumbers(root.left, root.val + x * 10);
        if (root.right != null)
        	right = sumNumbers(root.right, root.val + x * 10);
		return left+right;
    }
	
	public static void main(String[] args)
	{
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		
		SumRoottoLeafNumbers main = new SumRoottoLeafNumbers();
		System.out.println(main.sumNumbers(null));
	}
}
