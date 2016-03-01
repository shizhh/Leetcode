package algorithm;

import bean.ListNode;

public class InsertionSortList
{
	public ListNode insertionSortList(ListNode head)
	{
		if (head == null)
			return head;
		
		
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode p = head;
		
		while (p.next != null)
		{
			ListNode t = p.next;
			if (p.val < t.val)
			{
				p = p.next;
				continue;
			}
			
			p.next = t.next;
			ListNode pre = dummy;
			ListNode next = dummy.next;
			while (next.val < t.val)
			{
				pre = pre.next;
				next = next.next;
			}
			pre.next = t;
			t.next = next;
			
			//p = p.next;
		}
		
		return dummy.next;
	}
}
