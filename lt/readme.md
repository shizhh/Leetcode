From: https://labuladong.gitbook.io/
***
* 双指针技巧
    * 快慢指针
    主要解决链表中的问题。
        * 判断链表是否有环
        * 返回环的起始位置
        * 链表的中点
        * 链表中倒数第k个节点
        * ...
    * 左右指针
    主要解决数组或字符串中的问题。
        * 二分查找
        * 两数之和
        * 反转数组
        * 滑动窗口算法
        * ...

***
* 回溯法
    * 思路
    解决一个回溯问题，实际上就是一个决策树的遍历过程。
        ```
        result = []
        def backtrack(路径, 选择列表):
        if 满足结束条件:
            result.add(路径)
            return

        for 选择 in 选择列表:
            做选择
            backtrack(路径, 选择列表)
            撤销选择
        ```
        其核心就是 for 循环里面的递归，在递归调用 之前「做选择」，在递归调用之后「撤销选择]。  
    * 经典问题
        * 全排列问题
        * N皇后问题
        * 数独问题
        * ...
    * 总结
        回溯算法是多叉树的遍历问题，关键就是在前序遍历和后序遍历的位置做一些操作。
        
* 二分查找
    * 框架
    
        ```
        int binarySearch(int[] nums, int target) {
            int left = 0, right = ...;

            while(...) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    ...
                } else if (nums[mid] < target) {
                    left = ...
                } else if (nums[mid] > target) {
                    right = ...
                }
            }
            return ...;
        }
        ```

    * 场景
        * 寻找一个数
        * 寻找左侧边界
        * 寻找右侧边界
* 滑动窗口
    * 框架
    
        ```
        string s, t;
        // 在 s 中寻找 t 的「最小覆盖子串」
        int left = 0, right = 0;
        string res = s;

        while(right < s.size()) {
            window.add(s[right]);
            right++;
            // 如果符合要求，移动 left 缩小窗口
            while (window 符合要求) {
                // 如果这个窗口的子串更短，则更新 res
                res = minLen(res, window);
                window.remove(s[left]);
                left++;
            }
        }
        return res;
        ```
    * 最小覆盖子串
        在S中找到包含T的全部字母的一个最短的子串
    * 找到字符串中所有字母异位词
        字母异位词指字母相同，但排列不同的字符串
    * 无重复字符的最长子串

* 动态规划问题
    动态规划问题的一般形式就是求最值。求解动态规划的核心问题是穷举。存在「重叠子问题」，具备「最优子结构」，正确的「状态转移方程]。
    * 斐波那契数列
    * 凑零钱问题
    * 最长递增子序列
    * 0-1背包问题
    * ...