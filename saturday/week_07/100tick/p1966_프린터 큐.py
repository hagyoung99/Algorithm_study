import sys
from collections import deque

readline = sys.stdin.readline

ANS = []
N = int(readline().strip())
for _ in range(N):
    M, targetIdx = map(int, input().split())
    DOCS = list(map(int, input().split()))
    targetVal = DOCS[targetIdx]
    cnt = 1
    while 1:
        maxVal = max(DOCS)
        frontVal = DOCS[0]
        # front < max
        if frontVal < maxVal:
            if targetIdx == 0:
                targetIdx = len(DOCS)-1
            else:
                targetIdx -= 1
            DOCS.append(DOCS.pop(0))

        if frontVal == maxVal:
            if targetIdx == 0:
                break
            else:
                DOCS.pop(0)
                targetIdx -= 1
                cnt += 1
    ANS.append(cnt)

for ans in ANS:
    print(ans)
