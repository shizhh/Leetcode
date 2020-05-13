# -*- coding: utf-8 -*-
"""递归
"""

def fib(n):
    if n == 1 or n == 2:
        return 1
    return fib(n-1) + fib(n-2)


def fib2(map, n):
    if n == 1 or n == 2:
        return 1
    if map[n] != 0:
        return map[n]
    map[n] = fib2(map, n-1) + fib2(map, n-2)
    return map[n]

# map = [0] * 1000
# print(fib2(map, 6))


def coin_change(nums, target):

    def dp(n):
        if n == 0:
            return 0
        if n < 0:
            return -1
        res = float("inf")
        for i in range(len(nums)):
            res = min(res, 1+dp(n-nums[i]))
        return res if res != float("inf") else 0
    return dp(target)

def coin_change2(nums, target):
    dp = [target+1] * (target + 1)
    dp[0] = 0
    for i in range(0, target+1):
        for j in range(len(nums)):
            if i - nums[j] < 0:
                continue
            dp[i] = min(dp[i], dp[i-nums[j]]+1)
    return dp[target] if dp[target] != target+1 else -1

# nums = [1,5,10]
# print(coin_change(nums, 20))
# print(coin_change2(nums, 20))

import queue

def min_depth(root):
    if root is None:
        return 0
    queue = []  # 队列
    queue.append((root, 1))
    while queue:
        size = len(queue)
        for _ in range(size):
            cur, cur_depth = queue.pop()  # 出队列
            if cur.left is None and cur.right is None:
                return cur_depth
            if cur.left:
                queue.append((cur, cur_depth+1))
            if cur.right:
                queue.append((cur, cur_depth+1))
    return 0


def plus_one(cur, i):
    chars = [int(s) for s in cur]
    if chars[i] == 9:
        chars[i] = 0
    else:
        chars[i] += 1
    return ''.join([str(s) for s in chars])

def minus_one(cur, i):
    chars = [int(s) for s in cur]
    if chars[i] == 0:
        chars[i] = 9
    else:
        chars[i] -= 1
    return ''.join([str(s) for s in chars])


def min_count(deadends, target):
    q = queue.Queue()
    q.put("0000")
    count = 0
    visited = set()
    visited.add("0000")
    # deads = set()
    for d in deadends:
        visited.add(d)
    while not q.empty():

        qsize = q.qsize()

        for _ in range(qsize):

            cur = q.get()
            if cur == target:
                return count
            
            for i in range(4):
                cur_plus_one = plus_one(cur, i)
                if cur_plus_one not in visited:
                    q.put(cur_plus_one)
                    visited.add(cur_plus_one)
            
            for i in range(4):
                cur_minus_one = minus_one(cur, i)
                if cur_minus_one not in visited:
                    q.put(cur_minus_one)
                    visited.add(cur_minus_one)
            
        count += 1
    return -1


# print(min_count(["8888"], "0009"))
# print(minus_one("0000", 0))



def isValidBST(root, min, max):
    if root is None:
        return True
    if min is not None and root.val < min.val:
        return False
    if max is not None and root.val > max.val:
        return False
    
    return isValidBST(root.left, min, root) and isValidBST(root.right, root, max)


def nextGreateElement(nums):
    n = len(nums)
    ans = [0] * len(nums)
    stack = []
    for i in range(2*len(nums)-1, -1, -1):
        while len(stack)>0 and nums[stack[-1]%n] <= nums[i%n]:
            stack.pop()
        ans[i%n] = 0 if len(stack)==0 else stack[-1]-i
        stack.append(i)
    return ans


# nums = [73,74,75,71,69,72,76,73]
# print(nextGreateElement(nums))



def reverse(head):
    if head is None or head.next is None:
        return head
    last = reverse(head.next)
    head.next.next = head
    head.next = None
    return last


class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

    def __str__(self):
        return str(self.val)


# a1 = Node(1)
# a2 = Node(2)
# a3 = Node(3)
# a4 = Node(4)
# a5 = Node(5)
# a6 = Node(6)

# a1.next = a2
# a2.next = a3
# a3.next = a4
# a4.next = a5
# a5.next = a6

# p = a1
# while p:
#     print(p)
#     p = p.next

# q = reverse(a1)
# p = q
# while p:
#     print(p)
#     p = p.next



