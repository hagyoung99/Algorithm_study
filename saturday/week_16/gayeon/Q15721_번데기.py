from collections import defaultdict
import sys
input = sys.stdin.readline

N = int(input())
A, B, C, D = [], [], [], []
for _ in range(N):
    a, b, c, d = map(int, input().split())
    A.append(a)
    B.append(b)
    C.append(c)
    D.append(d)

AB = defaultdict(int)
for i in range(N):
    for j in range(N):
        ab = A[i] + B[j]
        AB[ab] += 1

result = 0
for i in range(N):
    for j in range(N):
        cd = -(C[i] + D[j])

        if cd in AB:
            result += AB[cd]

print(result)