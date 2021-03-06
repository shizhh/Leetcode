package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum main = new CombinationSum();
		int[] candidates = {2,2,3,6,7};
		int target = 4;
		List<List<Integer>> res = main.combinationSum(candidates, target);
		System.out.println(res);
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		if(candidates.length == 0 || candidates == null)
			return res;
		Arrays.sort(candidates);
		combinate(candidates, target, 0, list, res);
		return res;
	}
	
	public void combinate(int[] candidates, int target, int start, List<Integer> temp, List<List<Integer>> res) {
		if(target == 0){
			res.add(new ArrayList<>(temp));
			return;
		}
		else if(target < 0)
			return;
		else {
			for (int i = start; i < candidates.length; i++){
				if(i>0 && candidates[i]==candidates[i-1])
					continue;
				temp.add(candidates[i]);
				combinate(candidates, target-candidates[i], i, temp, res);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
