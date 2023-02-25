N, K = map(int, input().split())

NUMS = list(map(int, input().split()))



l, r = 0, K-1
total = sum(NUMS[:K])
ANS = total

while r < N-1:

    r += 1
    total += NUMS[r] - NUMS[l]
    l += 1


    if total > ANS:
        ANS = total

    # 1 -> -6 -> -13 -> -9 -> 3 -> 10 -> 20 -> 21 -> 5


print(ANS)
