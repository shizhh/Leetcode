package algorithm;

import java.util.ArrayList;
import java.util.List;

import bean.Interval;

public class InsertInterval {
	
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	int i=0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start) i++;
        while(i<intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
            intervals.remove(i);
        }
        intervals.add(i,newInterval);
        return intervals;
    }
    
    public static void main(String[] args) {
    	List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 4));
		intervals.add(new Interval(5, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));
		Interval newInterval = new Interval(4, 9);
		System.out.println(intervals);
		List<Interval> res = insert(intervals, newInterval);
		System.out.println(res);
    }
}
