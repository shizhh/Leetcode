package algorithm;

import java.util.ArrayList;
import java.util.List;

public class MinStack
{
	List<Integer> minList = new ArrayList<>();
	List<Integer> list = new ArrayList<>();
	
	public void push(int x) 
	{
        list.add(x);
        if (!minList.isEmpty())
        {
        	minList.add(Math.min(x, minList.get(minList.size()-1)));
        }
        else 
        {
        	minList.add(x);
        }
    }

    public void pop() 
    {
        list.remove(list.size()-1);
        minList.remove(minList.size()-1);
    }

    public int top() 
    {
        return list.get(list.size()-1);
    }

    public int getMin() 
    {
        return minList.get(minList.size()-1);
    }
}
