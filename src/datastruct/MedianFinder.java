package datastruct;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by zhenhui on 2016/5/27.
 */
public class MedianFinder
{
    public PriorityQueue<Integer> minheap, maxheap;
    public MedianFinder()
    {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>();
    }

    public void addNum(int num)
    {
        minheap.add(num);
        maxheap.add(-minheap.poll());
        if (minheap.size() < maxheap.size()) minheap.add(-maxheap.poll());
    }

    public float findMedian()
    {
        return minheap.size() > maxheap.size() ? (float)minheap.peek() : (minheap.peek()-maxheap.peek())/2.0f;
    }

    public static void main(String[] args)
    {
//        MedianFinder medianFinder = new MedianFinder();
//        medianFinder.addNum(1);
//        medianFinder.addNum(2);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(3);
//        System.out.println(medianFinder.findMedian());
        System.out.println(7 & -7);
    }
}
