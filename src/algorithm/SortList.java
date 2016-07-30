package algorithm;

import bean.ListNode;

public class SortList
{
	// 归并
	public ListNode sortList(ListNode head)
	{
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(-1);
		
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode newHead = slow.next;
		slow.next = null;
		
		ListNode left = sortList(head);
		ListNode right = sortList(newHead);
		
		ListNode p = dummy;
		while (left != null && right != null)
		{
			if (left.val < right.val)
			{
				p.next = left;
				left = left.next;
			}
			else
			{
				p.next = right;
				right = right.next;
			}
			p = p.next;
		}
		if (left != null)
		{
			p.next = left;
		}
		if (right != null)
		{
			p.next = right;
		}
		
		return dummy.next;
		
	}

	// 快排1
	public ListNode sortList2(ListNode head) {
		if(head==null || head.next==null) return head;
		return helper(head, null);

	}
	public ListNode helper(ListNode head, ListNode tail){
		if(head==tail) return head;
		ListNode dummy = new ListNode(0);
		int val = head.val;
		dummy.next = head;
		ListNode q = head;
		ListNode p = head.next;
		while(p!=tail){
			if(p.val<=val){
				head.next=p.next;
				p.next=dummy.next;
				dummy.next=p;
				p=head.next;
			}else{
				head=head.next;
				p=head.next;
			}
		}
		dummy.next = helper(dummy.next, q);
		q.next = helper(q.next, tail);
		return dummy.next;
	}

	// 快排2
	public ListNode sortList3(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode minDummy = new ListNode(0);
		ListNode maxDummy = new ListNode(0);
		ListNode equalDummy = new ListNode(0);
		ListNode p1 = minDummy;
		ListNode p2 = equalDummy;
		ListNode p3 = maxDummy;

		ListNode p = head;
		while(p!=null)
		{
			if(p.val < head.val){
				p1.next = p;
				p1=p1.next;
			}else if(p.val > head.val){
				p3.next = p;
				p3=p3.next;
			}else{
				p2.next = p;
				p2=p2.next;
			}
			p = p.next;
		}
		p1.next=null;
		p2.next=null;
		p3.next=null;
		minDummy = sortList(minDummy.next);
		maxDummy = sortList(maxDummy.next);

		ListNode dummy = new ListNode(0);
		dummy.next = minDummy;
		p = dummy;
		while(p.next!=null){
			p=p.next;
		}
		p.next=equalDummy.next;
		p2.next=maxDummy;
		return dummy.next;
	}
	
	public static void main(String[] args)
	{
//		ListNode l1 = new ListNode(2);
//		ListNode l2 = new ListNode(1);
//		ListNode l3 = new ListNode(3);
//		ListNode l4 = new ListNode(0);
//
//		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;

		int[] arr = {1,2,3,4,5,5,4,3,2,1,4,-5,3,2,4,5,2,1,2,3,4,5,2,1,3,5,6,7};
		ListNode dummy = new ListNode(0);
		ListNode p =dummy;
		for (int i=0; i<arr.length; i++){
			p.next = new ListNode(arr[i]);
			p=p.next;
		}
		
		SortList main = new SortList();
		ListNode head = main.sortList3(dummy.next);

		while (head != null)
		{
			System.out.print(head);
			head = head.next;
		}


	}
	
	
	
}
