package algorithm;

import bean.TreeNode;

/**
 * Created by szh on 16/4/13.
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        if (root == null)   return 0;
        int sum = root.val;
        if (root.left != null) {

            sum += rob(root.left.left);
            sum += rob(root.left.right);
        }

        if (root.right != null) {
            sum += rob(root.right.left);
            sum += rob(root.right.right);
        }
        return Math.max(sum, rob(root.left)+rob(root.right));
    }
}
