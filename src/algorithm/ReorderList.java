package algorithm;

import bean.ListNode;

public class ReorderList
{
	public void reorderList(ListNode head)
	{
		if (head == null)
			return;
		
		ListNode storeHead = head;
		
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast.next != null && fast.next.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode newHead = slow.next;
		slow.next = null;
		newHead = reverseList(newHead);
		
		ListNode next = null;
		ListNode newNext = null;
		while (head != null && newHead != null)
		{
			next = head.next;
			newNext = newHead.next;
			head.next = newHead;
			newHead.next = next;
			head = next;
			newHead = newNext;
		}
		
		head = storeHead;
	}
	public ListNode reverseList(ListNode head)
	{
		if (head == null)
			return head;
		
		ListNode p = head.next;
		head.next = null;
		ListNode p2 = null;
		while (p != null)
		{
			p2 = p.next;
			p.next = head;
			head = p;
			p = p2;
		}
		
		return head;
	}
}
