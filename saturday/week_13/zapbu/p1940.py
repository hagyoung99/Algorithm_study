N = int(input())
M = int(input())

NUMS = sorted(list(map(int, input().split())))
CNT = 0

lo = 0
hi = N-1

while lo < hi:
    a, b = NUMS[lo], NUMS[hi]
    if a+b < M:
        lo += 1
    elif a+b > M:
        hi -= 1
    else:
        lo += 1
        hi -= 1
        CNT += 1

print(CNT)
