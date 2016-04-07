package algorithm2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by zhenhui on 2016/4/7.
 */
public class IPMatcher {
    public static void main(String[] args) {
        IPMatcher ipMatcher = new IPMatcher();
//        System.out.println(ipMatcher.ip2int32("127.0.0.1"));
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int m = Integer.parseInt(line.split(" ")[0]);
        int n = Integer.parseInt(line.split(" ")[1]);
        Map<Long, Integer> ip2pry = new HashMap<>();
        Map<Integer, String> pry2rule = new HashMap<>();

        for (int i = 0; i < m; ++i) {
            String s = in.nextLine();
            String[] str = s.split(" ");
            String isAllow = str[0];
            String ipmask = str[1];
            pry2rule.put(i, isAllow);
            String[] str2 = ipmask.split("/");
            long key = 0L;
            if (str2.length > 1) {
                int b = Integer.parseInt(str2[1]);
                key = ((ipMatcher.ip2int32(str2[0]) >>> (32 - b)) << 6) + b;
                if (!ip2pry.containsKey(key))
                    ip2pry.put(key, i);
            } else {
                key = (ipMatcher.ip2int32(str2[0]) << 6) + 32;
                if (!ip2pry.containsKey(key))
                    ip2pry.put(key, i);
            }
        }

//        System.out.println(ip2pry);

        for (int i = 0; i < n; ++i) {
            long ip = ipMatcher.ip2int32(in.nextLine());
            int priority = m;
            for ( int j = 0; j <= 32; ++j) {
                long iptmp = ((ip >>> j) << 6) + 32-j;
                if (ip2pry.containsKey(iptmp)) {
                    priority = Math.min(ip2pry.get(iptmp), priority);
                }
            }
            if (priority == m) System.out.println("YES");
            else {
                String isAllowed = pry2rule.get(priority);
                if (isAllowed.equals("allow"))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }

    private long ip2int32(String ip) {
        String[] ips = ip.split("\\.");
        long result = 0;
        int shift = 8;
        for (int i = ips.length - 1; i >= 0; --i) {
            result += Long.parseLong(ips[i]) << (shift * (3 - i));
        }
        return result;
    }

}
