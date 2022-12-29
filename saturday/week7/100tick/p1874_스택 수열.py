import sys
from collections import deque

readline = sys.stdin.readline

N = int(readline().strip())
next_n = 1

A = 1
B = deque()
C = deque()
OUTPUT = ''

for i in range(N):
    n = int(readline().strip())

    while A <= N and A <= n:
        B.append(A)
        A += 1
        OUTPUT += '+\n'

    next_n = -1
    while len(B) > 0 and next_n != n:
        next_n = B.pop()

    if next_n == n:
        C.append(next_n)
        OUTPUT += '-\n'
    else:
        OUTPUT = 'NO'
        break

print(OUTPUT)
