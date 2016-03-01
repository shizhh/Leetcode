package algorithm;

import bean.TreeNode;

public class ConvertSortedArraytoBinarySearchTree
{
	public TreeNode sortedArrayToBST(int[] nums)
	{
		if (nums == null || nums.length < 1)
			return null;
		
		return helper(nums, 0, nums.length-1);
	}
	
	private TreeNode helper(int[] nums, int l, int r)
	{
		if (l > r)
			return null;
		int m = l + (r-l)/2;
		TreeNode root = new TreeNode(nums[m]);
		root.left = helper(nums, l, m-1);
		root.right = helper(nums, m+1, r);
		return root;
	}
	
	public static void main(String[] args)
	{
		
	}
}
