package algorithm;

import bean.TreeNode;

import java.util.*;

/**
 * Created by szh on 16/4/24.
 */
public class ConvertBST2LinkedList {

    public TreeNode convert(TreeNode root) {
        TreeNode lastNode = convertNode(root, null);
        if (lastNode == null) return null;
        TreeNode head = lastNode;
        while (head.left != null) head = head.left;
        return head;
    }

    /**
     * 将二叉搜索树转化为双向链表
     *
     * @return 子树中序遍历的最后的节点, 即子树的最大的节点
     */
    public TreeNode convertNode(TreeNode root, TreeNode lastNode) {
        if (root == null) return null;
        if (root.left != null)
            lastNode = convertNode(root.left, lastNode);
        root.left = lastNode;
        if (lastNode != null)
            lastNode.right = root;

        lastNode = root;    // 左子树处理完,[当右子树为null时,最大的节点为root],故root作为当前最大的节点

        if (root.right != null)
            lastNode = convertNode(root.right, lastNode);

        return lastNode;
    }

}
