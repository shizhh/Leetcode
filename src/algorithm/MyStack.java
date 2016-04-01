package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack
{
	
	Queue<Integer> queue1 = null;
	Queue<Integer> queue2 = null;

	
	public MyStack()
	{
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}
	
	// Push element x onto stack.
    public void push(int x) {
        if (!queue1.isEmpty())
        {
        	queue1.offer(x);
        }
        else
        {
        	queue2.offer(x);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!queue1.isEmpty())
        {
        	while (queue1.size() > 1)
        		queue2.offer(queue1.poll());
        	queue1.poll();
        }
        else
        {
        	while (queue2.size() > 1)
        		queue1.offer(queue2.poll());
        	queue2.poll();
        }
    }

    // Get the top element.
    public int top() {
        int top;
        if (!queue1.isEmpty())
        {
        	while (queue1.size() > 1)
        	{
        		queue2.offer(queue1.poll());
        	}
        	top = queue1.poll();
        	queue2.offer(top);
        }
        else
        {
        	while (queue2.size() > 1)
        	{
        		queue1.offer(queue2.poll());
        	}
        	top = queue2.poll();
        	queue1.offer(top);
        }
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
