package algorithm;

public class PlusOne {

	public int[] plusOne(int[] digits) {
		int len = digits.length;
		int tag = 0;
		int tmp = digits[len - 1] + 1;
		if (tmp == 10) {
			tag = 1;
			digits[len - 1] = 0;
		} else {
			digits[len - 1] = tmp;
		}
		for (int i = len - 2; i >= 0; --i) {
			tmp = digits[i] + tag;
			if (tmp == 10) {
				tag = 1;
				digits[i] = 0;
			} else {
				tag = 0;
				digits[i] = tmp;
			}
		}
		if (tag == 1) {
			int[] newdigits = new int[len + 1];
			for (int j = len; j > 0; --j) {
				newdigits[j] = digits[j - 1];
			}
			newdigits[0] = 1;
			return newdigits;
		}
		return digits;
	}

	//
	public static void main(String[] args) {
		PlusOne po = new PlusOne();
		int[] digits = { 9, 9, 9, 9, 9, 9 };
		int[] result = po.plusOne(digits);
		for (int i = 0, len = result.length; i < len; ++i) {
			System.out.print(result[i] + " ");
		}
	}
}
