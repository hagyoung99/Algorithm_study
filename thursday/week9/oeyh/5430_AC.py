import sys
from collections import deque

T = int(sys.stdin.readline())


for _ in range(T):
    p = sys.stdin.readline()
    n = int(sys.stdin.readline())
    array = deque(sys.stdin.readline().rstrip()[1:-1].split(","))
    flag = True
    cnt = 0
    if n == 0:
        array = deque()

    for f in p:
        if f == "R":
            cnt += 1
        elif f == "D":
            if len(array) == 0:
                flag = False
            else:
                if cnt % 2 == 0:
                    array.popleft()
                else:
                    array.pop()

    if flag:
        if cnt % 2 != 0:
            array.reverse()
        print("[" + ",".join(list(array)) + "]")
    else:
        print("error")
