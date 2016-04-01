package algorithm;

import java.util.HashMap;
import java.util.Map;

public class HappyNumber
{
	public boolean isHappy(int n)
	{
		Map<Integer, Integer> map = new HashMap<>();
        map.put(n, 1);
        int sum = n;
        int q = n;
        while (sum != 1)
        {
            q = sum;
            sum = 0;
            while(q > 0)
            {
                int r = q % 10;
                sum += r * r;
                q = q / 10;
            }
            if (!map.containsKey(sum))
            {
                map.put(sum, 1);
            }
            else
            {
                return false;
            }
        }
        return true;
	}
	
	// --------------------------------
	// 类似于linked list cycle detection
	// --------------------------------
	public boolean isHappy2(int n)
	{
		int slow = n; 
		int fast = next(n);
		while(slow != fast)
		{
			slow = next(slow);
			fast = next(next(fast));
			if (fast == 1)
				return true;
		}
		return slow == 1;
	}
	
	private int next(int n)
	{
		int result = 0;
		while (n > 0)
		{
			int r = n % 10;
			result += r * r;
			n /= 10;
		}
		return result;
	}
}
