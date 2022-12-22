import sys

n, m = map(int, sys.stdin.readline().split())
poketmon = {}

for i in range(1, n+1):
    a = sys.stdin.readline().rstrip()
    poketmon[i] = a
    poketmon[a] = i

for i in range(m):
    q = sys.stdin.readline().rstrip()
    if q.isdigit():
        print(poketmon[int(q)])
    else:
        # print(k for k, v in poketmon.items() if v == q)
        print(poketmon[q])

