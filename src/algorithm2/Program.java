package algorithm2;


import java.util.Arrays;

public class Program {

    public static void main(String[] args) {
        Program program = new Program();
        float[] a = {1,2,3,1,3};
        int[] b = program.Puzzle(a);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }


    public static int[] Puzzle(float[] a) {
        float[] result = new float[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = a.length-1; j>0; j--) {
                if (a[j] < a[j-1]) {
                    float t = a[j];
                    a[j] = a[j-1];
                    a[j-1] = t;
                }
            }
        }

        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length-1; j >= 0; j--) {
                if (result[i] == a[j])
                    b[i] = j;
            }
        }

        return b;
    }

    public static int numForParenthese(int n) {
        int[] h = new int[n+1];
        h[0] = 1; h[1] = 1;
        for (int i = 2; i < n+1; i++) {
            h[i] = h[i-1]* (4*i-2)/(i+1);
        }
        return h[n];
    }
}