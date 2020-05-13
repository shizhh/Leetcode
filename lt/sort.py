# -*- coding: utf-8 -*-

"""
排序
"""

def reverse(nums, i, j):
    # i = 0
    # j = len(nums) - 1
    while i < j:
        t = nums[i]
        nums[i] = nums[j]
        nums[j] = t
        i += 1
        j -= 1

def sort_cakes_core(cakes, n, res):
    if n == 1:
        return
    maxIndex = 0
    for i in range(1, n):
        if cakes[i] > cakes[maxIndex]:
            maxIndex = i
    reverse(cakes, 0, maxIndex)
    if maxIndex > 0:
        res.append(maxIndex+1)
    
    reverse(cakes, 0, n-1)
    if n - 1 > 0:
        res.append(n)
    sort_cakes_core(cakes, n-1, res)

def sort_cakes(cakes):
    res = []
    sort_cakes_core(cakes, len(cakes), res)
    return res

cakes = [3,2,4,1]
print(sort_cakes(cakes))

