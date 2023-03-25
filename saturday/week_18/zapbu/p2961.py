from itertools import combinations

N = int(input())
# 각 재료의 (신맛, 쓴맛)
FOODS = [list(map(int, input().split())) for _ in range(N)]

# 가장 차이가 적은 (신맛, 쓴맛)
ANS = 1e9

#  음식의 신맛은 사용한 재료의 신맛의 곱이고, 쓴맛은 합

for i in range(1, N+1):
    for comb in combinations(FOODS, i):
        total_s = 1
        total_b = 0

        for s, b in comb:
            total_s *= s
            total_b += b

        diff = abs(total_s - total_b)
        ANS = min(ANS, diff)

print(ANS)
