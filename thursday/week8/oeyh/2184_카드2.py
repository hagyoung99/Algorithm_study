import sys
from collections import deque

N = int(sys.stdin.readline())
q = deque()

for i in range(1, N+1):
    q.append(i)

while len(q) != 1:
    q.popleft()
    if len(q) == 1:
        break
    q.append(q.popleft())
print(q.pop())