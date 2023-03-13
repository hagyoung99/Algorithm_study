from itertools import combinations

N, M = map(int, input().split())

GRF = [[0] * (N+1) for _ in range(N+1)]

for i in range(M):
    a, b = map(int, input().split())
    GRF[a][b] = 1
    GRF[b][a] = 1

ANS = 0

for a, b, c in combinations(range(1, N+1), 3):
    if not GRF[a][b] and not GRF[b][c] and not GRF[c][a]:
        ANS += 1

print(ANS)
