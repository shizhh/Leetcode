package algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import bean.RandomListNode;
import bean.UndirectedGraphNode;

public class CloneGraph
{
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) 
    {
        if (node == null)
        	return null;
        
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
        visited.put(node, head);
        
        while (!queue.isEmpty())
        {
        	UndirectedGraphNode oldNode = queue.poll();
        	
        	
        	
        	for (UndirectedGraphNode node1 : oldNode.neighbors)
        	{
        		if (!visited.containsKey(node1))
        		{
        			queue.offer(node1);
        			UndirectedGraphNode newNode = new UndirectedGraphNode(node1.label);
        			visited.put(node1, newNode);
        		}
        		visited.get(oldNode).neighbors.add(visited.get(node1));
        	}
        }
        return head;
    }
    
    public static void main(String[] args)
    {
    	RandomListNode node1 = new RandomListNode(1);
    	RandomListNode node2 = new RandomListNode(1);
    	Map<RandomListNode, RandomListNode> map = new HashMap<>();
    	map.put(node1, node1);
    	System.out.println(map.containsKey(node1));
    }
}
