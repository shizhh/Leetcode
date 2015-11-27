package algorithm;


public class TrappingRainWater {

	public static int trap(int[] height) {
        
		int len = height.length;
		if (len <= 2)	return 0;
		int result = 0;
		
		int[] container = new int[len];
		int max = 0;
		// 从左往右遍历
		for (int i = 0; i < len; i++) {
			max = max < height[i] ? height[i] : max;
			container[i] = max;
		}
		print(container);
		max = height[len - 1];
		// 从右往左遍历
		for (int i = len - 1; i >= 0; i--) {
			container[i] = max > container[i] ? container[i] : max;
			max = height[i] > max ? height[i] : max;
			result += container[i] - height[i] > 0 ? container[i] - height[i] : 0;
		}
		print(container);
		return result;
    }
	
	public static int trap2(int[] height) {
		int max = 0;
		int index = 0;
		int res = 0;
		for (int i = 0; i < height.length; i++) {
			if (height[i] > max) {
				max = height[i];
				index = i;
			}
		}
		
		int leftMax = height[0];
		for (int i = 1; i < index; i++) {
			if (leftMax > height[i]) {
				res += leftMax - height[i];
			}else if (leftMax < height[i]){
				leftMax = height[i];
			}
		}
		int rightMax = height[height.length - 1];
		for (int i = height.length - 2; i > index; i--) {
			if (rightMax > height[i]) {
				res += rightMax - height[i];
			}else if (rightMax < height[i]){
				rightMax = height[i];
			}
		}
		
		return res;
	}
	
	public static int trap3(int[] height) {
		if (height.length <= 2) 
			return 0;
		int res = 0;
		int i = 0;
		int j = height.length - 1;
		int curMax = 0;
		while (i < j) {
			if (height[i] < height[j]) {
				curMax = i;
				i++;
				while (height[i] < height[curMax]) {
					res += height[curMax] - height[i];
					i++;
				}
			}else {
				curMax = j;
				j--;
				while (height[j] < height[curMax]) {
					res += height[curMax] - height[j];
					j--;
				}
			}
		}
		
		return res;
	}
	
	
	public static void print(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {0,2,0,2,1,0,1,3,2,1,2,1};
		int res = trap3(height);
		System.out.println(res);
	}

}
