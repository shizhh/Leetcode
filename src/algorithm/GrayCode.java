package algorithm;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	public static List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<>();
		if (n < 0)
			return res;
		res.add(0);
		for (int i = 0; i < n; i++) {
			// compute(i, res);
			int size = res.size();
			for (int j = size - 1; j >= 0; j--) {
				res.add(res.get(j) + (1 << i));
			}
		}
		return res;
	}

	/**
	 * 我们来看看有了n-1位的格雷码如何得到n位的格雷码呢？其实方法比较简单，首先在n-1位的格雷码前面都添加0作为前2^(n-1)个格雷码，
	 * 它们一定是合法的因为除了第一位（都是0）其余位都跟n-1的格雷码一致，所以两两之间只相差一位，满足要求。接下来看看如何接上剩下的2^(n-1)个，
	 * 我们把n-1位的格雷码倒序排列，然后在每个前面添加1，然后接到上述的前2^(n-1)个就可以了。首先因为是倒序过来，
	 * 所以中间两个元素除去第一位其他都是一样的（因为原来最后一个，现在倒序过来就是第一个），而他们第一位分别是0和1，满足格雷码的要求。
	 * 而剩下的元素因为我们是n-1位的格雷码倒序排列，所以两两都是满足要求的，加上前面都一样的位1，仍然满足条件。最后看看这些数字是不是都不一样，
	 * 前半部分和后半部分肯定不会一样，而因为前半部分都是0开头，后半部分都是1打头，所以互相之间也不会有重复，可以看出覆盖了所有数字，
	 * 而且依次下来均满足条件。
	 */
	public static void compute(int n, List<Integer> list) {
		int num = 1 << (n - 1);
		int size = list.size();
		for (int i = size - 1; i >= 0; i--) {
			int val = list.get(i);
			list.add(val + num);
		}
	}

	public static void main(String[] args) {
		int n = 2;
		System.out.println(grayCode(n));
	}

}
