package algorithm2;

import bean.TreeNode;

import java.util.*;

public class CommonParent {
//	static StringBuffer temp = new StringBuffer();
//	static char[] carr = { '\0', '9', 'g' };
//
//	public static void dfs(int step, String str) {
//		if (step == str.length()) {
//			System.out.println(temp.toString());
//			// temp.delete(0, temp.length());
//			return;
//		}
//		for (int i = 0; i < 3; i++) {
//			char ch = str.charAt(step);
//
//			if (ch != '9' && ch != 'g') {
//				temp.append(ch);
//				dfs(step + 1, str);
//				return;
//
//			} else {
//				if (i == 0) {
//					i++;
//					temp.append(carr[i]);
//				} else {
//					temp.append(carr[i]);
//
//				}
//				dfs(step + 1, str);
//				temp.delete(step, temp.length());
//			}
//		}
//	}
//
//	public static void main(String[] args) {
//		String string = "99XXXXg";
//		dfs(0, string);
//	}

    static StringBuilder code = new StringBuilder("0");

    public static void encoding(TreeNode root, StringBuilder code, Map<Integer, String> map) {
        if (root == null) return;
//        if (root.val == target) map.put(target, code.toString());
        else map.put(root.val, code.toString());

        encoding(root.left, code.append(0), map);
        code.deleteCharAt(code.length()-1);
        encoding(root.right, code.append(1), map);
        code.deleteCharAt(code.length()-1);
    }

    public static TreeNode findNearestParent(TreeNode root, TreeNode node1, TreeNode node2, Map<Integer, String> map) {
        String s1 = map.get(node1.val);
        String s2 = map.get(node2.val);
        int len = Math.min(s1.length(), s2.length());
        int i = -1;
        while (++i < len && s1.charAt(i) == s2.charAt(i));
        TreeNode resNode = root;
        for (int j = 1; j < i; j++) {
            if (s1.charAt(j) == '0') resNode = resNode.left;
            else resNode = resNode.right;
        }
        return resNode;
    }

    public static TreeNode findNearestParent2(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || root == node2) return root;
        TreeNode left = findNearestParent2(root.left, node1, node2);
        TreeNode right = findNearestParent2(root.right, node1, node2);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        Map<Integer, String> result = new HashMap<>();

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t4.right = t5;
        t4.left = t6;
        t6.left = t7;
        t5.left = t8;
        t5.right = t9;
        encoding(t1, code, result);

        TreeNode node = findNearestParent(t1, t2, t8, result);

        System.out.println(result);

        System.out.println("node: " + node);

        System.out.println("node: " + findNearestParent2(t1, t2, t8));
    }
}