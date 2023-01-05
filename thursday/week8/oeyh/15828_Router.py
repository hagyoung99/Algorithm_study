import sys
from collections import deque

dq = deque()
N = int(sys.stdin.readline())
flag = True

while flag:
    data = int(sys.stdin.readline())
    if data == -1:
        flag = False
    elif data == 0:
        dq.popleft()
    else:
        if len(dq) < N:
            dq.append(data)

print(' '.join(map(str, list(dq))) if len(dq) != 0 else 'empty')


