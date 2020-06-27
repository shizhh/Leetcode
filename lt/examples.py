# coding: utf-8


##############################################
# 素数问题，计算[2, num)素数的个数
def is_prime(num):
    i = 2
    while i * i < num:
        if num % i == 0:
            return False
        i += 1
    return True

def count_primes(num):
    prime_status = [1] * num
    i = 2
    while i * i < num:
        if is_prime(i):
            for j in range(i * i, num, i):
                prime_status[j] = 0
        i += 1
    
    count = 0
    for i in range(2, num):
        if prime_status[i] == 1:
            count += 1
    return count

print(count_primes(15))

##############################################
# 模幂运算
def my_power(a, k, base):
    res = 1
    a = a % base
    for _ in range(k):
        res *= a
        res %= base
    return res

def my_power2(a, k, base):
    if k == 0:
        return 1
    a = a % base
    if k % 2 == 1:
        return (a * my_power2(a, k - 1, base)) % base
    else:
        sub = my_power2(a, k / 2, base)
        return (sub * sub) % base

def super_power(a, nums, base):
    if len(nums) == 0:
        return 1
    last = nums.pop()
    part1 = my_power2(a, last, base)
    part2 = my_power2(super_power(a, nums, base), 10, base)
    return (part1 * part2) % base

nums = [1,1,0]
print(super_power(2, nums, 1337))

##############################################
# 如何运用二分查找  ==>  搜索空间有序   ==>   Koko吃香蕉
def get_max_speed(piles):
    return max(piles)

def can_finish(piles, speed, H):
    time = 0
    for pile in piles:
        time += int(pile / speed) + (1 if (pile % speed) > 0 else 0)
    return time <= H

def min_eating_speed(piles, H):
    max_speed = get_max_speed(piles)
    for speed in range(1, max_speed + 1, 1):
        if can_finish(piles, speed, H):
            return speed
    return max_speed

# 寻找左侧边界的二分查找
def min_eating_speed2(piles, H):
    max_speed = get_max_speed(piles)
    left = 1
    right = max_speed
    while left <= right:
        mid = left + int((right - left) / 2)
        if can_finish(piles, mid, H):
            right = mid - 1
        else:
            left = mid + 1
    return left

piles = [3, 6, 7, 11]
H = 8
print(min_eating_speed2(piles, H))

##############################################
# 如何运用二分查找  ==>  搜索空间有序   ==>   船最小载重
def can_finish_ship(weights, cap, D):
    i = 0
    for _ in range(D):
        cur_cap = cap
        while cur_cap >= weights[i]:
            cur_cap -= weights[i]
            i += 1
            if i == len(weights):
                return True
    return False

def min_capacity_ship_with_days(weights, D):
    min_cap = max(weights)
    max_cap = sum(weights)
    left = min_cap
    right = max_cap
    while left <= right:
        mid = left + int((right - left) / 2)
        if can_finish_ship(weights, mid, D):
            right = mid - 1
        else:
            left = mid + 1
    return left

weights = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
D = 5
print(min_capacity_ship_with_days(weights, D))