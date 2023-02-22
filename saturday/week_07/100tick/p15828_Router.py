import sys
from collections import deque
rl = sys.stdin.readline

N = int(rl().strip())

DQ = deque()

while 1:
    n = int(rl().strip())
    if n == -1:
        break

    if n == 0:
        DQ.popleft()
    elif len(DQ) < N:
        DQ.append(n)


if len(DQ) == 0:
    print("empty")
else:
    print(*DQ)
