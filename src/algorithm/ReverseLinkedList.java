package algorithm;

import bean.ListNode;

public class ReverseLinkedList
{
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
