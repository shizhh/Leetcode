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

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;

		ConvertSortedListtoBinarySearchTree main = new ConvertSortedListtoBinarySearchTree();
		main.sortedListToBST(l1);
	}
}
