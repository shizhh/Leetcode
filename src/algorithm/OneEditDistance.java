package algorithm;

/**
 * Created by zhenhui on 2016/4/6.
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t){
        int m = s.length(), n = t.length();
        if (m > n)  return isOneEditDistance(t, s);
        if ( n - m > 1) return false;
        int shift = n - m;
        int i = 0;
        while (i < m && s.charAt(i) == t.charAt(i)) i++;
        if (i == m) return shift > 0;   // s = abc, t = abcx
        if (shift == 0) i++;            // s = abc, t = axc
        while (i < m && s.charAt(i) == t.charAt(i+shift)) i++;  // s = abc, t = abxc
        return i == m;
    }
}
