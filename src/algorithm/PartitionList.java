package algorithm;

import bean.ListNode;

public class PartitionList {

	public static ListNode partition(ListNode head, int x) {
		ListNode dummy1 = new ListNode(-1);
		ListNode dummy2 = new ListNode(-1);
		ListNode cur1 = dummy1, cur2 = dummy2;
		while (head != null) {
			if (head.val < x) {
				cur1.next = head;
				cur1 = head;
			}
			else {
				cur2.next = head;
				cur2 = head;
			}
			head = head.next;
		}
		cur2.next = null;
		cur1.next = dummy2.next;
		return dummy1.next;
	}
	
	public static void main(String[] args) {
		
	}
}
