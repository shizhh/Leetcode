package algorithm;

import bean.ListNode;

public class RemoveDuplicatesFromSortedList2 {
	
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newhead = new ListNode(-1);
		newhead.next = head;
		ListNode p = head;
		ListNode pre = newhead;
		
		while (p != null) {
			while (p.next != null && p.val == p.next.val) {
				p = p.next;
			}
			if (pre.next == p) {
				pre = pre.next;
			}
			else {
				pre.next = p.next;
			}
			p = p.next;
		}
		return newhead.next;
	}
	
	public static void main(String[] args) {
		
	}
}
