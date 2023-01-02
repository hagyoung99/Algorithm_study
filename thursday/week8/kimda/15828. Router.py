import sys
from collections import deque

input = sys.stdin.readline
n = int(input())
q = deque()
while True:
    num = int(input())
    if num == -1:
        break
    if num != 0 and len(q) < n:
        q.append(num)
    elif num == 0:
        q.popleft()
if q:
    print(*q)
else:
    print('empty')