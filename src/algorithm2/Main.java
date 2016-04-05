package algorithm;

import java.util.Scanner;

public class Main {
    public String isPrim(int n) {
        if (n > 1 && n < 4) return "Yes";

        if ((n & 0x1) == 0 || n == 1) return "No";

        boolean[] notPrim = new boolean[n + 1];

        for (int i = 4; i <= n; ++i) {
            if (!notPrim[i]) {
                for (int j = (int) Math.sqrt(i); j * i <= n; ++j) {
                    notPrim[j * i] = true;
                    if (j * i == n) return "No";
                }
            }
        }

        return "Yes";
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- > 0)
        {
            int i = in.nextInt();
            String rs = main.isPrim(i);
            System.out.println(rs);
        }
    }

}