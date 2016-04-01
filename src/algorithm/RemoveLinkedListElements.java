package algorithm;

import bean.ListNode;

public class RemoveLinkedListElements
{

	public ListNode removeElements(ListNode head, int val) 
    {
        ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode p = head;
		ListNode pre = dummy;
		while (p != null)
		{
			if (p.val == val)
			{
			    pre.next = p.next;
			}
			else
			{
		        pre = p;
			}
			    p = p.next;
		}
		return dummy.next;
    }
}
