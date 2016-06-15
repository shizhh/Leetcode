package algorithm;

import bean.TreeNode;

/**
 * Created by szh on 16/4/19.
 */
public class BinaryTreeUpsideDown {
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        return dfsBottomUp(root, null);
    }

    private TreeNode dfsBottomUp(TreeNode p, TreeNode parent) {
        if (p == null)  return parent;
        TreeNode root = dfsBottomUp(p.left, p);
        p.left = parent != null ? parent.right : null;
        p.right = parent;
        return root;
    }

    // iteration method
    public TreeNode UpsideDownBinaryTree_iter(TreeNode root) {
        TreeNode p = root, parent = null, parentRight = null;
        while (p != null) {
            TreeNode left = p.left;
            p.left = parentRight;
            parentRight = p.right;
            p.right = parent;
            parent = p;
            p = left;
        }
        return parent;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        BinaryTreeUpsideDown binaryTreeUpsideDown = new BinaryTreeUpsideDown();
        TreeNode newRoot = binaryTreeUpsideDown.UpsideDownBinaryTree(t1);
        System.out.println(newRoot);
        System.out.println(newRoot.left);
        System.out.println(newRoot.right);
//        System.out.println(newRoot.val);
//        System.out.println(newRoot.val);
    }
}
