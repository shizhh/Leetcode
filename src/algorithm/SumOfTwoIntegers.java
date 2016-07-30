package algorithm;

/**
 * Created by szh on 16/7/9.
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b){
        while(b!=0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
    // 减法 a-b
    public int getSubtract(int a, int b){
        b = ~b + 1;
        while(b != 0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public int getSubtract2(int a, int b){
        while (b != 0){
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }
        return a;
    }
    public static void main(String[] args){
        System.out.println(new SumOfTwoIntegers().getSum(-8,-1));
        System.out.println(new SumOfTwoIntegers().getSubtract(2,3));
    }
}
