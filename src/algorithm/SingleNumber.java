package algorithm;


public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    public int singleNumber2_1(int[] nums) {
        int[] count = new int[32];
        int res = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 0x1) == 1) {
                    count[i]++;
                }
            }
            res |= (count[i] % 3) << i;
        }
        return res;
    }

    public int singleNumber2_2(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < nums.length; i++) {
            twos |= (ones & nums[i]);
            ones ^= nums[i];
            threes = ~(ones & twos);
            ones &= threes;
            twos &= threes;
        }
        return ones;
    }

    public int singleNumber2_3(int[] A) {
        if (A == null) return 0;
        int x0 = ~0, x1 = 0, x2 = 0, t;
        for (int i = 0; i < A.length; i++) {
            t = x2;
            x2 = (x1 & A[i]) | (x2 & ~A[i]);
            x1 = (x0 & A[i]) | (x1 & ~A[i]);
            x0 = (t & A[i]) | (x0 & ~A[i]);
        }
        return x1;
    }

    /**
     * Given an array of integers, every element appears k times except for one. Find that single one who appears l times.
     */
    public int singleNumber_kl(int[] A, int k, int l) {
        if (A == null) return 0;
        int t;
        int[] x = new int[k];
        x[0] = ~0;
        for (int i = 0; i < A.length; i++) {
            t = x[k - 1];
            for (int j = k - 1; j > 0; j--) {
                x[j] = (x[j - 1] & A[i]) | (x[j] & ~A[i]);
            }
            x[0] = (t & A[i]) | (x[0] & ~A[i]);
        }
        return x[l];
    }

}
