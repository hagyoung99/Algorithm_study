import sys
input = sys.stdin.readline

N, S = map(int, input().split())

COWS = [int(input()) for _ in range(N)]
COWS.sort()

l, r = 0, N - 1
ans = 0

while l < r:
    sum = COWS[l] + COWS[r]
    if sum > S:
        r -= 1
    elif sum <= S:
        ans += r - l
        l += 1




print(ans)
