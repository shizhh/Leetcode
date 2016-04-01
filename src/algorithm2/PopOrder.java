package algorithm2;

import java.util.Stack;

public class PopOrder
{
	public boolean isPopOrder(int[] pop, int[] push)
	{
		boolean possible = false;
		int len = pop.length;
		int popidx = 0;
		int pushidx = 0;
		Stack<Integer> stack = new Stack<>();
		while (popidx < len)
		{
			while (stack.isEmpty() || stack.peek() != pop[popidx])
			{
				if (pushidx > len-1)
					break;
				stack.push(push[pushidx]);
				pushidx++;
			}
			
			if (stack.peek() != pop[popidx])
				break;
			
			stack.pop();
			popidx++;
		}
		
		if (stack.isEmpty() || stack.size() == len)
			possible = true;
		
		return possible;
	}
	
	public static void main(String[] args)
	{
		int[] pop = {4,3,5,1,2};
		int[] push = {1,2,3,4,5};
		System.out.println(new PopOrder().isPopOrder(pop, push));
	}
}
