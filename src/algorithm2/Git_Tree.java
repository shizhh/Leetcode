package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by szh on 16/3/28.
 */
public class Git_Tree {
    /**
     * 返回git树上两点的最近分割点
     *
     * @param matrix 接邻矩阵，表示git树，matrix[i][j] == '1' 当且仅当git树中第i个和第j个节点有连接，节点0为git树的跟节点
     * @param indexA 节点A的index
     * @param indexB 节点B的index
     * @return 整型
     */
    public int getSplitNode(String[] matrix, int indexA, int indexB) {
        int n = matrix.length;
        List<List<Integer>> table = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            table.add(new ArrayList<>());

        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++) {
                if (matrix[i].charAt(j) == '1') {
                    table.get(i).add(j);
                    table.get(j).add(i);
                }
            }

        int[] parents = new int[n];
        int[] levels = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = -1;
            levels[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        levels[0] = 0;
        while (!stack.isEmpty()) {
            int u = stack.pop();
            for (int k = 0; k < table.get(u).size(); k++) {
                int v = table.get(u).get(k);
                if (parents[v] != -1)
                    continue;
                parents[v] = u;
                levels[v] = levels[u] + 1;
                stack.add(v);
            }
        }

        int a = indexA, b = indexB;
        while (levels[a] > levels[b]) {
            a = parents[a];
        }
        while (levels[a] < levels[b]) {
            b = parents[b];
        }
        while (a != b) {
            a = parents[a];
            b = parents[b];
        }
        return a;
    }
}
