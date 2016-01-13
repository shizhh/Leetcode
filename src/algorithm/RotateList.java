package algorithm;

import bean.ListNode;

public class RotateList {
	
	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return null;
		if (head.next == null) {
			return head;
		}
		int n = lenght(head);
		k = k % n;
		if (k == 0)
			return head;
		ListNode h = head;
		ListNode node1 = head;
		ListNode node2 = head;
		while (n > 1) {
			if (n-k > 0) {
				node1 = head;
				head = head.next;
				node2 = head;
			}
			else {
				head = head.next;
			}
			n--;
		}
		node1.next = null;
		head.next = h;
		return node2;
	}
	
	private static int lenght(ListNode head) {
		int count = 0;
		ListNode n = head;
		while (n.next != null) {
			count++;
			n = n.next;
		}
		return count+1;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;
		int le = lenght(l1);
		System.out.println(le);
		
		ListNode h = rotateRight(l1, 0);
		while (h != null) {
			System.out.print(h);
			h = h.next;
		}
	}
}
