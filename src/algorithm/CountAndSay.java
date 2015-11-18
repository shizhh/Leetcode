package algorithm;

public class CountAndSay {

	public String countAndSay(int n) {
		if (n < 1)
			return "";
		String str = "1";
		while (n > 1) {
			str = countAndSayOne(str);
			n--;
		}
		System.out.println(str);
		return str;
	}
	private String countAndSayOne(String str) {
		char tmp = str.charAt(0);
		int num = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 1, len = str.length(); i < len; ++i) {
			if (tmp == str.charAt(i)) {
				num++;
				continue;
			}
			sb.append(String.valueOf(num) + tmp);
			tmp = str.charAt(i);
			num = 1;
		}
		// 最后一步
		sb.append(String.valueOf(num) + tmp);
		return sb.toString();
	}
	//
//	public static void main(String[] args) {
//		CountAndSay cas = new CountAndSay();
//		cas.countAndSay(1);
//		cas.countAndSay(2);
//		cas.countAndSay(3);
//		cas.countAndSay(4);
//		cas.countAndSay(5);
//		cas.countAndSay(6);
//	}
}
