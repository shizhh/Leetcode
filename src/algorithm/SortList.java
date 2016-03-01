package algorithm;

import bean.ListNode;

public class SortList
{
	public ListNode sortList(ListNode head)
	{
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(-1);
		
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode newHead = slow.next;
		slow.next = null;
		
		ListNode left = sortList(head);
		ListNode right = sortList(newHead);
		
		ListNode p = dummy;
		while (left != null && right != null)
		{
			if (left.val < right.val)
			{
				p.next = left;
				left = left.next;
			}
			else
			{
				p.next = right;
				right = right.next;
			}
			p = p.next;
		}
		if (left != null)
		{
			p.next = left;
		}
		if (right != null)
		{
			p.next = right;
		}
		
		return dummy.next;
		
	}
	
	public static void main(String[] args)
	{
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(0);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		SortList main = new SortList();
		ListNode head = main.sortList(l1);
		
		while (head != null)
		{
			System.out.print(head);
			head = head.next;
		}
	}
	
	
	
}
