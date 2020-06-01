# coding: utf-8


##############################################
# 区间合并
def merge(intervals):
    intervals.sort(key=lambda x: x[0])
    res = []
    res.append(intervals[0])
    for i in range(1, len(intervals)):
        cur = intervals[i]
        last = res[-1]
        if cur[0] <= last[1]:
            last[1] = max(cur[1], last[1])
        else:
            res.append(cur)
    return res


intervals = [[2, 6], [1, 3], [8, 10], [15, 18]]
print(merge(intervals))


##############################################
# 区间交集
def intersection(A, B):
    i, j = 0, 0
    res = []
    while i < len(A) and j < len(B):
        a1, a2 = A[i]
        b1, b2 = B[j]
        if a2 >= b1 and b2 >= a1:
            res.append([max(a1, b1), min(a2, b2)])
        if a2 > b2:
            j += 1
        else:
            i += 1
    return res


A = [[0, 2], [5, 10], [13, 23], [24, 25]]
B = [[1, 5], [8, 12], [15, 24], [25, 26]]
print(intersection(A, B))
