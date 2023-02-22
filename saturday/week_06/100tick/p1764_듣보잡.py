import sys
input = sys.stdin.readline

N, M = map(int, input().split())

NAMES1 = [input().strip() for _ in range(N)]

NAMES2 = [input().strip() for _ in range(M)]

s = {}
ans = []

for name in NAMES1:
    s[name] = True
for name in NAMES2:
    if name in s:
        ans.append(name)

print(len(ans))
    print(*sorted(ans), sep='\n')
    