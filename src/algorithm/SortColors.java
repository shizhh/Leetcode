package algorithm;

public class SortColors {
	
	public static void sortColors2(int[] nums) {
		
	}
	
	private static void exch(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
    public static void sortColors(int[] nums) {
        int[] count = new int[4];
        int[] aux = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
        	count[nums[i]+1]++;
        }
        for (int i = 0; i < count.length - 1; i++) {
        	count[i+1] += count[i];
        }
        for (int i = 0; i < nums.length; i++) {
        	aux[count[nums[i]]] = nums[i];
        	count[nums[i]]++;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = aux[i];
        }
    }

    public static void sortColors3(int[] nums) {
        int[] count = new int[3];
        
        for (int i = 0; i < nums.length; i++) {
        	count[nums[i]]++;
        }
        
        int j = 0;
        for (int i = 0; i < 3; i++) {
        	while (count[i] > 0) {
        		nums[j++] = i;
        		count[i]--;
        	}
        }
    }
    
    public static void sortColors4(int[] nums) {
    	int i = 0;
    	int j = nums.length - 1;
    	for (int k = 0; k < nums.length; k++) {
    		while (nums[k] == 2 && k < j) {
    			exch(nums, k, j);
    			j--;
    		}
    		while (nums[k] == 0 && k > i) {
    			exch(nums, i, k);
    			i++;
    		}
    	}
    }
    
    /**
     * 计数排序
     * @param R 数组中最大的元素
     */
    public static void sort(int[] nums, int R) {
        int[] count = new int[R+2];
        int[] aux = new int[nums.length];
        // 计算出现的频率
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] + 1]++;
        }
        // 将频率转化为索引
        for (int i = 0; i < count.length - 1; i++) {
            count[i + 1] += count[i];
        }
        // 将元素分类
        for (int i = 0; i < nums.length; i++) {
            aux[count[nums[i]]] = nums[i];
            count[nums[i]]++;
        }
        // 写回
        for (int i = 0; i < nums.length; i++) {
            nums[i] = aux[i];
        }
    }
    
    public static void main(String[] args) {
    	int[] nums = {1, 2,0,2,1,0,1,1,1};
    	sortColors4(nums);
    	for (int i = 0; i < nums.length; i++) {
    		System.out.print(nums[i] + " ");
    	}
    }
}
