package algorithm;


public class HouseRobber
{
    public int rob(int[] nums)
    {
    	int len = nums.length;
//        int[] money = new int[len];
//        money[0] = nums[0];
//        money[1] = Math.max(money[0], nums[1]);
        int maxRobbedMoney = 0;
        int preMaxRobbedMoney = 0;
//        for (int i = 2; i < len; i++)
//        {
//        	money[i] = Math.max(money[i-1], money[i-2]+nums[i]);
//        }
        for (int i = 0; i < len; i++)
        {
        	int t = maxRobbedMoney;
        	maxRobbedMoney = Math.max(preMaxRobbedMoney+nums[i], maxRobbedMoney);
        	preMaxRobbedMoney = maxRobbedMoney;
        }
//        return money[len-1];
        return maxRobbedMoney;
    }
    
}
