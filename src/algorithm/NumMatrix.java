package algorithm;

/**
 * Created by szh on 16/4/5.
 */
public class NumMatrix {

    static int [][] sumMatrix;

    public NumMatrix(int[][] matrix)
    {
        sumMatrix = matrix;
        for (int i = 0; i < matrix.length; ++i)
            for (int j = 1; j < matrix[0].length; ++j)
                sumMatrix[i][j] += sumMatrix[i][j-1];
    }

    public int sumRegion(int row1, int col1, int row2, int col2)
    {
        int sum = 0;
        for (int i = row1; i <= row2; ++i)
        {
            if (col1 > 0)   sum += sumMatrix[i][col2] - sumMatrix[i][col1-1];
            else sum+= sumMatrix[i][col2];
        }

        return sum;
    }
}
