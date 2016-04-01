package test;


public class Thread1 extends Thread
{
	DeadLock lock = null;
	
	
	public Thread1(DeadLock lock)
	{
		this.lock = lock;
	}
	
	public void run()
	{
		try
		{
			lock.leftRight();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
