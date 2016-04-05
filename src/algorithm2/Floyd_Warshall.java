package algorithm;

/**
 * Created by szh on 16/3/25.
 */
public class Floyd_Warshall
{
    private static  final int inf = 1000;
    public static  void shortPath(int[][] dist)
    {
        for (int k = 0; k < dist.length; k++)
            for (int i = 0; i < dist.length; i++)
                for (int j = 0; j < dist.length; j++)
                {
                    if (dist[i][j] > dist[i][k]+dist[k][j])
                        dist[i][j] = dist[i][k]+dist[k][j];
                }

        // print dist[][]
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                System.out.print(dist[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static  void  main (String[] args)
    {
        int[][] dist = {
                {0,2,6,4},
                {inf,0,3,inf},
                {7,inf,0,1},
                {5,inf,12,0}
        };
        shortPath(dist);
    }
}
