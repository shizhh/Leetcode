package algorithm;

/**
 * Created by szh on 16/4/19.
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Integer2Roman {

    private static final int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4,
            1
    };
    private static final String[] symbols = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV",
            "I"
    };

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        int i = 0;
        while (num > 0) {
            int k = num / values[i];
            for (int j = 0; j < k; j++) {
                roman.append(symbols[i]);
                num -= values[i];
            }
            i++;
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        Integer2Roman integer2Roman = new Integer2Roman();
        System.out.println(integer2Roman.intToRoman(800));
    }

}
