from collections import deque
import sys
readline = sys.stdin.readline

N = int(readline())
STACK = deque()
INSTRUCTIONS = [readline().strip() for _ in range(N)]

for inst in INSTRUCTIONS:
    data = inst.split()
    if len(data) == 2:
        STACK.append(int(data[1]))
    elif inst == 'pop':
        if len(STACK) == 0:
            print(-1)
        else:
            print(STACK.pop())
    elif inst == 'size':
        print(len(STACK))
    elif inst == 'empty':
        if len(STACK) == 0:
            print(1)
        else:
            print(0)
    else:
        if len(STACK) == 0:
            print(-1)
        else:
            print(STACK[-1])

