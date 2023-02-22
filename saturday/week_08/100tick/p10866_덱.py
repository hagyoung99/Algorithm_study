import sys
from collections import deque

readline = sys.stdin.readline

N = int(readline().strip())

S = deque()
OUTPUT = ''

for _ in range(N):
    args = readline().strip().split()

    match args:
        case ['push_back', x]:
            S.append(int(args[1]))
        case ['push_front', x]:
            S.appendleft(int(args[1]))
        case ['pop_front']:
            if len(S) == 0:
                OUTPUT += '-1\n'
            else:
                OUTPUT += str(S.popleft()) + '\n'
        case ['pop_back']:
            if len(S) == 0:
                OUTPUT += '-1\n'
            else:
                OUTPUT += str(S.pop()) + '\n'
        case ['size']:
            OUTPUT += str(len(S)) + '\n'
        case ['empty']:
            if len(S) > 0:
                OUTPUT += '0\n'
            else:
                OUTPUT += '1\n'
        case ['front']:
            if len(S) == 0:
                OUTPUT += '-1\n'
            else:
                OUTPUT += str(S[0]) + '\n'
        case ['back']:
            if len(S) == 0:
                OUTPUT += '-1\n'
            else:
                OUTPUT += str(S[-1]) + '\n'

print(OUTPUT)
