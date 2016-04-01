package algorithm2;

public class Solution1 {
	static StringBuffer temp = new StringBuffer();
	static char[] carr = { '\0', '9', 'g' };

	public static void dfs(int step, String str) {
		if (step == str.length()) {
			System.out.println(temp.toString());
			// temp.delete(0, temp.length());
			return;
		}
		for (int i = 0; i < 3; i++) {
			char ch = str.charAt(step);

			if (ch != '9' && ch != 'g') {
				temp.append(ch);
				dfs(step + 1, str);
				return;

			} else {
				if (i == 0) {
					i++;
					temp.append(carr[i]);
				} else {
					temp.append(carr[i]);

				}
				dfs(step + 1, str);
				temp.delete(step, temp.length());
			}
		}
	}

	public static void main(String[] args) {
		String string = "99XXXXg";
		dfs(0, string);
	}
}