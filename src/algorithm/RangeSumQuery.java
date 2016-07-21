package algorithm;

/**
 * Created by szh on 16/6/14.
 */
public class RangeSumQuery {
    class SegmentTreeNode{
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    SegmentTreeNode root = null;

    public SegmentTreeNode buildTree(int[] nums, int start, int end){
        if (start > end) return null;

        SegmentTreeNode ret = new SegmentTreeNode(start, end);
        if (start == end) ret.sum = nums[start];
        else{
            int mid = start + (end-start)/2;
            ret.left = buildTree(nums, start, mid);
            ret.right = buildTree(nums, mid+1, end);
            ret.sum = ret.left.sum + ret.right.sum;
        }
        return ret;
    }

    public RangeSumQuery(int[] nums){
        root = buildTree(nums, 0, nums.length-1);
    }

    void update(SegmentTreeNode root, int pos, int val){
        if (root.start == root.end) root.sum = val;
        else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {
                update(root.left, pos, val);
            } else {
                update(root.right, pos, val);
            }
            root.sum = root.left.sum+root.right.sum;
        }
    }

    void update(int i, int val){
        update(root, i, val);
    }

    public int sumRange(SegmentTreeNode root, int i, int j){
        if (root.start == i && root.end == j) return root.sum;
        else{
            int mid = root.start + (root.end-root.start)/2;
            if (j <= mid){
                return sumRange(root.left, i, j);
            }else if (i >= mid+1){
                return sumRange(root.right, i, j);
            }else{
                return sumRange(root.left, i, mid) + sumRange(root.right, mid+1, j);
            }
        }
    }

    public int sumRange(int i, int j){
        return sumRange(root, i, j);
    }
}
