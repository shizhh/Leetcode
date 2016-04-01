package algorithm;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3
{
	
	public List<List<Integer>> combinationSum3_1(int k, int n) {
	    List<List<Integer>> ans = new ArrayList<>();
	    combination(ans, new ArrayList<Integer>(), k, 1, n);
	    return ans;
	}

	private void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
	    if (comb.size() == k && n == 0) {
	        List<Integer> li = new ArrayList<Integer>(comb);
	        ans.add(li);
	        return;
	    }
	    for (int i = start; i <= 9; i++) {
	        comb.add(i);
	        combination(ans, comb, k, i+1, n-i);
	        comb.remove(comb.size() - 1);
	    }
	}
	
	
	public List<List<Integer>> combinationSum3(int k, int n)
	{
		List<List<Integer>> result = new ArrayList<>();
		
		List<Integer> temp = new ArrayList<>();
		
		helper(k, n, 1, 0, temp, result);
		
		return result;
	}
	
	public void helper(int k, int n, int start, int sum, List<Integer> temp, List<List<Integer>> res)
	{
		if (sum == n && temp.size() == k)
		{
			res.add(new ArrayList<>(temp));
			return;
		}
		else if (sum > n || temp.size() > k)
		{
			return;
		}
		else 
		{
			for (int i = start; i < 10; i++)
			{
				temp.add(i);
				helper(k, n, i+1, sum+i, temp, res);
				temp.remove(temp.size()-1);
			}
		}
		
	}
	
	public static void main(String[] args)
	{
		CombinationSum3 main = new CombinationSum3();
		System.out.println(main.combinationSum3(3, 9));
	}
	
}
