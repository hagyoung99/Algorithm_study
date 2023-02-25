N, M = map(int, input().split())

NUMS = list(map(int, input().split()))

l, r = 0, 1
total = NUMS[0]

# 합이 M이 되는 경우의 수
ANS = 0

# N까지 루프
while 1:
    # 합이 M보다 작은 경우
    if total < M:
        # 우측으로 1칸 이동
        if r < N:
            total += NUMS[r]
            r += 1
        # 우측이 경계(N)를 벗어나는 경우, 종료
        else:
            break
    # 합이 M인 경우
    elif total == M:
        # 경우의 수 1 증가
        ANS += 1
        # 좌측으로 1칸 이동
        total -= NUMS[l]
        l += 1
    # 합이 M보다 큰 경우
    else:
        total -= NUMS[l]
        l += 1

print(ANS)
