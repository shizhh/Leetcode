package algorithm;

public class MinCoins {
	
	/**
	 * @param trace 记录最后一个硬币的面值
	 * 
	 * */
	public static void makeChange(int[] values, int valueKinds, int money,  int[] coinsUsed, int[] trace) {  
 
        coinsUsed[0] = 0;  
        // 对每一分钱都找零，即保存子问题的解以备用，即填表  
        for (int cents = 1; cents <= money; cents++) {  
 
            // 当用最小币值的硬币找零时，所需硬币数量最多 
            int minCoins = cents;
 
            // 遍历每一种面值的硬币，看是否可作为找零的其中之一  
            for (int kind = 0; kind < valueKinds; kind++) {               
                // 若当前面值的硬币小于当前的cents则分解问题并查表  
                if (values[kind] <= cents) {  
                    int temp = coinsUsed[cents - values[kind]] + 1;  
                    if (temp < minCoins) {  
                        minCoins = temp;  
                        trace[cents] = values[kind];
                    }  
                }  
            }  
            // 保存最小硬币数  
            coinsUsed[cents] = minCoins;  
 
//            System.out.println("面值为 " + (cents) + " 的最小硬币数 : " + coinsUsed[cents]);  
        }  
    }  
      
	private static void print(int money, int[] trace) {
		while (money >= 0) {
			System.out.print(trace[money] + " ");
			money -= trace[money];
		}
	}
	
    public static void main(String[] args) {  
 
    	
    	
    	
        // 硬币面值预先已经按降序排列  
//        int[] coinValue = new int[] {1,5,10,20,50,100};
        
//        int[] coinValue = new int[] {100,50,20,10,5,1};
        
        int[] coinValue = new int[] {50,10,1,5,20,100};
        
        // 需要找零的面值  
        int money = 19;  
        // 保存每一个面值找零所需的最小硬币数，0号单元舍弃不用，所以要多加1  
        int[] coinsUsed = new int[money + 1];  
        
        int[] trace = new int[money + 1];
        
        makeChange(coinValue, coinValue.length, money, coinsUsed, trace);  
        
        System.out.println("面值为 " + (money) + " 的最小硬币数 : " + coinsUsed[money]);  
        
//        print(money, trace);
    }
	
}
