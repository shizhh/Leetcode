package algorithm;


import java.util.HashMap;
import java.util.Map;

import bean.RandomListNode;

public class CopyListwithRandomPointer
{
    public RandomListNode copyRandomList(RandomListNode head) 
    {
        
    	if (head == null)
    		return head;
    	
    	RandomListNode newHead = new RandomListNode(head.label);
    	
    	Map<RandomListNode, RandomListNode> map = new HashMap<>();
    	map.put(head, newHead);
    	
    	while (head != null)
    	{
    		
    		RandomListNode node = null;
    		RandomListNode newNext = null;
    		RandomListNode newRandom = null;
    		
    		if (!map.containsKey(head))
    		{
    			node = new RandomListNode(head.label);
    			map.put(head, node);
    		}
    		else
    		{
    			node = map.get(head);
    		}
    		
    		if (head.next != null)
    		{
    			if (!map.containsKey(head.next))
    			{
    				newNext = new RandomListNode(head.next.label);
    				map.put(head.next, newNext);
    			}
    			else
    			{
    				newNext = map.get(head.next);
    			}
    			node.next = newNext;
    		}
    		
    		if (head.random != null)
    		{
    			if (!map.containsKey(head.random))
    			{
    				newRandom = new RandomListNode(head.random.label);
    				map.put(head.random, newRandom);
    			}
    			else
    			{
    				newRandom = map.get(head.random);
    			}
    			node.random = newRandom;
    			
    		}
    		head = head.next;
    		
    	}
    	
    	return newHead;
    }
}
