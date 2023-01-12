import sys

N, C = map(int, sys.stdin.readline().split())
weight = list(map(int, sys.stdin.readline().split()))

end = 0
subtotal = 0
cnt = 0

for start in range(N):
    while subtotal < C and end < N:
        subtotal += weight[end]
        end += 1

    if subtotal == C:
        cnt += 1

    subtotal -= weight[start]

print(cnt)