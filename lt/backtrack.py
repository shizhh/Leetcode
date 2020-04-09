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
    for i in range(n):
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