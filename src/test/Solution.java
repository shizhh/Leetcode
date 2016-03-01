package test;


public class Solution
{
	int[] a = new int[9];
	int[] book = new int[9];
	int total = 0;
	
	public void dfs(int step)
	{
		if (step == 9)
		{
			if (a[1]-a[2]==1 && a[3]+a[4]==9 && a[5]+a[6]==7 && a[7]-a[8]==2)
			{
				total++;
				print(a);
			}
//			if (a[1]*100+a[2]*10+a[3]+a[4]*100+a[5]*10+a[6]==a[7]*100+a[8]*10+a[9])
//			{
//				total++;
//				print(a);
//			}
		}
		
		for (int i = 1; i <= 8; i++)
		{
			if (book[i]==0)
			{
				a[step]=i;
				book[i]=1;
				
				dfs(step+1);
				
				book[i]=0;
			}
		}
	}
	
	private void print(int[] a)
	{
		for (int i=1; i<a.length-1; i++)
		{
			System.out.print(a[i]);
			System.out.print(" ");
		}
		System.out.println(a[a.length-1]);
	}
	
	public static void main(String[] args)
	{
		Solution main = new Solution();
		main.dfs(1);
		
	}
}
