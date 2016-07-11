package algorithm2;

import java.util.Scanner;

/**
 * Created by szh on 16/7/11.
 */
public class Indeed_Board {

    public int solve(char[][] s){
        int res=0;
        int r = s.length;
        int c = s[0].length;
        for(int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                if((i-1>=0 && s[i-1][j]=='C') || (j-1>=0 && s[i][j-1]=='R'));
                else res++;
            }
        }
        return res;
    }

    public void run(){
        Scanner in = new Scanner(System.in);
        String[] t1 = in.nextLine().split(" ");
        int r = Integer.parseInt(t1[0]);
        int c = Integer.parseInt(t1[1]);
        char[][] s = new char[r][c];
        for (int i=0; i<r; i++){
            s[i] = in.nextLine().toCharArray();
        }
        int cnt = 0;
        int[] xy = new int[r*c*2];
        for (int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if (s[i][j]=='?') {
                    xy[cnt++] = i;
                    xy[cnt++] = j;
                }
            }
        }
        int m=cnt>>1;
        int ans=0;
        if (m==0){
            ans=solve(s);
            System.out.println((double)ans);
        }
        else {
            for (int k = 0; k < (1 << m); k++) {
                for (int i = 0; i < m; i++) {
                    int x = xy[2 * i];
                    int y = xy[2 * i + 1];
                    if ((k & (1 << i)) == 1) {
                        s[x][y] = 'R';
                    } else s[x][y] = 'C';
                }
                ans += solve(s);
            }
            System.out.println((double) ans / (1<<m));
        }
    }
    public static void main(String[] args){
        /**
         * input format
         * 1 2
         * ??
         * */
        Indeed_Board main = new Indeed_Board();
        main.run();
    }

}
