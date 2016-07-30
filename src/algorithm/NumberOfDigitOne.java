package algorithm;

/**
 * Created by szh on 16/7/30.
 */
public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        int countOnes = 0;
        for(long m = 1; m <= n; m *= 10){
            long a = n / m;
            long b = n % m;
            countOnes += (a+8) / 10 * m + (a%10 == 1 ? b+1 : 0);
        }
        return countOnes;
    }
}
