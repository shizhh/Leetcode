# -*- coding: utf-8 -*-
from typing import List


def isdigit(ch):
    return ch.isdigit()


def calculate(s: str) -> int:

    def helper(s: List) -> int:
        num = 0
        stack = []
        sign = "+"
        while len(s) > 0:
            c = s.pop(0)
            if isdigit(c):
                num = num * 10 + int(c)
            
            if c == "(":
                num = helper(s)
            
            if (not isdigit(c) and c != ' ') or len(s) == 0:
                if sign == "+":
                    stack.append(num)
                elif sign == '-':
                    stack.append(-num)
                elif sign == "*":
                    stack[-1] = stack[-1] * num
                    # pre = stack.pop()
                    # stack.append(pre * num)
                elif sign == "/":
                    stack[-1] = int(stack[-1] / num)
                    # pre = stack.pop()
                    # stack.append(pre / num)
                sign = c
                num = 0
            
            if c == ")":
                break
        return sum(stack)
    return helper(list(s))

print(calculate("2*(3-4)"))