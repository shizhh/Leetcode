package algorithm;

public class UniquePaths2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] obstacleGrid = {
//		                         {0,0,0},
//		                         {0,1,0},
//		                         {0,0,0},
//		                         {0,0,0}
//		                       };
		int[][] obstacleGrid = {
				{1},
				{0}
		};
		UniquePaths2 main = new UniquePaths2();
		System.out.println(main.uniquePathsWithObstacles(obstacleGrid));
	}
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		
		int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] result = new int[n][m];
        
        if(n == 0) return 0;
        if(m == 0) return 0;
        
        for (int i = 0; i < m; i++){
        	result[0][i] = 1 - obstacleGrid[0][i];
        	if (result[0][i] == 0)
        		break;
        }
        for (int j = 0; j < n; j++){
        	result[j][0] = 1 - obstacleGrid[j][0];
        	if (result[j][0] == 0)
        		break;
        }
        
        for ( int i = 1; i < n; i++) {
        	for (int j = 1; j < m; j++) {
        		
        		if(obstacleGrid[i][j] == 1) {
        			result[i][j] = 0;
        		}
        		else result[i][j] = result[i-1][j] + result[i][j-1];
        	}
        }
        
        return result[n-1][m-1];
    }
	
}
