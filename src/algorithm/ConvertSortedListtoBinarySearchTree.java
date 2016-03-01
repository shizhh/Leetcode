package algorithm;

import bean.ListNode;
import bean.TreeNode;

public class ConvertSortedListtoBinarySearchTree
{

	ListNode h;
	
	public TreeNode sortedListToBST(ListNode head)
	{
		if (head == null)
			return null;
		h = head;
        ListNode p = head;
        int count = 0;
        while (p != null)
        {
        	count++;
        	p = p.next;
        }
        
		return helper(0, count-1);
    }
	
	private TreeNode helper(int start, int end)
	{
		if (start > end)
			return null;
		
		int mid = start + (end-start)/2;
		
		TreeNode left = helper(start, mid-1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = helper(mid+1, end);
		root.left = left;
		root.right = right;
		
		return root;
	}
}
