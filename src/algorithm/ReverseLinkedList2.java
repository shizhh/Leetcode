package algorithm;

import bean.ListNode;

public class ReverseLinkedList2 {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
    	if (head == null || m == n){
    		return head;
    	}
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur1, cur2;
        int count = 1;
    	while(count < m){
    		pre = pre.next;
    		count++;
    	}
    	cur1 = pre.next;
    	cur2 = cur1.next;
    	while(count < n){
    		cur1.next = cur2.next;
    		cur2.next = pre.next;
    		pre.next = cur2;
    		cur2 = cur1.next;
    		
        	count++;
        }
    	return dummy.next;
    }
    
    public static void main(String[] args){
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(4);
    	ListNode n5 = new ListNode(5);
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	n4.next = n5;
    	ListNode head = reverseBetween(n1, 1, 5);
    	while (head != null){
    		System.out.print(head);
    		head = head.next;
    	}
    }
}
