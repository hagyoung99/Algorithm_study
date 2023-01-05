import sys
from collections import deque

N = int(sys.stdin.readline())

q = deque()

for _ in range(N):
    order = sys.stdin.readline().rstrip()

    if order == "pop":
        print(q.popleft() if len(q) != 0 else -1)
    elif order == 'size':
        print(len(q))
    elif order == 'empty':
        print(1 if len(q) == 0 else 0)
    elif order == 'front':
        print(q[0] if len(q) != 0 else -1)
    elif order == 'back':
        print(q[-1] if len(q) != 0 else -1)
    else:
        q.append(order.split()[1])
