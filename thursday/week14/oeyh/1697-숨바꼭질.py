import sys
sys.setrecursionlimit(100000)
from collections import deque
n, k = map(int, sys.stdin.readline().split())
queue = deque()
cnt = 0
result = []
def bfs(x):
    global cnt
    cnt += 1
    queue.append()
    while queue:
        if n == k:
            result.append(cnt)
            return

bfs(0)

print(min(result, key=len))