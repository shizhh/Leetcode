package algorithm;

public class DivideTwoIntegers2 {
	
	public static void main(String[] args){
		DivideTwoIntegers2 main = new DivideTwoIntegers2();
		int dividend = -6;
		int divisor = -2;
		System.out.println(main.divide(dividend, divisor));
		
	}
	
	public int divide(int dividend, int divisor) {
        
		long div = Math.abs((long)dividend);
		long divor = Math.abs((long)divisor);
		
		long count = 0;
		if (divor == 0)	return Integer.MAX_VALUE;
		else {
			long  c = 1L;
			
			while (div >= divor) {
				divor = divor << 1;
				c = c << 1;
			}
			// div < divor
			while(div>=Math.abs((long)divisor)){
				while(div>=divor){
					div-=divor;
					count+=c;
				}
				divor = divor>>1;
				c=c>>1;
			}
			
		}
		
		int sign = 1;
		if (dividend < 0)	sign = -sign;
		if (divisor < 0)	sign = -sign;
		
		return sign > 0 ?  (int)count : -(int)count;
    }
	
	
}
