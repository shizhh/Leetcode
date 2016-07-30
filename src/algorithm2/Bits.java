package algorithm2;

/**
 * Created by szh on 16/7/28.
 */
public class Bits {
    private int BITSPERWORD = 32;
    private int SHIFT = 5;
    private int MASK = 0x1F;
    private int N = 10000000;
    private int[] a = new int[1 + N/BITSPERWORD];

    void set(int i){
        a[i>>SHIFT] |= (1<<(i & MASK));
    }

    void clr(int i){
        a[i>>SHIFT] &= ~(1<<(i & MASK));
    }

    int test(int i){
        return a[i>>SHIFT] & (1<<(i & MASK));
    }

    public static void main(String[] args){
        Bits main = new Bits();
        main.set(1);
        //main.set(1);
//        for(int i=0; i<15; i++){
//            System.out.println(i+" "+main.a[i]);
//        }
        System.out.println(main.MASK);
    }
}
