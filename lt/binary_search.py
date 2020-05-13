"""
1, 注意搜索区间 left , right 是否是len(nums) or len(nums)-1
2, 注意收缩边界 查找左边界收缩右边的值，查找有边界收缩左边的值
3, 注意返回值。while left <= right:   # 终止条件是left = right + 1
    看 nums[mid] == target时，收缩的是哪个边界，比如right=mid+1，所以mid = right-1=left,返回就是left,
    所以就要注意left的出界情况。
"""


def left_bound(nums, target):
    if nums is None or len(nums) < 1:
        return -1
    left = 0
    right = len(nums) -1
    while left <= right:    
        mid = int(left + (right-left) / 2)
        if nums[mid] < target:
            left = mid + 1
        elif nums[mid] > target:
            right = mid - 1
        elif nums[mid] == target:
            right = mid - 1
    if left >= len(nums) or nums[left] != target:
        return -1
    return left

def left_bound2(nums, target):
    if nums is None or len(nums) < 1:
        return -1
    left = 0
    right = len(nums)
    while left < right:
        mid = int(left + (right-left) / 2)
        if nums[mid] < target:
            left = mid + 1
        elif nums[mid] > target:
            right = mid
        elif nums[mid] == target:
            right = mid
    if left >= len(nums) or nums[left] != target:
        return -1
    return left

# nums = [1,2,2,3]
# print(left_bound(nums, 2))
# print(left_bound2(nums, 2))
    

def right_bound(nums, target):
    if nums is None or len(nums) < 1:
        return -1
    left = 0
    right = len(nums)
    while left < right:
        mid = int(left + (right-left)/2)
        if nums[mid] < target:
            left = mid + 1
        elif nums[mid] > target:
            right = mid
        elif nums[mid] == target:
            left = mid + 1
    if left >= len(nums) or nums[left-1] != target:
        return -1
    return left - 1


def right_bound2(nums, target):
    if nums is None or len(nums) < 1:
        return -1
    left = 0
    right = len(nums) - 1
    while left <= right:
        mid = int(left + (right-left)/2)
        if nums[mid] < target:
            left = mid + 1
        elif nums[mid] > target:
            right = mid -1
        elif nums[mid] == target:
            left = mid + 1
    if right < 0 or nums[right] != target:
        return -1
    return right

nums = [2,3,3,3]
print(right_bound(nums, 4))
print(right_bound2(nums, 4))



def left_bound_3(nums, target):
    if nums is None or len(nums) < 1:
        return -1
    left = 0
    right = len(nums) - 1
    while left <= right:
        mid = int(left + (right-left)/2)
        if nums[mid] < target:
            left = mid + 1
        elif nums[mid] > target:
            right = mid - 1
        elif nums[mid] == target:
            right = mid - 1
    if left >= len(nums) or nums[left] != target:
        return -1
    return left