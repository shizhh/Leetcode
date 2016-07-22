package algorithm;

import java.util.*;

/**
 * Created by zhenhui on 2016/7/22.
 */
public class DifferentWaysAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        //int i = 0;
        List<Integer> res = helper(input);

        return res;
    }

    public List<Integer> helper(String input) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int n = input.length();
        while (i < n) {
            //int j=i;
            while (i < n && Character.isDigit(input.charAt(i))) i++;
            if(i==n) break;
            String s1 = input.substring(0, i);
            String s2 = input.substring(i + 1);
            char operator = input.charAt(i);
            List<Integer> list1 = helper(s1);
            List<Integer> list2 = helper(s2);
            if (operator == '+') {
                for (int i1 : list1) {
                    for (int i2 : list2) {
                        res.add(i1 + i2);
                    }
                }
            } else if (operator == '-') {
                for (int i1 : list1) {
                    for (int i2 : list2) {
                        res.add(i1 - i2);
                    }
                }
            } else {
                for (int i1 : list1) {
                    for (int i2 : list2) {
                        res.add(i1 * i2);
                    }
                }
            }
            i++;
        }
        if(res.isEmpty()) res.add(Integer.parseInt(input));
        return res;
    }

    public static void main(String[] args) {
        DifferentWaysAddParentheses main = new DifferentWaysAddParentheses();
        System.out.println(main.diffWaysToCompute("2*3-4*5"));
    }
}
