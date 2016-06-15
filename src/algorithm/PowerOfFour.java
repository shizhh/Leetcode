package algorithm;

/**
 * Created by szh on 16/4/20.
 * 二进制表示末尾0的个数为偶数个
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
        String b = Integer.toBinaryString(num);
        int len = b.length();
        if ((len & 1) != 1) return false;
        int r = (int)Math.pow(2, len-1)-1;
        return (num & r) == 0;
    }
}
