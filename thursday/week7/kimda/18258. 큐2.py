import sys
from collections import deque
input = sys.stdin.readline
n = int(input())
q = deque()
for i in range(n):
    sign = input().split()
    if sign[0] == 'push':
        q.append(sign[1])
    elif sign[0] == 'pop':
        if len(q) == 0:
            print(-1)
        else:
            print(q.popleft())
    elif sign[0] == 'size':
        print(len(q))
    elif sign[0] == 'empty':
        if len(q) == 0:
            print(1)
        else:
            print(0)
    elif sign[0] == 'front':
        if len(q) == 0:
            print(-1)
        else:
            print(q[0])
    elif sign[0] == 'back':
        if len(q) == 0:
            print(-1)
        else:
            print(q[-1])