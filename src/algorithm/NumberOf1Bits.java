package algorithm;


public class NumberOf1Bits
{
    // you need to treat n as an unsigned value
    public int hammingWeight(int n)
    {
    	int result = 0;
		for (int i = 0; i < 31; i++)
		{
			result |= ((n >>> i) & 0x1) << (31-i);
		}
		return result;
    }
}
