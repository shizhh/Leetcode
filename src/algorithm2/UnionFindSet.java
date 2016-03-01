package algorithm2;


public class UnionFindSet
{
	private int[] f = new int[1000];
	
	// 初始化
	public void init(int[] f, int n)
	{
		for (int i=1; i<=n; i++)
			f[i] = i;
	}
	
	// 找到父亲，即根节点
	public int getf(int v)
	{
		if (v == f[v])
			return v;
		else
		{
			f[v] = getf(f[v]);
			return f[v];
		}
	}
	
	// 合并，"向左看齐"
	public void merge(int v, int u)
	{
		int t1 = getf(v);
		int t2 = getf(u);
		if (t1 != t2)
		{
			f[t2] = t1;
		}
	}
	
	
	public int unionfind(int[][] arr, int m, int n)
	{
		int count = 0;
		init(f, n);
		for (int i = 0; i < m; i++)
		{
			merge(arr[i][0], arr[i][1]);
			print(f, n);
		}
		
		for (int i = 1; i <= n; i++)
		{
			if (i == f[i])
				count++;
		}
		return count;
	}
	
	private void print(int[] f, int n)
	{
		for (int i = 1; i <= n; i++)
		{
			System.out.print(f[i]);
			System.out.print(" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		int[][] arr = {
				{1,2},
				{3,4},
				{5,2},
				{4,6},
				{2,6},
				{8,7},
				{9,7},
				{1,6},
				{2,4}
		};
		
		int n = 10;
		int m = arr.length;
		
		UnionFindSet main = new UnionFindSet();
		System.out.println(main.unionfind(arr, m, n));
	}
}
