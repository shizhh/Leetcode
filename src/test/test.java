package test;

import java.util.HashMap;
import java.util.Hashtable;

public class test
{
	
	public static void main(String[] args)
	{
//		DeadLock lock = new DeadLock();
//		new Thread1(lock).start();
//		new Thread2(lock).start();
		int x = 5+~10;
		System.out.println(x);
		
		System.out.println(Integer.toBinaryString(10));
		System.out.println(Integer.toBinaryString(~10));
		System.out.println(~-17846);
		System.out.println(-1%10);
		
	}
}

class DeadLock
{
	private final Object left = new Object();
	private final Object right = new Object();
	
	public void leftRight()	throws Exception
	{
		synchronized(left)
		{
			Thread.sleep(2000);
			
			synchronized(right)
			{
				System.out.println("left end");
			}
		}
	}
	
	public void rightLeft() throws Exception
	{
		synchronized(right)
		{
			Thread.sleep(2000);
			synchronized(left)
			{
				System.out.println("right end");
			}
		}
	}
}
