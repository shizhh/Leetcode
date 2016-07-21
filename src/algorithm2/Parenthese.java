package algorithm2;

import java.util.Scanner;

/**
 * Created by szh on 16/7/9.
 */
public class Parenthese {

    public int solve(char[] s, int[] aid){
        int n=s.length;
        int res=0;
        int count_value=0;
        int minValue=aid[0];
        for (int i=0; i<n; i++){
            if('('==s[i]){
                count_value++;
            }
            else{
                if(0==count_value){
                    res+=minValue;
                }else {
                    count_value--;
                }
            }
            minValue=Math.min(minValue, aid[i+1]);
        }
        count_value=0;
        minValue=aid[n];
        for(int i=n-1; i>=0; i--){
            if(')'==s[i]){
                count_value++;
            }else{
                if(count_value==0){
                    res+=minValue;
                }else{
                    count_value--;
                }
            }
            minValue=Math.min(minValue, aid[i]);
        }
        return res;
    }
    public void run(){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int i = 0;
        while(i<n){
            i++;
            char[] s = in.nextLine().toCharArray();
            String[] temp=in.nextLine().split(" ");
            int aid[] = new int[s.length+1];
            for(int j=0; j <=s.length; j++){
                aid[j]=Integer.parseInt(temp[j]);
                //aid[j]=in.nextInt();
                //System.out.println(aid[j]);
            }
            int res = solve(s, aid);
            System.out.println(res);
        }
    }
    public static void main(String[] args){
        /**
         * input format
         * 1
         * ((((
         * 2 3 4 5 6
         * */
        Parenthese main = new Parenthese();
        main.run();

    }
}
