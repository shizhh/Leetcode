package algorithm;


public class CountingBits
{
	public int[] countBits(int num) 
    {
        if (num == 0)   return new int[]{0};
        int[] res = new int[num+1];
        int count = 0;
        while (true)
        {
            int len = count+1;
            for (int j = 0; j < len; j++)
            {
                res[++count] = res[j]+1;
                if (count >= num)   return res;
            }
        }
    }
}
