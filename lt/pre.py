##############################################
# 
def subArraySum(nums, target):
    ret_count = 0
    sum_of = [0]
    for i in range(len(nums)):
        sum_of.append(sum_of[i]+nums[i])
    
    for i in range(1, len(nums)+1):
        for j in range(0, i):
            if sum_of[i] - sum_of[j] == target:
                ret_count += 1
    return ret_count


def subArraySum2(nums, target):
    ret_count = 0
    sum_of_i = 0
    sumof = {}
    for i in range(len(nums)):
        sum_of_i += nums[i]
        sum_of_j = sum_of_i - target
        if sum_of_j in sumof:
            ret_count += sumof[sum_of_j]
        sumof[sum_of_i] = sumof.get(sum_of_i, 0) + 1
    return ret_count


nums = [3,5,2,-2,4,1]
print(subArraySum2(nums, 5))