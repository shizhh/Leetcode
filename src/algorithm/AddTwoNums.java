package algorithm;

import bean.ListNode;

/**
 * 
 * 
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list. Input: (2 -> 4 ->
 * 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * */
public class AddTwoNums {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode p = result;
		int carry = 0;
		while (l1 != null || l2 != null) {
			if (l1 != null) {
				carry += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				carry += l2.val;
				l2 = l2.next;
			}
			p.next = new ListNode(carry % 10);
			p = p.next;
			carry /= 10;
		}
		if (carry == 1) {
			p.next = new ListNode(1);
		}
		return result.next;
	}

	// This method is just here to test the function addTwoNumbers
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode result = new AddTwoNums().addTwoNumbers(l1, l2);

		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		System.out.println();
		
		
	}
}
