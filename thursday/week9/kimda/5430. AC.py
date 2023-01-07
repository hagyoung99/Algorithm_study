import sys
from collections import deque
input = sys.stdin.readline
T = int(input())
for tc in range(T):
    p = input().rstrip()
    n = int(input())
    nums = deque(input().rstrip()[1:-1].split(','))

    if n == 0:
        nums = deque()
    check = 0
    temp = 0

    for i in p:
        if i == 'R':
            check += 1
        elif i == 'D':
            if len(nums) == 0:
                print('error')
                temp = 1
                break
            else:
                if check % 2 == 0:
                    nums.popleft()
                else:
                    nums.pop()

    if temp == 0:
        if check % 2 ==0:
            print('['+','.join(nums)+']')
        else:
            nums.reverse()
            print('[' + ','.join(nums) + ']')