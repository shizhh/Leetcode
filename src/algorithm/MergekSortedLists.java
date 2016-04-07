package algorithm;

import bean.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by szh on 16/4/7.
 */
public class MergekSortedLists {

    private static Comparator<ListNode> listNodeComparator = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    };

    public ListNode mergeKLists(List<ListNode> lists) {

        if (lists.isEmpty()) return null;
        // 优先队列,最小堆结构
        Queue<ListNode> queue = new PriorityQueue<>(lists.size(), listNodeComparator);
        // 初始化
        for (ListNode node : lists) {
            if (node != null) queue.offer(node);
        }
        ListNode dummyNode = new ListNode(0);
        ListNode p = dummyNode;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();   // 取出最小的结点
            p.next = node;
            p = p.next;
            if (node.next != null) queue.offer(node.next);
        }
        return dummyNode.next;
    }
}
