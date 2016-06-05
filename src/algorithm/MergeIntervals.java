package algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import bean.Interval;

public class MergeIntervals {


	private static Comparator<Interval> intervalComparator = new Comparator<Interval>() {
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}
	};

	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		int n = intervals.size();
		if (n < 1)
			return res;
		Collections.sort(intervals, intervalComparator);
		Interval intv = intervals.get(0);
		for (int i = 1; i < n; i++) {
			Interval intv2 = intervals.get(i);
			if (intv.end >= intv2.start) {
				intv.end = intv.end > intv2.end ? intv.end : intv2.end;
			}
			else {
				res.add(new Interval(intv.start, intv.end));
				intv = intv2;
			}
		}
		res.add(intv);
		return res;
	}
	
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(10, 18));
		System.out.println(intervals);
		List<Interval> res = merge(intervals);
		System.out.println(res);
	}
	
}



//class IntervalComparator implements Comparator {
//
//	@Override
//	public int compare(Object o1, Object o2) {
//		Interval i1 = (Interval) o1;
//		Interval i2 = (Interval) o2;
//
//		return i1.start - i2.start;
//	}
//
//}
