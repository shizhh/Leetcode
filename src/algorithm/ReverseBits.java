package algorithm;


public class ReverseBits
{
	public int reverseBits(int n)
	{
		int result = 0;
		for (int i = 0; i <= 31; i++)
		{
			result |= ((n >>> i) & 0x1) << (31-i);
		}
		return result;
	}
	
	public int reverseBits2(int n) {
	    int result = 0;
	    for (int i = 0; i < 32; i++) {
	        result += n & 1;
	        n >>>= 1;   // CATCH: must do unsigned shift
	        if (i < 31) // CATCH: for last digit, don't shift!
	            result <<= 1;
	    }
	    return result;
	}
	
	/**
     * Returns the value obtained by reversing the order of the bits in the
     * two's complement binary representation of the specified {@code int}
     * value.
     *
     * @return the value obtained by reversing order of the bits in the
     *     specified {@code int} value.
     * @since 1.5
     */
	public int reverseBits3(int i) {
        // HD, Figure 7-1
        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;	// abcdefgh --> badcfehg
        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;	// badcfehg --> dcbahgfe
        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;	// dcbahgfe --> hgfedcba
        i = (i << 24) | ((i & 0xff00) << 8) |
            ((i >>> 8) & 0xff00) | (i >>> 24);
        return i;
    }
	
	public static void main(String[] args)
	{
		int n = 10010;
		ReverseBits main = new ReverseBits();
		System.out.println(main.reverseBits(n));
		System.out.println(main.reverseBits2(n));
//		Integer.reverse(n);
		System.out.println(Integer.toBinaryString(0x55555555));
		System.out.println(Integer.toBinaryString(0x33333333));
		System.out.println(Integer.toBinaryString(0x0f0f0f0f));
		System.out.println(Integer.toBinaryString(0xff00));
		System.out.println(Integer.toBinaryString(0xff00));
	}
}
