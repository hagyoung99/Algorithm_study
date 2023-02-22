import sys
from collections import deque
rl = sys.stdin.readline

N = int(rl().strip())

DQ = deque()

for _ in range(N):
    p = rl().strip().split()
    match p:

        case ["push", n]:
            DQ.append(int(n))
        case ["pop"]:
            if len(DQ) == 0:
                print(-1)
            else:
                print(DQ.popleft())
        case ["size"]:
            print(len(DQ))
        case ["empty"]:
            if len(DQ) == 0:
                print(1)
            else:
                print(0)
        case ["front"]:
            if len(DQ) == 0:
                print(-1)
            else:
                print(DQ[0])
        case ["back"]:
            if len(DQ) == 0:
                print(-1)
            else:
                print(DQ[-1])
