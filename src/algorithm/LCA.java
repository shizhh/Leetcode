package algorithm;

/**
 * Created by szh on 16/7/16.
 */
public class LCA {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(helper(root.left,p,q)==1 && helper(root.right,p,q)==1){
            return root;
        }
        if (helper(root.left,p,q) == 2){
            return lowestCommonAncestor(root.left,p,q);
        }
        else return lowestCommonAncestor(root.right,p,q);
    }

    private int helper(TreeNode node, TreeNode p, TreeNode q){
        if(node==null) return 0;
        if(node==p||node==q) return 1;
        return helper(node.left,p,q)+helper(node.right,p,q);
    }
    public static void main(String[] args){
        LCA main = new LCA();
        TreeNode root = main.new TreeNode(2);
        root.left = main.new TreeNode(3);
        root.right = main.new TreeNode(4);
        root.left.left = main.new TreeNode(5);
        root.left.right = main.new TreeNode(6);
        root.right.left = main.new TreeNode(7);
        root.right.right = main.new TreeNode(8);

        System.out.println(main.lowestCommonAncestor(root, root.left.left,root.right.right).val);
    }
}
