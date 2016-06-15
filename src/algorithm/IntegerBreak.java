package algorithm;

import java.util.Arrays;

/**
 * Created by szh on 16/4/20.
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        if (n < 1) return 0;
        int maxProduct = 1;
        for (int i = 1; i <= n / 2; i++) {
            int j = n - i;
            int left = Math.max(i, integerBreak(i));
            int right = Math.max(j, integerBreak(j));
            maxProduct = Math.max(maxProduct, left * right);
        }
        return maxProduct;
    }


    public int integerBreak2(int n) {
        int[] map = new int[n + 1];
        Arrays.fill(map, -1);
        return integerBreak_map(n, map);
    }

    public int integerBreak_map(int n, int[] map) {
        int maxProduct = 1;
        if (n < 1) return 0;
        for (int i = 1; i <= n / 2; i++) {
            int j = n - i;
            if (map[i] == -1) map[i] = integerBreak(i);
            if (map[j] == -1) map[j] = integerBreak(j);
            int l = Math.max(i, map[i]);
            int r = Math.max(j, map[j]);
            maxProduct = Math.max(maxProduct, l * r);
        }

        return maxProduct;
    }

    public int integerBreak3(int n) {
        int[] map = new int[n + 1];
        map[1] = 1;
        map[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                int curr = (j > map[j] ? j : map[j]) * (i - j > map[i - j] ? i - j : map[i - j]);
                if (curr > map[i]) map[i] = curr;
            }
        }
        return map[n];
    }

    public static void main(String[] args) {
        IntegerBreak integerBreak = new IntegerBreak();
        System.out.println(integerBreak.integerBreak2(28));
        System.out.println(integerBreak.integerBreak(28));
        System.out.println(integerBreak.integerBreak3(28));
    }

}
