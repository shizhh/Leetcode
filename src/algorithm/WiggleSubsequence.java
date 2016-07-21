package algorithm;

/**
 * Created by zhenhui on 2016/7/21.
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        int count=0;
        int sign=0;
        for(int i=1; i<n; i++){
            int diff=nums[i]-nums[i-1];
            if(diff>0){
                if(diff * sign <= 0){
                    count++;
                    sign=1;
                }

            }
            else if(diff < 0){
                if (diff * sign <= 0){
                    count++;
                    sign=-1;
                }
            }
            else{

            }
        }
        return count+1;
    }
}
