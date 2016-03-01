package algorithm;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle
{
	public boolean hasCycle1(ListNode head)
	{
		Set<ListNode> visited = new HashSet<>();
		while (head != null)
		{
			if (visited.contains(head))
			{
				return true;
			}
			else
			{
				visited.add(head);
			}
			head = head.next;
		}
		return false;
	}
	
	public boolean hasCycle2(ListNode head)
	{
		if (head == null)
			return false;
		
		ListNode walker = head;
		ListNode runner = head;
		while (runner.next != null && runner.next.next != null)
		{
			walker = walker.next;
			runner = runner.next.next;
			if (walker == runner)
				return true;
		}
		return false;
	}
	
	public ListNode detectCycle1(ListNode head)
	{
		if (head == null)
			return head;
		
		Set<ListNode> visited = new HashSet<>();
		while (head != null)
		{
			if (visited.contains(head))
			{
				return head;
			}
			else
			{
				visited.add(head);
			}
			head = head.next;
		}
		return null;
	}
	
	public ListNode detectCycle2(ListNode head)
	{
		if (head == null)
			return null;
		
		ListNode walker = head;
		ListNode runner = head;
		while (runner.next != null && runner.next.next != null)
		{
			walker = walker.next;
			runner = runner.next.next;
			if (walker == runner)
			{
				ListNode walker2 = head;
				while (walker2 != walker)
				{
					walker2 = walker2.next;
					walker = walker.next;
				}
				return walker;
			}
		}
		return null;
	}
	
	class ListNode
	{
		int val;
		ListNode next;
		ListNode(int x)
		{
			val = x;
			next = null;
		}
	}
}
