package algorithm;

import bean.ListNode;

public class IntersectionofTwoLinkedLists
{
	public ListNode getInterSectionNode(ListNode headA, ListNode headB)
	{
		if (headA == null || headB == null)
			return null;
		
		if (!hasIntersactionNode(headA, headB))
			return null;
		
		int countAC=0, countBC=0, countAB=0;
		
		ListNode pC = null;
		
		countAC = getNodeNum(headA);
		countBC = getNodeNum(headB);
		
		pC = reverseList(headA);
		countAB = getNodeNum(headB);
		
		reverseList(pC);
		
		int count = (countAB - countAC + countBC) / 2;	// B
		
		ListNode intersectionNode = headB;
		while (count > 0)
		{
			intersectionNode = intersectionNode.next;
			count--;
		}
		
		return intersectionNode;
	}
	
	public boolean hasIntersactionNode(ListNode headA, ListNode headB)
	{
		ListNode pA = headA;
		ListNode pB = headB;
		while (pA.next != null)
		{
			pA = pA.next;
		}
		while (pB.next != null)
		{
			pB = pB.next;
		}
		return pA == pB;
	}
	
	public int getNodeNum(ListNode head)
	{
		int count = 0;
		while (head != null)
		{
			count++;
			head = head.next;
		}
		return count;
	}
	
	public ListNode reverseList(ListNode head)
	{
		if (head == null)
			return head;
		
		ListNode p = head.next;
		head.next = null;
		ListNode p2 = null;
		while (p != null)
		{
			p2 = p.next;
			p.next = head;
			head = p;
			p = p2;
		}
		
		return head;
	}
}
