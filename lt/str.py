# coding: utf-8

##############################################
# 字符串乘法，大数乘法，印度乘法
def str_multiply(s1, s2):
    n1 = len(s1)
    n2 = len(s2)

    res = [0] * (n1 + n2)

    for i in range(n1-1, -1, -1):
        for j in range(n2-1, -1, -1):
            num = int(s1[i]) * int(s2[j])
            p1 = i+j
            p2 = i+j+1
            res[p2] += num
            res[p1] += int(res[p2] / 10)
            res[p2] = res[p2] % 10
    i = 0
    while res[i] == 0:
        i += 1
    return "".join([str(v) for v in res[i:]])


print(str_multiply("123", "45"))