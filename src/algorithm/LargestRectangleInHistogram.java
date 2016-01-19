package algorithm;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
	
	public static int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[heights.length + 1];
        h = Arrays.copyOf(heights, heights.length + 1);
        while(i < h.length){
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i++);
            }else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
	}
	
	public static int largestRectangleArea3(int[] heights){
		int n = heights.length;
		Stack<Integer> s = new Stack<>();
		int max_area = -1;
		int[] h = Arrays.copyOf(heights, n+1);	//h[n]=0
		int i=0;
		while(i < h.length){
			if (s.isEmpty() || h[i] >= h[s.peek()]){
				s.push(i++);
			}
			else{
				int top = s.pop();
				int area = h[top]*(s.isEmpty() ? i : i-1-s.peek());
				max_area = Math.max(area, max_area);
			}
		}
		return max_area;
	}
	
	public static int largestRectangleArea2(int[] heights) {
		int min;
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
        	min = heights[i];
            for(int j = i; j < heights.length; j++){
                if(i == j) ;
                else {
                    if(heights[j] < min) {
                        min = heights[j];
                    }
                }
                int tentativeArea = min * (j - i + 1);
                if(tentativeArea > maxArea) {
                    maxArea = tentativeArea;
                }
            }
        }
        return maxArea;
	}
	
	public static void main(String[] args) {
		int[] heights = {2,1,5,6,2,4};
		int maxArea = largestRectangleArea3(heights);
		System.out.println(maxArea);
	}
}
