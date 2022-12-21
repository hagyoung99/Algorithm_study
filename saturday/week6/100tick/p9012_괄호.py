from collections import deque
import sys
readline = sys.stdin.readline

T = int(input())

VALIDITIES = [True] * T

for i in range(T):
    dq = deque()
    S = readline().strip()
    for s in S:
        if s == '(':
            dq.append(s)
        if s == ')':
            if len(dq) == 0:
                dq.append('ERR')
                break
            p = dq.pop()

    if len(dq) > 0:
        VALIDITIES[i] = False


for v in VALIDITIES:
    if v:
        print ('YES')
    else:
        print ('NO')