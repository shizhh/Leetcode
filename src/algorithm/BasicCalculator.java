package algorithm;

import java.util.*;

/**
 * Created by zhenhui on 2016/6/15.
 */
public class BasicCalculator {
    public int calculate(String s){
        Stack<Integer> stack = new Stack<>();
        //s = clean(s);
        int result = 0;
        int sigh = 1;
        int i = 0;
        while (i < s.length()){
            char ch = s.charAt(i);
            if (Character.isDigit(ch)){
                int j = i+1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) j++;
                int value = Integer.parseInt(s.substring(i, j));
                result += value * sigh;
                i=j-1;
            }else if(ch == '+'){
                sigh = 1;
            }else if(ch == '-'){
                sigh = -1;
            }else if(ch == '('){
                stack.push(result);
                stack.push(sigh);
                result = 0;
                sigh = 1;
            }else if(ch == ')'){
                result = result * stack.pop() + stack.pop();
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args){
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(new BasicCalculator().calculate(s));
    }
}
