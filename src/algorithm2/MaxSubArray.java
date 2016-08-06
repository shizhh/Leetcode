package algorithm2;

/**
 * Created by szh on 16/8/5.
 */
public class MaxSubArray {

    /**
     * 求数组的最大子段和
     * */
    public static int maxSubArray(int[] nums){
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int localMax=nums[0];
        int globalMax=nums[0];
        for(int i=1; i<nums.length; i++){
            localMax=Math.max(localMax+nums[i], nums[i]);
            globalMax=Math.max(globalMax, localMax);
        }
        return globalMax;
    }

    /**
     * 给定一个数组，我们可以找到两个不相交的、并且是连续的子数组A和B，
     * A中的数字和为sum(A), B中的元素和为sum(B)。
     * 找到这样的A和B，满足sum(A) - sum(B)的绝对值是最大的。
     * */
    public static int maxSubtractTwoSubArray(int[] nums){
        int n = nums.length;

        int[] maxLeft = new int[n];
        int[] minLeft = new int[n];
        int localMax=nums[0];
        int localMin=nums[0];
        maxLeft[0]=nums[0];
        minLeft[0]=nums[0];
        for(int i=1; i<n; i++){
            localMax=Math.max(localMax+nums[i], nums[i]);
            maxLeft[i]=Math.max(maxLeft[i-1], localMax);

            localMin=Math.min(localMin+nums[i], nums[i]);
            minLeft[i]=Math.min(minLeft[i-1], localMin);
        }

        int[] maxRight = new int[n];
        int[] minRight = new int[n];
        localMax=nums[n-1];
        localMin=nums[n-1];
        for(int i=n-2; i>=0; i--){
            localMax=Math.max(localMax+nums[i], nums[i]);
            maxRight[i]=Math.max(maxRight[i+1], localMax);

            localMin=Math.min(localMin+nums[i], nums[i]);
            minRight[i]=Math.min(minRight[i+1], localMin);
        }

        int result=Integer.MIN_VALUE;
        for(int i=1; i<n; i++){
            result=Math.max(result, maxLeft[i-1]-minRight[i]);
            result=Math.max(result, maxRight[i]-minLeft[i-1]);
        }

        return result;
    }
    public static void main(String[] args){
        int[] nums = {2, -1, -2, 1, -4, 2, 8};
        int res = maxSubArray(nums);
        System.out.println(res);

        res = maxSubtractTwoSubArray(nums);
        System.out.println(res);
    }
}
