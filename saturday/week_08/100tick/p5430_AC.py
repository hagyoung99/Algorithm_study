from collections import deque
import sys
rl = sys.stdin.readline

T = int(rl())

for i in range(T):
    FNS = list(rl().strip())
    N = int(rl())
    NUMS = deque(filter(lambda v: len(v) > 0, rl().strip()[1:-1].split(',')))
    is_error = False
    is_reversed = False
    for fn in FNS:
        if fn == 'R':
            is_reversed = not is_reversed
        elif fn == 'D':
            if len(NUMS) == 0:
                is_error = True
                break
            else:
                if is_reversed:
                    NUMS.pop()
                else:
                    NUMS.popleft()

    if is_error:
        print('error')
    else:
        if is_reversed:
            print('[' + ','.join(list(NUMS)[::-1]) + ']')
        else:
            print('[' + ','.join(NUMS) + ']')
