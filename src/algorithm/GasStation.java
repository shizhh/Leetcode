package algorithm;


public class GasStation
{
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        int len = gas.length;
    	int remain = 0;
    	int index = 0;
    	int total = 0;
    	
    	for (int i = 0; i <= len-1; i++)
    	{
    		remain += gas[i] - cost[i];
    		total += gas[i] - cost[i];
    		if (remain < 0)
    		{
    			index = i+1;
    			remain = 0;
    		}
    	}
    	
    	return total < 0 ? -1 : index;
    }
}
