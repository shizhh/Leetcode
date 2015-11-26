package algorithm;

public class TrappingRainWater {

	public static int trap(int[] height) {
        
		int len = height.length;
		if (len <= 2)	return 0;
		int result = 0;
		
		int[] container = new int[len];
		int max = 0;
		// ´Ó×óÍùÓÒ±éÀú
		for (int i = 0; i < len; i++) {
			max = max < height[i] ? height[i] : max;
			container[i] = max;
		}
		print(container);
		max = 0;
		// ´ÓÓÒÍù×ó±éÀú
		for (int i = len - 1; i >= 0; i--) {
			container[i] = max > container[i] ? container[i] : max;
			max = height[i] > max ? height[i] : max;
			result += container[i] - height[i] > 0 ? container[i] - height[i] : 0;
		}
		print(container);
		return result;
    }
	
	public static void print(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		int res = trap(height);
		System.out.println(res);
	}

}
