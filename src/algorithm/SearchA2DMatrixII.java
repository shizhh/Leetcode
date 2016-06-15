package algorithm;

/**
 * Created by szh on 16/4/19.
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i <= m-1 && j >= 0 ) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        SearchA2DMatrixII searchA2DMatrixII = new SearchA2DMatrixII();

        System.out.println(searchA2DMatrixII.searchMatrix(matrix, 8));
    }
}
