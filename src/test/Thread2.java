package test;


public class Thread2 extends Thread
{
	DeadLock lock = null;
	
	
	public Thread2(DeadLock lock)
	{
		this.lock = lock;
	}
	
	public void run()
	{
		try
		{
			lock.rightLeft();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
