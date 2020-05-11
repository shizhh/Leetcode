# coding: utf-8
import copy

"""
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
"""

##############################################
# N queens
def solve_n_queens(N):
    board = [['.'] * N for _ in range(N)]
    res = []
    backtrack_n_queens(board, 0, res)
    return res

def backtrack_n_queens(board, row, res):
    if row == len(board):
        res.append(copy.deepcopy(board))
        return
    
    for col in range(len(board[0])):
        if not is_valid(board, col, row):
            continue
        board[row][col] = 'Q'
        backtrack_n_queens(board, row+1, res)
        board[row][col] = '.'

def is_valid(board, col, row):
    n = len(board)
    # 检查上方的列
    for i in range(row):
        if board[i][col] == 'Q':
            return False
    # 检查右上方
    i = row - 1
    j = col + 1
    while i >= 0 and j < n:
        if board[i][j] == 'Q':
            return False
        i -= 1
        j += 1
    # 检查左上方
    i = row - 1
    j = col - 1
    while i >= 0 and j >= 0:
        if board[i][j] == 'Q':
            return False
        i -= 1
        j -= 1
    return True

# print(solve_n_queens(4))

##############################################
# permute
def solve_permute(nums):
    res = []
    visited = [0] * len(nums)
    backtrack_permute(nums, visited, [], res)
    return res

def backtrack_permute(nums, visited, cur_permute, res):
    if len(cur_permute) == len(nums):
        res.append(copy.deepcopy(cur_permute))
        return
    
    for i in range(len(nums)):
        if visited[i] == 1:
            continue
        visited[i] = 1
        cur_permute.append(nums[i])
        backtrack_permute(nums, visited, cur_permute, res)
        visited[i] = 0
        cur_permute.pop()
    
# nums = [1,2,3]
# print(solve_permute(nums))


##############################################
# subsets
def solve_subsets(nums):
    res = []
    backtrack_subsets(nums, 0, [], res)
    return res

def backtrack_subsets(nums, start, cur_subset, res):
    res.append(cur_subset[:])
    for i in range(start, len(nums)):
        cur_subset.append(nums[i])
        backtrack_subsets(nums, i+1, cur_subset, res)
        cur_subset.pop()

# nums = [1,2,3]
# print(solve_subsets(nums))

##############################################
# combine
def solve_combine(n, k):
    res = []
    if k <= 0 or n <= 0 or k > n:
        return res
    backtrack_combine(n, k, 1, [], res)
    return res

def backtrack_combine(n, k, start, cur_combine, res):
    if len(cur_combine) == k:
        res.append(cur_combine[:])
        return

    for i in range(start, n+1):
        cur_combine.append(i)
        backtrack_combine(n, k, i+1, cur_combine, res)
        cur_combine.pop()

# print(solve_combine(4, 2))


##############################################
# parentheses  括号生成
def solve_parentheses(n):
    res = []
    backtrack_parentheses(n, n, [], res)
    new_res = []
    for r in res:
        new_res.append("".join(r))
    return new_res

def backtrack_parentheses(left, right, track, res):
    """
    left  => 剩余的左括号数
    right => 剩余的右括号数
    """
    if left == 0 and right == 0:
        res.append(copy.deepcopy(track))
        return
    if left < 0 or right < 0 or left > right:
        return
    
    track.append("(")
    backtrack_parentheses(left-1, right, track, res)
    track.pop()

    track.append(")")
    backtrack_parentheses(left, right-1, track, res)
    track.pop()

print(solve_parentheses(3))

