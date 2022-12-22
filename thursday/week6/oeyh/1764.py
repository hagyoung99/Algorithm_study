import sys
import time

start = time.time()
N, M = map(int, sys.stdin.readline().split())

n1 = []
n2 = []


for _ in range(N):
    n1.append(sys.stdin.readline().rstrip())

for _ in range(M):
    n2.append(sys.stdin.readline().rstrip())

result = set(n1) & set(n2)
print(len(result))
for r in sorted(result):
    print(r)
