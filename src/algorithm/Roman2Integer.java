package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by szh on 16/4/19.
 */
public class Roman2Integer {
    private Map<Character, Integer> map =
            new HashMap<Character, Integer>() {{
                put('I', 1); put('V', 5); put('X', 10);
                put('L', 50); put('C', 100); put('D', 500);
                put('M', 1000);
            }};

    public int roman2Integer(String s) {
        int prev = 0, total = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            int curr = map.get(s.charAt(i));
            if (curr >= prev)
                total += curr;
            else total -= curr;
            prev = curr;
        }
        return total;
    }
}
