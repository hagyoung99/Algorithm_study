import sys
from collections import deque

rl = sys.stdin.readline

N, M = map(int, rl().split())

dq = deque()


def go(n):
    if len(dq) == M:
        print(*dq)
        return

    for i in range(n, N + 1):
        dq.append(i)
        go(i)
        dq.pop()


go(1)
