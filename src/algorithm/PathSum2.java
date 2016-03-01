package algorithm;

import java.util.ArrayList;
import java.util.List;

import bean.TreeNode;

public class PathSum2
{
	public List<List<Integer>> pathSum(TreeNode root, int sum) 
	{
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
        	return res;
        List<Integer> list = new ArrayList<>();
        helper(root, sum, 0, list, res);
        return res;
    }
	
	private void helper(TreeNode root, int sum, int curSum, List<Integer> list, List<List<Integer>> res)
	{
		if (root == null)
			return;
		if (root.left == null && root.right == null)
		{
			if (curSum + root.val == sum)
			{
				list.add(root.val);
				res.add(new ArrayList<>(list));
				list.remove(list.size()-1);
				return;
			}
		}
		if (root.left != null)
		{
			list.add(root.val);
			helper(root.left, sum, curSum+root.val, list, res);
			list.remove(list.size()-1);
		}
		if (root.right != null)
		{
			list.add(root.val);
			helper(root.right, sum, curSum+root.val, list, res);
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String[] args)
	{
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(11);
		TreeNode t5 = new TreeNode(9);
		TreeNode t6 = new TreeNode(4);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(2);
		TreeNode t9 = new TreeNode(1);
		TreeNode t10 = new TreeNode(5);
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t4.left = t7;
		t4.right = t8;
		t3.left = t5;
		t3.right = t6;
		t6.left = t10;
		t6.right = t9;
		
		PathSum2 main = new PathSum2();
		System.out.println(main.pathSum(t1, 22));
		
	}
}
