package algorithm;

/**
 * Created by szh on 16/6/14.
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num){
        for (int i=1; i<=num.length()/2; i++){
            for (int j=1; j<=(num.length()-i)/2; j++){
                if (check(num.substring(0,i), num.substring(i, i+j), num.substring(i+j))) return true;
            }
        }
        return false;
    }
    private String add(String a, String b){
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1, j=b.length()-1, carry=0;
        while (i >= 0 || j >= 0 || carry > 0){
            int sum = carry + (i >= 0 ? a.charAt(i)-'0' : 0) + (j >= 0 ? b.charAt(j)-'0' : 0);
            sb.insert(0, sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return sb.toString();
    }

    private boolean check(String a, String b, String c){
        if (a.length()>1 && a.charAt(0)=='0' || b.length()>1 && b.charAt(0)=='0') return false;
        String sum = add(a, b);
        if (sum.equals(c)) return true;
        if (c.length() < sum.length() || !c.substring(0, sum.length()).equals(sum)) return false;
        return check(b, sum, c.substring(sum.length()));
    }

    public static void main(String[] args) {
        String num = "101";
        System.out.println(new AdditiveNumber().isAdditiveNumber(num));
    }
}
