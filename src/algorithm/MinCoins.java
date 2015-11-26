package algorithm;

import java.util.*;

public class MinCoins {
	
	public void charge(int[] values, int valueKinds, int money, int[] coinsUsed, int[] trace) {  
		
		//Map<Integer, List<Integer>> map = new HashMap<>();
		
		coinsUsed[0] = 0;
		
		for (int i = 1; i <= money; i++) {
			
			int minCoins = money;
			
			for (int j = 0; j < valueKinds; j++) {
				if (values[j] <= i) {
					int tempCoins = coinsUsed[ i-values[j] ] + 1;
//					minCoins = tempCoins < minCoins ? tempCoins : minCoins;
					if (tempCoins < minCoins) {
						minCoins = tempCoins;
//						List list = map.get(i-values[j]);
//						if (list == null) {
//							list = new ArrayList();
//						}
//						List list2 = new ArrayList(list);
//						list2.add(values[j]);
//						map.put(i, list2);
						trace[i] = values[j];
					}
				}
			}
			coinsUsed[i] = minCoins;
		}
		//System.out.println(map.get(money).toString());
		
    } 
	
	public void print(int money, int[] trace) {
		while (money > 0) {
			System.out.println(trace[money]);
			money -= trace[money];
		}
	}
      
    public static void main(String[] args) {
    	
    	MinCoins main = new MinCoins();
    	
//    	int[] values = {1, 5, 10, 20, 50, 100};
    	int[] values = {100, 50, 20, 10, 5, 1};
    	int valueKinds = values.length;
    	int money = 799;
    	int[] coinsUsed = new int[money + 1];
    	int[] trace = new int[money+1];
    	
    	main.charge(values, valueKinds, money, coinsUsed, trace);
    	
//    	for (int i=0; i<money+1; i++) {
//    		System.out.println(i + "零钱需要 " + coinsUsed[i] +" 个硬币");
//    	}
    	System.out.println(money + " 零钱需要 " + coinsUsed[money] +" 个硬币");
    	
    	main.print(money, trace);
    	//System.out.println(map.get(money));
//    	for (int i=1;i<=coinsUsed[money];i++){
//    		System.out.println(trace[i]);
//    	}
    }
	
}
