N, X = map(int, input().split())

NUMS = list(map(int, input().split()))

max = sum(NUMS[:X])
cnt = 1
sum = max
l, r = 0, X
# 20M
# X = 0.25M

while r < N:
    sum += -NUMS[l] + NUMS[r]
    l += 1
    r += 1

    if max == sum:
        cnt += 1
    elif max < sum:
        cnt = 1
        max = sum


if max == 0:
    print('SAD')
else:
    print(max)
    print(cnt)
