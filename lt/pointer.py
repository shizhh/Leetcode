# -*- coding: utf-8 -*-

"""
left, right = 0, 0
while right < slen:
    ch = s[right]
    window.add(ch)
    right += 1
    
    while left符合需要向右移动的条件:
        # 计算结果
        ch = s[left]
        window.remove(ch)
        left += 1
    # 计算结果
"""

##############################################
# 找出在s中包含t的最小子串
def minSubString(s, t):
    slen = len(s)
    tlen = len(t)
    left = 0
    right = 0
    res = s
    minlen = slen
    tcount = {}
    for ch in t:
        tcount[ch] = tcount.get(ch, 0) + 1
    window = {}
    match = 0
    need_match = len(tcount)
    while right < slen:
        ch = s[right]
        if ch in tcount:
           window[ch] = window.get(ch, 0) + 1
           if window[ch] == tcount[ch]:
               match += 1
        
        while match == need_match:
            if right - left + 1 < minlen:
                minlen = right - left + 1
                res = s[left: right+1]
            ch = s[left]
            if ch in tcount:
                window[ch] = window[ch] - 1
                if window[ch] < tcount[ch]:
                    match -= 1
            left += 1
        right += 1
    return res

s = "ebbancf"
t = "abbc"
print(minSubString(s, t))


##############################################
# 找出在s中t的异位词
def findEccString(s, t):
    slen = len(s)
    tlen = len(t)
    left = 0
    right = 0
    res = []
    tcount = {}
    for ch in t:
        tcount[ch] = tcount.get(ch, 0) + 1
    window = {}
    match = 0
    need_match = len(tcount)
    while right < slen:
        ch = s[right]
        if ch in tcount:
           window[ch] = window.get(ch, 0) + 1
           if window[ch] == tcount[ch]:
               match += 1
        
        while match == need_match:
            if right - left + 1 == tlen:
                res.append(left)
            ch = s[left]
            if ch in tcount:
                window[ch] = window[ch] - 1
                if window[ch] < tcount[ch]:
                    match -= 1
            left += 1
        right += 1
    return res

# s = "cbaebabacd"
# t = "abc"
# print(findEccString(s, t))


##############################################
# 找出在s中不重复的最长子串
def findLongestSubString(s):
    slen = len(s)
    left = 0
    right = 0
    maxlen = 0
    window = {}
    while right < slen:
        rch = s[right]
        window[rch] = window.get(rch, 0) + 1
        
        while window[rch] > 1:
            lch = s[left]
            window[lch] = window[lch] - 1
            left += 1
        if right - left + 1 > maxlen:
            maxlen = right - left + 1
        right += 1
    return maxlen

# s = "bbbbbbb"
# print(findLongestSubString(s))



    