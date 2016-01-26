package algorithm;

import java.util.ArrayList;
import java.util.List;

import bean.TreeNode;

public class UniqueBST2 {

	public List<TreeNode> generateTrees(int n){
		List<TreeNode> res = new ArrayList<>();
		if (n < 1)
			return res;
		return generateT(1, n);
	}
	
	private List<TreeNode> generateT(int left, int right){
		List<TreeNode> res = new ArrayList<>();
		if (left > right){
			res.add(null);
			return res;
		}
		if (left == right){
			res.add(new TreeNode(right));
			return res;
		}
		
		for (int i=left; i<=right; i++){
			List<TreeNode> leftList = generateT(left, i-1);
			List<TreeNode> rightList = generateT(i+1, right);
			
			for (TreeNode lnode : leftList){
				for (TreeNode rnode : rightList){
					TreeNode root = new TreeNode(i);
					root.left = lnode;
					root.right = rnode;
					res.add(root);
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		UniqueBST2 main = new UniqueBST2();
		System.out.println(main.generateTrees(2));
	}
}
