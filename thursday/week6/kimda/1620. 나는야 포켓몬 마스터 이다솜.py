import sys
input = sys.stdin.readline
n, m = map(int, input().split())
data = {}
for i in range(1, n + 1):
    a = input().rstrip()
    data[i] = a
    data[a] = i

for j in range(m):
    w = input().rstrip()
    if w.isdigit():
        print(data[int(w)])
    else:
        print(data[str(w)])