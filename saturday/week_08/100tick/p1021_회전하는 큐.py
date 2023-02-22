from collections import deque
import copy

N, M = map(int, input().split())
DQ = deque([n for n in range(1, N+1)])

NUMS = list(map(int, input().split()))

CNT = 0
for n in NUMS:
    DQ1 = copy.deepcopy(DQ)
    DQ2 = copy.deepcopy(DQ)
    CNT1 = 0
    CNT2 = 0
    while DQ1[0] != n:
        DQ1.rotate(-1)
        CNT1 += 1

    while DQ2[0] != n:
        DQ2.rotate(1)
        CNT2 += 1

    if CNT1 < CNT2:
        CNT += CNT1
        DQ = DQ1
    else:
        CNT += CNT2
        DQ = DQ2
    DQ.popleft()


print(CNT)
