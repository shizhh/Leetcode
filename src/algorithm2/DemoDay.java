package algorithm2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhenhui on 2016/4/7.
 */
public class DemoDay {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int m = Integer.parseInt(line.split(" ")[0]);
        int n = Integer.parseInt(line.split(" ")[1]);
        char [][] grid = new char[m][n];
        for (int i = 0; i < m; ++i)
            grid[i] = in.nextLine().toCharArray();
        int [][][] dp = new int[m+1][n+1][2];
        for (int i = 0; i <= m; ++i)
            for ( int j = 0; j <= n; ++j)
                Arrays.fill(dp[i][j], m*n);
        // (0,0)处处理
        dp[1][1][1] = 0;
        dp[1][1][0] = (n == 1 || grid[0][1] == 'b') ? 0 : 1;
        for (int i = 1; i <= m; ++i){
            for (int j = 1; j <= n; j++){
                if (i == 1 && j == 1)   // 已处理过(0,0)，跳过
                    continue;
                if (grid[i-1][j-1] == 'b')  // 考虑是否为障碍，为障碍多一次改变次数
                    dp[i][j][0]=dp[i][j][1]=1;
                else dp[i][j][0]=dp[i][j][1]=0;
                int step = 0;

                // 考虑向下
                if (j == n || grid[i-1][j] == 'b')
                    step = dp[i][j-1][1];
                else step = dp[i][j-1][1]+1;
                dp[i][j][0] += Math.min(step, dp[i-1][j][0]);

                // 考虑向右
                if (i == m || grid[i][j-1] == 'b')
                    step = dp[i-1][j][0];
                else step = dp[i-1][j][0]+1;
                dp[i][j][1] += Math.min(step, dp[i][j-1][1]);
            }
        }
        System.out.println(Math.min(dp[m][n][0], dp[m][n][1]));
    }
}
