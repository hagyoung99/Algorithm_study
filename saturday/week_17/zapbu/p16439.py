from itertools import combinations

N, M = map(int, input().split())

ARR = [list(map(int, input().split())) for _ in range(N)]

ANS = 0

for i, j, k in combinations(range(M), 3):
    total = 0
    for x in range(N):
        total += max(ARR[x][i], ARR[x][j], ARR[x][k])
    if total > ANS:
        ANS = total


print(ANS)
