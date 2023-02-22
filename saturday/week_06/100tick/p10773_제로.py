from collections import deque
import sys
readline = sys.stdin.readline

K = int(input())

NUMS = deque()
for i in range(K):
    n = int(readline())
    if n == 0:
        NUMS.pop()
    else:
        NUMS.append(n)

print(sum(NUMS))