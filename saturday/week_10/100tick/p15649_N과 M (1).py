from itertools import permutations

N, M = map(int, input().split())

combs = permutations(range(1, N+1), M)

for comb in combs:
    print(*comb)
