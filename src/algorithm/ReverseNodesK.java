package algorithm;

import bean.ListNode;

public class ReverseNodesK {
	
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (k <= 1 || head == null || head.next == null) {
			return head;
		}
		
		ListNode preNode = new ListNode(-1);
		preNode.next = head;
		ListNode groupPre = preNode;
		int count = 0;
		while (head != null) {
			count++;
			if (count % k == 0) {
				groupPre = reverse(groupPre, head.next);
				head = groupPre.next;
			}else {
				head = head.next;
			}
		}
		return preNode.next;
	}

	public static ListNode reverse(ListNode pre, ListNode next) {
		ListNode last = pre.next;
		ListNode cur = last.next;
		while (cur != next) {
			last.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = last.next;
		}
		return last;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		
		ListNode node = reverseKGroup(l1, 3);
		
		while (node != null) {
//			System.out.println(l1.val);
//			l1 = l1.next;
			System.out.println(node.val);
			node = node.next;
		}
	}
	
}
