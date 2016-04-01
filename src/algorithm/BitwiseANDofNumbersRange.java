package algorithm;


public class BitwiseANDofNumbersRange
{
	public int rangeBitWiseAnd(int m, int n)
	{
		int offset = 0;
		while (m != n)
		{
			m = m >> 1;
			n = n >> 1;
			offset++;
		}
		return m << offset;
	}
}
