input()
NUMS = sorted(list(map(int, input().split())))
N = int(input())

lo = 0
hi = len(NUMS)-1
CNT = 0

while lo < hi:
    s = NUMS[lo] + NUMS[hi]

    if s == N:
        CNT += 1
        lo += 1
        hi -= 1

    elif s < N:
        lo += 1

    elif s > N:
        hi -= 1

print(CNT)
