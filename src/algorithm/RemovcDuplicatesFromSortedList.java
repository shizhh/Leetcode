package algorithm;

import bean.ListNode;

public class RemovcDuplicatesFromSortedList {

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode p = head.next;
        while (p != null && p.next != null) {
            if (head.val == p.val) {
                head.next = p.next;
                p = p.next;
            }else {
                head = head.next;
                p = p.next;
            }
        }
        if (head.val == p.val)
        {
            head.next = null;
        }
        return newHead.next;
	}
	
}
