package algorithm2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import bean.TreeNode;

/**
 * 给定一颗二叉树，每个节点有不同的值，每条边的长度为1，
 * 找到最大值到最小值之间的路径长度。
 * 
 * */

public class BinaryTreePathMin2Max
{
	/*
	 * 遍历二叉树的同时给二叉树节点编码，左边为0，右边为1
	 * */
	public int pathLength(TreeNode root)
	{
		if (root == null)	return 0;
		init(root);
		helper(root);
		
		String minString = map.get(min);
		String maxString = map.get(max);
		int minLen = minString.length();
		int maxLen = maxString.length();
		int index = 0;
		while (index < minLen && index < maxLen && minString.charAt(index) == maxString.charAt(index))
		{
			index++;
		}
		
		
		return minLen+maxLen-2*index;
	}
	
	static Map<Integer, String> map = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	private static void init(TreeNode root)
	{
		sb.append(0);
		map.put(root.val, sb.toString());
	}
	
	private static void helper(TreeNode root)
	{
		min = Math.min(root.val, min);
		max = Math.max(root.val, max);
		
		
		if(root.left != null)
		{
			sb.append(0);
			map.put(root.left.val,sb.toString());
			helper(root.left);
			sb.deleteCharAt(sb.length()-1);
		}
		if (root.right != null)
		{
			sb.append(1);
			map.put(root.right.val, sb.toString());
			helper(root.right);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	public static void main(String[] args)
	{
		TreeNode t3 = new TreeNode(3);
		TreeNode t2 = new TreeNode(2);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t1 = new TreeNode(1);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t3.left = t2;
		t3.right = t4;
		t2.left = t5;
		t2.right = t1;
		t4.left = t6;
		t4.right = t7;
		
		BinaryTreePathMin2Max main = new BinaryTreePathMin2Max();
		System.out.println(main.pathLength(t3));
		for (Entry<Integer, String> entry : map.entrySet())
		{
			System.out.println(entry);
		}
		
	}
}
