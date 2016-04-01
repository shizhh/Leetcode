package algorithm;


public class CountPrimes
{
	public int countPrimes(int n)
    {
        int count = 0;
        for (int i = 1; i < n; i++)
        {
            if (isPrime(i)) count++;
        }
        return count;
    }
    
    private boolean isPrime(int num)
    {
        if (num <= 1)
            return false;
        if (num == 2)
            return true;
        if ((num & 0x1) == 0)
            return false;
        for (int i = 3; i * i <= num; i++)
        {
            if (num % i == 0)
                return false;
        }
        return true;
    }
    
    // ------------------------------
    // 
    // ------------------------------
    public int countPrimes2(int n)
    {
    	boolean[] isPrime = new boolean[n];
    	for (int i = 2; i < n; i++)
    		isPrime[i] = true;
    	
    	for (int i = 2; i * i < n; i++)
    	{
    		if (!isPrime[i])	continue;
    		for (int j = i * i; j < n; j += i)
    		{
    			isPrime[j] = false;
    		}
    	}
    	
    	int count = 0;
    	for (int i = 2; i < n; i++)
    	{
    		if (isPrime[i])	count++;
    	}
    	return count;
    }
    
    public int countPrimes3(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = (int)Math.sqrt(i); i*j < n; j += 1) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }
    
    public static void main(String[] args)
    {
    	int n = 1500000;
    	CountPrimes main = new CountPrimes();
    	System.out.println(main.countPrimes3(n));
    	System.out.println(main.countPrimes2(n));
    }
    
}
