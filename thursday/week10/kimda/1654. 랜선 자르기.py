import sys
input = sys.stdin.readline

k, n = map(int, input().split())
data = [int(input()) for _ in range(k)]

start, end = 1, max(data)
res = 0
while start <= end:
    mid = (start + end) // 2
    total = 0
    for i in data:
        total += i // mid

    if total >= n:
        start = mid + 1
        res = mid
    else:
        end = mid - 1
print(res)