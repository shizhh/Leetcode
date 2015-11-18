package algorithm;

public class Sqrt {
	
	public static void main( String[] args ){
		Sqrt main = new Sqrt();
		
		//System.out.println(Integer.MAX_VALUE);
		int result = main.mySqrt(Integer.MAX_VALUE);
		System.out.println(result);
		
		//System.out.println((int)Math.sqrt(2147483647));
	}
	
	public int mySqrt( int x ) {
		int low = 1;
		int high = ( x >> 1 ) + 1;
		int mid;
		while (low <= high) {
			mid = (( high - low ) >> 1) + low;
			if (mid == x / mid) return mid;
			else if (mid < x / mid) low = mid + 1;
			else high = mid - 1;
		}
		
		return high * high > x ? high - 1 : high;
	}
}
