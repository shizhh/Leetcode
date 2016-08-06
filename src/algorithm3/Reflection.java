package algorithm3;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by szh on 16/8/6.
 */
public class Reflection {
    public static boolean isReflected(int[][] points){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        HashMap<Integer, HashSet<Integer>> hashMap = new HashMap<>();
        for(int i=0; i<points.length; i++){
            min=Math.min(min, points[i][0]);
            max=Math.max(max, points[i][0]);
            if(!hashMap.containsKey(points[i][1])){
                HashSet<Integer> set = new HashSet<>();
                set.add(points[i][0]);
                hashMap.put(points[i][1], set);
            }
            else{
                hashMap.get(points[i][1]).add(points[i][0]);
            }
        }
        /*
        * max-y0=y0-min
        * p-y0=y0-p'
        * => p'=max+min-p
        * */
        for(int i=0; i<points.length; i++){
            if(!hashMap.containsKey(points[i][1])
                    || !hashMap.get(points[i][1]).contains(max+min-points[i][0])){
               return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[][] points = {
                {-2, 3},
                {-1, 2},
                {-1, 1},
                {1, 1},
                {1, 2},
                {2, 3}
        };
        System.out.println(isReflected(points));
    }
}
