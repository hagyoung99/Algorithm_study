import sys
input = sys.stdin.readline

N, C = map(int, input().split())
home = []
for _ in range(N):
    home.append(int(input()))
home.sort()

left = 1
right = home[-1]
answer = 0
while left <= right:
    mid = (left + right) // 2
    curr_home = home[0]
    cnt = 1
    for i in range(1, N):
        if home[i] - curr_home >= mid:
            cnt += 1
            curr_home = home[i]
    if cnt >= C:
        answer = mid
        left = mid + 1

    else:
        right = mid - 1

print(answer)
