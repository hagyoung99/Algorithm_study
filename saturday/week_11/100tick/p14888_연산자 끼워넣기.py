# IMPORT
import sys

# INPUT
N = int(input())
NUMS = list(map(int, input().split()))
ADD_CNT, SUB_CNT, MUL_CNT, DIV_CNT = map(int, input().split())

MIN = sys.maxsize
MAX = -sys.maxsize


# LOGIC
def dfs(add_cnt, sub_cnt, mul_cnt, div_cnt, total, idx):
    global MIN, MAX

    if idx == N:
        MAX = max(MAX, total)
        MIN = min(MIN, total)
        return

    if add_cnt > 0:
        dfs(add_cnt - 1, sub_cnt, mul_cnt, div_cnt, total + NUMS[idx], idx + 1)

    if sub_cnt > 0:
        dfs(add_cnt, sub_cnt - 1, mul_cnt, div_cnt, total - NUMS[idx], idx + 1)

    if mul_cnt > 0:
        dfs(add_cnt, sub_cnt, mul_cnt - 1, div_cnt, total * NUMS[idx], idx + 1)

    if div_cnt > 0:
        dfs(add_cnt, sub_cnt, mul_cnt, div_cnt - 1, int(total / NUMS[idx]), idx + 1)


dfs(ADD_CNT, SUB_CNT, MUL_CNT, DIV_CNT, NUMS[0], 1)

# OUTPUT
print(MAX, MIN, sep="\n")
