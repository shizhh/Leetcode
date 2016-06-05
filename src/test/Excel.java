package test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by szh on 16/4/21.
 */
public class Excel {
    public static void main(String[] args) {
        Excel main = new Excel();
        Scanner in = new Scanner(System.in);
        long n = Long.parseLong(in.nextLine());
        long i = 0;
        Pattern pattern = Pattern.compile("^R[1-9]\\d+C[1-9]\\d+$");
        while (i < n) {
            i++;
            String line = in.nextLine().trim();
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String[] str = line.substring(1).split("C");
//                long n1 = Long.parseInt(str[0]);
                long c = Long.parseLong(str[1]);
                String cstr = main.num2title(c);
                System.out.println(cstr+str[0]);
            }
            else {  // RD34
                int j = 0;
                while (j < line.length() && !Character.isDigit(line.charAt(j))) j++;
                String str = line.substring(0, j);
                long c = main.title2num(str);
                String r = line.substring(j);
                System.out.println("R"+r+"C"+c);
            }
        }
    }


    public String num2title(long num) {
        StringBuilder sb = new StringBuilder();

        long q = (num-1) / 26;
        long r = (num-1) % 26;

        while (q > 0)
        {
            sb.insert(0, (char)(r+'A'));
            num = q;
            q = (num-1) / 26;
            r = (num-1) % 26;
        }

        sb.insert(0, (char)(r+'A'));
        return sb.toString();
    }

    public long title2num(String title) {
        long result = 0;
        long len = title.length();
        for (int i = 0; i <= len-1; i++)
        {
            result = result * 26 + (title.charAt(i)-'A'+1);
        }
        return result;
    }
}
